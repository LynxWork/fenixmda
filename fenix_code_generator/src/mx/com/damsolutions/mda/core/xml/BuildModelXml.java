package mx.com.damsolutions.mda.core.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException; 
import mx.com.damsolutions.mda.metamodel.DataTypeFactory;
import mx.com.damsolutions.mda.metamodel.Entity;
import mx.com.damsolutions.mda.metamodel.Property;
import mx.com.damsolutions.mda.metamodel.RegularExpressionsFactory;
import mx.com.damsolutions.mda.technology.jee.mvc.model.impl.EjbEntity;
import mx.com.damsolutions.mda.technology.jee.mvc.dao.impl.EjbDao;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.cmp.FormCmp;
import mx.com.damsolutions.mda.util.file.WriteSourceFile;


public class BuildModelXml {


	public void readModelXml(){

	}

	public static void main(String argv []){
		BuildModelXml buildModel = new BuildModelXml();
		buildModel.buildModel();
	}//end of main


	public void buildModel(){
		try {

			//JSFCodeGenerator builder = new JSFCodeGenerator();
			FormCmp form = null;
			
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse (new File("C:/Users/jvargas/Dropbox/PRO/FENIX/fenix_code_generator/src/mx/com/damsolutions/mda/templates/projectModel.xml"));

			// normalize text representation
			doc.getDocumentElement ().normalize ();
			System.out.println ("Root element of the doc is " + doc.getDocumentElement().getNodeName());

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
			System.out.println("Domain Package Name: " + packageDomainName);
			System.out.println("Dao Package Name: " + packageDaoName);
			System.out.println("Service Package Name: " + packageServiceName);
			System.out.println("Controller Package Name: " + packageControllerName);
			//************************************************************************************

			//Se obtiene la lista de entidades del modelo
			NodeList listOfEntity = doc.getElementsByTagName("entity");
			List<Entity> entities = getEntities(listOfEntity,packageDomainName);
			for(Entity entity: entities){
				//Consturir el formulario
				//String strForm = builder.buildForm(entity);
				form = new FormCmp(entity);
				String strForm = form.toString();
				System.out.println("form: " + strForm );
				
				//Se crea la pagina XHTML*****************************************************************
				WriteSourceFile writeFile = new WriteSourceFile();
				String directory = "C://Users//jvargas//Dropbox//PRO//FENIX//fenix_generated_project//src//main//webapp//view//";
				String fileName = entity.getName() + "Form";
				String extencion = ".xhtml";
				writeFile.writeFile(strForm, directory, fileName, extencion);
				//****************************************************************************************
				
				//Se crean las clases de entidad*****************************************************************
				EjbEntity ejb = new EjbEntity(entity);
				String strEjb = ejb.toString();
				WriteSourceFile writeEjbFile = new WriteSourceFile();
				String ejbDirectory = "C://Users//jvargas//Dropbox//PRO//FENIX//fenix_generated_project//src//main//java//com//lynxwork//erp//security//domain//";
				String ejbFileName = entity.getName() + "";
				String ejbExtencion = ".java";
				writeEjbFile.writeFile(strEjb, ejbDirectory, ejbFileName, ejbExtencion);
				//****************************************************************************************
				
				//Se crean las clases de acceso a datos con EJB Session Bean
				entity.setNamespace(packageDaoName);
				EjbDao ejbDao = new EjbDao(entity);
				String strEjbDao = ejbDao.toString();
				WriteSourceFile writeEjbDaoFile = new WriteSourceFile();
				String ejbDaoDirectory = "C://Users//jvargas//Dropbox//PRO//FENIX//fenix_generated_project//src//main//java//com//lynxwork//erp//security//dao//";
				String ejbDaoFileName = entity.getName() + "";
				String ejbDaoExtencion = ".java";
				writeEjbDaoFile.writeFile(strEjbDao, ejbDaoDirectory, ejbDaoFileName, ejbDaoExtencion);
				
			}
		}catch (SAXParseException err) {
			System.out.println ("** Parsing error" + ", line " 
					+ err.getLineNumber () + ", uri " + err.getSystemId ());
			System.out.println(" " + err.getMessage ());

		}catch (SAXException e) {
			Exception x = e.getException ();
			((x == null) ? e : x).printStackTrace ();

		}catch (Throwable t) {
			t.printStackTrace ();
		}
	}

	
	public List<Entity> getEntities(NodeList listOfEntity,String packageDomainName)
	throws SAXParseException,SAXException,Throwable {
		List<Entity> entities = new ArrayList<Entity>();
		int totalEntity = listOfEntity.getLength();
		System.out.println("Total no of entity: " + totalEntity);
		ArrayList<Property> properties = null;
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
					System.out.println("------->");
					properties.add(property);
				}
				//Se agregan las propiedades a la entidad
				entity.setProperties(properties);
				entities.add(entity);
			}
		}
		return entities;
	}
	
	public Entity setEntityValues(Element entityElement){
		System.out.println("Node: " + entityElement.getNodeName());
		System.out.println("id: " + entityElement.getAttribute("id"));
		System.out.println("name: " + entityElement.getAttribute("name"));
		System.out.println("type: " + entityElement.getAttribute("type"));
		Entity entity = new Entity();
		entity.setId( entityElement.getAttribute("id"));
		entity.setName(entityElement.getAttribute("name"));
		entity.setType(new String(entityElement.getAttribute("type")));
		return entity;
	}

	
	public Property setPropertyValues(Entity entity, Element propertyElement){
		System.out.println("Node: " + propertyElement.getNodeName());
		System.out.println("id: " + propertyElement.getAttribute("id"));
		System.out.println("name: " + propertyElement.getAttribute("name"));
		System.out.println("title: " + propertyElement.getAttribute("title"));
		System.out.println("label: " + propertyElement.getAttribute("label"));
		System.out.println("instruction: " + propertyElement.getAttribute("instruction"));
		System.out.println("description: " + propertyElement.getAttribute("description"));
		System.out.println("type: " + propertyElement.getAttribute("type"));
		System.out.println("pattern: " + propertyElement.getAttribute("pattern"));
		System.out.println("length: " + propertyElement.getAttribute("length"));
		System.out.println("width: " + propertyElement.getAttribute("width"));
		System.out.println("minimum: " + propertyElement.getAttribute("minimum"));
		System.out.println("maximum: " + propertyElement.getAttribute("maximum"));
		System.out.println("required: " + propertyElement.getAttribute("required"));
		System.out.println("order: " + propertyElement.getAttribute("order"));
		System.out.println("nillable: " + propertyElement.getAttribute("nillable"));
		System.out.println("sortable: " + propertyElement.getAttribute("sortable"));
		System.out.println("finding: " + propertyElement.getAttribute("finding"));
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

}
