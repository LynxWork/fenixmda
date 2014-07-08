package mx.com.damsolutions.mda.core.generator;

import java.io.*;
import java.util.List;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import mx.com.damsolutions.mda.metamodel.Entity;
import mx.com.damsolutions.mda.technology.jee.mvc.dao.impl.EjbDao;
import mx.com.damsolutions.mda.technology.jee.mvc.model.impl.EjbEntity;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.cmp.FormCmp;
import mx.com.damsolutions.mda.util.file.WriteSourceFile;

public class CodeGenerator {

	private static String SOURCE_DIR = "src";
	private static String BUILD_DIR = "bin";
	private static String DOC_DIR = "doc";

	private static Logger log = Logger.getLogger(CodeGenerator.class);
	
	public static void main(String arg[]){
		//create source directory

		CodeGenerator codeGenerator = new CodeGenerator();
		try {
			codeGenerator.buildApplication();
		} catch (SAXParseException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}
	

	public void buildApplication() throws SAXParseException, SAXException, Throwable{
		
		//The base directory for make project files
		String moduleName="user";
		String baseDirectory = "C:/JAVT/proyectos/LynxWorkTechnologies/FENIX_MDA/fenixmda/trunk/fenix_generated_project/src";
		String baseDirectoryClasses = baseDirectory+"/com/lynxwork/app/rh/"+moduleName;
		String baseDirectoryViewModel = baseDirectory+"/main/webapp/view/";
		String baseDirectoryServiceModel = baseDirectoryClasses +"/service/";
		String baseDirectoryIntegrationServiceModel = baseDirectoryClasses +"/integration/";
		String baseDirectoryDomainModel =  baseDirectoryClasses +"/domain/";;
		String baseDirectoryDataAccessModel =  baseDirectoryClasses +"/dao/";
		String baseDirectoryDataBaseModel = baseDirectoryClasses +"/db/";
		String baseDirectoryBusinessRuleModel = baseDirectoryClasses +"/br/";
		String baseDirectoryBusinessProcessModel = baseDirectoryClasses +"/bp/";
		
		
		//Get elements from the XML Model
		String xmlModelPath = "C:/JAVT/proyectos/LynxWorkTechnologies/FENIX_MDA/fenixmda/trunk/fenix_code_generator/src/mx/com/damsolutions/mda/templates/projectModel.xml";
		
		BuildModelXml xmlModel = new BuildModelXml(xmlModelPath);
		List<Entity> entities = xmlModel.getEntities();
		
		//Se crea la vista del Sistema
		createViewModel(entities,baseDirectoryViewModel);
		
		//Se crea el modelo de dominio
		createDomainModel(entities,baseDirectoryDomainModel);
		//Se crea la estructura del proyecto
		//createSourceDirectory(baseDirectory);
		
		//Se crea el modelo de datos
		createDataAccessModel(entities,baseDirectoryDataAccessModel);
		
		//Se crea el modelo de Servicios de Negocio
		createServiceModel();
		


	}
	

	/**
	 * Escribe el codigo en un archivo con la extencion especificada
	 * **/
	public boolean createSourceFile(String path,String fileName, String extencion,String content){
		File file;
		BufferedWriter out;
		FileWriter fstream;
		try{
			file=new File(path+fileName+extencion);
			if(!file.exists()){
				// Create file 
				fstream = new FileWriter(file);
				out = new BufferedWriter(fstream);
				out.write(content);
				out.close();
				//Close the output stream
			}
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}		return false;
	}


	/**
	 * @author Juan Arturo Vargas Torres
	 * @param entities a list of entities from the solution model
	 * Create a xhtml pages for the domain model
	 * 
	 * **/
	public void createViewModel(List<Entity> entities, String srcPath){
		//Se crea la pagina XHTML*****************************************************************
		for(Entity entity: entities){
			WriteSourceFile writeFile = new WriteSourceFile();
			FormCmp form = new FormCmp(entity);
			String strForm = form.toString();
			String directory = srcPath;
			String fileName = entity.getName() + "Form";
			String extencion = ".xhtml";
			writeFile.writeFile(strForm, directory, fileName, extencion);
		}
		//****************************************************************************************
	}

	public void createServiceModel(){
		
	}

	public void createIntegrationServiceModel(){
		
	}
	
	/**
	 * @author Juan Arturo Vargas Torres
	 * @param entities a list of entities from the solution model
	 * Create a EJB Class Entity for the domain model
	 * 
	 * **/
	public void createDomainModel(List<Entity> entities, String srcPath){
		//Se crean las clases de entidad*****************************************************************
		for(Entity entity: entities){
			EjbEntity ejb = new EjbEntity(entity);
			String strEjb = ejb.build();
			WriteSourceFile writeEjbFile = new WriteSourceFile();
			String ejbDirectory = srcPath;
			String ejbFileName = entity.getName() + "";
			String ejbExtencion = ".java";
			writeEjbFile.writeFile(strEjb, ejbDirectory, ejbFileName, ejbExtencion);
		}
		//****************************************************************************************
	}
	
	
	/**
	 * @author Juan Arturo Vargas Torres
	 * @param entities a list of entities from the solution model
	 * Create a Class DAO for the domain model
	 * 
	 * **/
	public void createDataAccessModel(List<Entity> entities, String srcPath){
		for(Entity entity: entities){
			EjbDao ejbDao = new EjbDao(entity);
			String strEjbDao = ejbDao.toString();
			WriteSourceFile writeEjbDaoFile = new WriteSourceFile();
			String ejbDaoDirectory = srcPath;
			String ejbDaoFileName = entity.getName() + "";
			String ejbDaoExtencion = "Dao.java";
			writeEjbDaoFile.writeFile(strEjbDao, ejbDaoDirectory, ejbDaoFileName, ejbDaoExtencion);
		}
	}

	public void createDataBaseModel(){
		
	}
	
	public void createBusinessRuleModel(){
		
	}
	
	public void createBusinessProcessModel(){
		
	}
	
	
	public void createSourceFile(String directoryPath,String fileName,String sourceCode){
		//Crear Archivo
		try {
			File f;
			f=new File(directoryPath+fileName);
			if(!f.exists()){
				f.createNewFile();
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public void createSourceDirectory(String basePath){

		try{

			String pathSourceDir = basePath + getFileSeparator() + SOURCE_DIR;
			File fileSourceDir = new File(pathSourceDir);
			if(fileSourceDir.exists()!= true){
				System.out.println(fileSourceDir);
				fileSourceDir.mkdirs();
			}

			//Se crea el directorio en donde va a estar el codigo de la Vista
			String pathViewModelSourceDir = basePath + getFileSeparator() + SOURCE_DIR+ getFileSeparator() +"view";
			File fileViewModelSourceDir = new File(pathViewModelSourceDir);
			if(fileViewModelSourceDir.exists()!= true){
				System.out.println(fileViewModelSourceDir);
				fileViewModelSourceDir.mkdirs();
			}

			String pathBuildDir = basePath + getFileSeparator() + BUILD_DIR;
			File fileBuildDir = new File(pathBuildDir);
			if(fileBuildDir.exists()!= true){
				fileBuildDir.mkdirs();
			}
			
			String pathDocDir = basePath + getFileSeparator() + DOC_DIR;
			File fileDocDir = new File(pathDocDir);
			if(fileDocDir.exists()!= true){
				fileDocDir.mkdirs();
			}

		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}

	} 

	public String getFileSeparator(){
		return System.getProperty("file.separator");
	}
	
}
