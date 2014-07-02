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

import mx.com.damsolutions.mda.metamodel.DataTypeFactory;
import mx.com.damsolutions.mda.metamodel.Entity;
import mx.com.damsolutions.mda.metamodel.Property;
import mx.com.damsolutions.mda.metamodel.RegularExpressionsFactory;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.cmp.FormCmp;


public class BuildModelXml {

	private static Logger log = Logger.getLogger(BuildModelXml.class);
	
	Document doc;
	
	private String namespaceDomainName;
	private String namespaceDaoName;
	private String namespaceServiceName;
	private String namespaceControllerName;
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
			String packageDomainName = "com.lynxwork.erp."+modelName+"."+moduleName+".domain";
			String packageDaoName = "com.damsolutions.erp."+modelName+"."+moduleName+".dao";
			String packageServiceName = "com.damsolutions.erp."+modelName+"."+moduleName+".service";
			String packageControllerName = "com.damsolutions.erp."+modelName+"."+moduleName+".controller";
			log.debug("Domain Package Name: " + packageDomainName);
			log.debug("Dao Package Name: " + packageDaoName);
			log.debug("Service Package Name: " + packageServiceName);
			log.debug("Controller Package Name: " + packageControllerName);
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
		String entitiesNameSpace = "";
		NodeList listOfEntity = doc.getElementsByTagName("entity");
		List<Entity> entities = getEntities(listOfEntity,entitiesNameSpace);
		return entities;
	}
	
	public List<Entity> getEntities(NodeList listOfEntity,String packageDomainName)
	throws SAXParseException,SAXException,Throwable {
		List<Entity> entities = new ArrayList<Entity>();
		int totalEntity = listOfEntity.getLength();
		log.debug("Total no of entity: " + totalEntity);
		ArrayList<Property> properties = null;
		ArrayList<Property> association = null;
		//Se procesa la lista de entidades
		for(int s=0; s<listOfEntity.getLength() ; s++){
			Node entityNode = listOfEntity.item(s);
			if(entityNode.getNodeType() == Node.ELEMENT_NODE){
				//Atributos de la entidada
				Element entityElement = (Element)entityNode;
				Entity entity = setEntityValues(entityElement);
				entity.setNamespace(packageDomainName);
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
				entities.add(entity);
				//Add the association of the entity
				NodeList entityAssociationList = entityElement.getElementsByTagName("association");
				association = new ArrayList<Property>();
			}
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
	
	public String getNamespaceDomainName() {
		return namespaceDomainName;
	}

	public String getNamespaceDaoName() {
		return namespaceDaoName;
	}

	public String getNamespaceServiceName() {
		return namespaceServiceName;
	}

	public String getNamespaceControllerName() {
		return namespaceControllerName;
	}

	public String getXmlModelPath() {
		return xmlModelPath;
	}

	public void setXmlModelPath(String xmlModelPath) {
		this.xmlModelPath = xmlModelPath;
	}



}
