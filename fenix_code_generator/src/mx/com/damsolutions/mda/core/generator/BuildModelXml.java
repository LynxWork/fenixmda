package mx.com.damsolutions.mda.core.generator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException; 

import mx.com.damsolutions.mda.metamodel.Association;
import mx.com.damsolutions.mda.metamodel.DataTypeFactory;
import mx.com.damsolutions.mda.metamodel.Entity;
import mx.com.damsolutions.mda.metamodel.Property;
import mx.com.damsolutions.mda.metamodel.RegularExpressionsFactory;


public class BuildModelXml {

	private static Logger log = Logger.getLogger(BuildModelXml.class);
	
	Document doc;
	
	private String namespaceDomain;
	private String namespaceDao;
	private String namespaceService;
	private String namespaceController;
	private String xmlModelPath;
	
	public BuildModelXml(String xmlModelPath){
		this.xmlModelPath = xmlModelPath;
		buildModel();
	}


	public void buildModel(){
		try {
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			doc = docBuilder.parse (new File(this.xmlModelPath));

			// normalize text representation
			doc.getDocumentElement ().normalize ();
			log.debug("Root element of the doc is " + doc.getDocumentElement().getNodeName());

			//Get model name
			NodeList listOfModel = doc.getElementsByTagName("domain");
			Element entityModel = (Element)listOfModel.item(0);
			String modelName = entityModel.getAttribute("name");
			
			//Nombre del dominio
			NodeList listOfDomain = doc.getElementsByTagName("domain");
			Element entityDomain = (Element)listOfDomain.item(0);
			String moduleName = entityDomain.getAttribute("name");
			
			//Se arman los paquetes*****************************************************
			String baseNamespace = "com.lynxwork.app.rh";
			this.namespaceDomain = baseNamespace+"."+moduleName+".domain";
			this.namespaceDao = baseNamespace+modelName+"."+moduleName+".dao";
			this.namespaceService = baseNamespace+modelName+"."+moduleName+".service";
			this.namespaceController = baseNamespace+modelName+"."+moduleName+".controller";
			log.debug("Domain Namespace: " + namespaceDomain);
			log.debug("Dao Package Name: " + namespaceDao);
			log.debug("Service Package Name: " + namespaceService);
			log.debug("Controller Package Name: " + namespaceController);
			//************************************************************************************

		}catch (SAXParseException err) {
			log.debug ("** Parsing error" + ", line " 
					+ err.getLineNumber () + ", uri " + err.getSystemId ());
			log.debug(" " + err.getMessage ());

		}catch (SAXException e) {
			Exception x = e.getException ();
			((x == null) ? e : x).printStackTrace ();

		}catch (Throwable t) {
			t.printStackTrace ();
		}
	}

	
	public List<Entity> getEntities()throws SAXParseException,SAXException,Throwable {
		NodeList listOfEntity = doc.getElementsByTagName("entity");
		List<Entity> entities = getEntities(listOfEntity);
		return entities;
	}
	
	public Entity getEntity(NodeList listOfEntity){
		Entity entity = new Entity();
		
		return entity;
	}
	
	public List<Entity> getEntities(NodeList listOfEntity)
	throws SAXParseException,SAXException,Throwable {
		List<Entity> entities = new ArrayList<Entity>();
		int totalEntity = listOfEntity.getLength();
		log.debug("Total no of entity: " + totalEntity);
		ArrayList<Property> properties = null;
		List<Association> associations = null;
		//Se procesa la lista de entidades
		for(int s=0; s<listOfEntity.getLength() ; s++){
			Node entityNode = listOfEntity.item(s);
			if(entityNode.getNodeType() == Node.ELEMENT_NODE){
				//Atributos de la entidada
				Element entityElement = (Element)entityNode;
				Entity entity = setEntityValues(entityElement);
				entity.setNamespace(namespaceDomain);
				//Se obtiene la lista de propiedades de la entidad
				NodeList entityPropertyList = entityElement.getElementsByTagName("property");
				properties = new ArrayList<Property>();
				for(int p=0; p<entityPropertyList.getLength() ; p++){
					//Valores de la propiedad
					Element propertyElement = (Element)entityPropertyList.item(p);
					//Se crea el objeto propiedad Property
					Property property = setPropertyValues(entity,propertyElement);
					log.debug("------->");
					properties.add(property);
				}
				//Se agregan las propiedades a la entidad
				entity.setProperties(properties);
				//Add the association of the entity
				associations = getAssociations( entityElement );
				//add the source element for eich association
				for(Association association: associations){
					association.setSourceElement(entity);
				}
				entity.setAssociation(associations);
				entities.add(entity);
			}
			
		}
		
		//Set the target element for association of eich element
		for(Entity entity: entities){
			
		}
		return entities;
	}
	
	public Entity setEntityValues(Element entityElement){
		log.debug("Node: " + entityElement.getNodeName());
		log.debug("id: " + entityElement.getAttribute("id"));
		log.debug("name: " + entityElement.getAttribute("name"));
		log.debug("type: " + entityElement.getAttribute("type"));
		Entity entity = new Entity();
		entity.setId( entityElement.getAttribute("id"));
		entity.setName(entityElement.getAttribute("name"));
		entity.setType(new String(entityElement.getAttribute("type")));
		return entity;
	}

	public List<Association> getAssociations(Element entityElement){
		NodeList entityAssociationList = entityElement.getElementsByTagName("association");
		List<Association> associations = new ArrayList<Association>();
		for(int i=0; i<entityAssociationList.getLength() ; i++){
			//Valores de la propiedad
			Element associationElement = (Element)entityAssociationList.item(i);
			//Se crea el objeto propiedad Property
			Association association = setAssociationValues(associationElement);
			log.debug("------->");
			associations.add(association);
		}
		return associations;
	}
	
	public Association setAssociationValues(Element associationElement){
		Association association = new Association();
		String type = associationElement.getAttribute("type");
		String entity = associationElement.getAttribute("entity");
		log.debug("sortable: " + type );
		//Se crea el objeto propiedad Property**************************************************
		association.setRelationType( type );
		if( type.equals("OneToMany") ){
			association.setSourceCardinality("1");
			association.setTargetCardinality("*");			
		}else if( type.equals("OneToOne") ){
			association.setSourceCardinality("1");
			association.setTargetCardinality("1");				
		}else if( type.equals("ManyToMany") ){
			association.setSourceCardinality("*");
			association.setTargetCardinality("*");				
		}else if( type.equals("ManyToOne") ){
			association.setSourceCardinality("*");
			association.setTargetCardinality("1");				
		}

		//association.setRelationTarget(relationTarget); ( associationElement.getAttribute("entity") );
		return association;
	}
	
	public Property setPropertyValues(Entity entity, Element propertyElement){
		log.debug("Node: " + propertyElement.getNodeName());
		log.debug("id: " + propertyElement.getAttribute("id"));
		log.debug("name: " + propertyElement.getAttribute("name"));
		log.debug("title: " + propertyElement.getAttribute("title"));
		log.debug("label: " + propertyElement.getAttribute("label"));
		log.debug("instruction: " + propertyElement.getAttribute("instruction"));
		log.debug("description: " + propertyElement.getAttribute("description"));
		log.debug("type: " + propertyElement.getAttribute("type"));
		log.debug("pattern: " + propertyElement.getAttribute("pattern"));
		log.debug("length: " + propertyElement.getAttribute("length"));
		log.debug("width: " + propertyElement.getAttribute("width"));
		log.debug("minimum: " + propertyElement.getAttribute("minimum"));
		log.debug("maximum: " + propertyElement.getAttribute("maximum"));
		log.debug("required: " + propertyElement.getAttribute("required"));
		log.debug("order: " + propertyElement.getAttribute("order"));
		log.debug("nillable: " + propertyElement.getAttribute("nillable"));
		log.debug("sortable: " + propertyElement.getAttribute("sortable"));
		log.debug("finding: " + propertyElement.getAttribute("finding"));
		//Se crea el objeto propiedad Property**************************************************
		Property property = new Property();
		property.setId( propertyElement.getAttribute("id") );
		property.setName(propertyElement.getAttribute("name"));
		property.setTitle(propertyElement.getAttribute("title"));
		property.setLabel(propertyElement.getAttribute("label"));
		property.setInstruction(propertyElement.getAttribute("instruction"));
		property.setDescription(propertyElement.getAttribute("description"));
		property.setDataType(DataTypeFactory.getType(propertyElement.getAttribute("type")));
		property.setRegularExpression( RegularExpressionsFactory.getInstance().getRegularExpressions("OnlyNumber") );
		property.setLenght(new Integer(propertyElement.getAttribute("length")));
		property.setWidth(new Integer(propertyElement.getAttribute("width")));
		property.setMinimum(new Integer(propertyElement.getAttribute("minimum"))); 
		property.setMaximum(new Integer(propertyElement.getAttribute("maximum")));
		property.setRequired(new Boolean(propertyElement.getAttribute("required")));
		property.setOrder(new Integer(propertyElement.getAttribute("order")));
		property.setNillable(new Boolean(propertyElement.getAttribute("nillable")));
		property.setSortable(new Boolean(propertyElement.getAttribute("sortable")));
		property.setFinding(new Boolean(propertyElement.getAttribute("finding")));
		property.setEntity(entity);
		//************************************************************************************
		return property;
	}


	/**
	 * Devuelve la estructura del codigo definido en el code template 
	 * **/
	public String getCharacterValueFromTemplate(String tagName){
		
		return "";
	}
	
	public String getNamespaceDomain() {
		return namespaceDomain;
	}

	public String getNamespaceDao() {
		return namespaceDao;
	}

	public String getNamespaceService() {
		return namespaceService;
	}

	public String getNamespaceController() {
		return namespaceController;
	}

	public String getXmlModelPath() {
		return xmlModelPath;
	}

	public void setXmlModelPath(String xmlModelPath) {
		this.xmlModelPath = xmlModelPath;
	}



}
