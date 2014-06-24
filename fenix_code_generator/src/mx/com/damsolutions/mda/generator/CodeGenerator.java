package mx.com.damsolutions.mda.generator;

import java.io.*;

import org.apache.log4j.Logger;

import mx.com.damsolutions.code.generator.java.project.web.JSFCodeGenerator;
import mx.com.damsolutions.mda.junit.generator.DummyServiceData;
import mx.com.damsolutions.mda.metamodel.Entity;

public class CodeGenerator {

	private static String SOURCE_DIR = "src";
	private static String BUILD_DIR = "bin";
	private static String DOC_DIR = "doc";

	private static Logger log = Logger.getLogger(CodeGenerator.class);
	
	public static void main(String arg[]){
		//create source directory

		CodeGenerator codeGenerator = new CodeGenerator();
		codeGenerator.runTest();

	}
	
	public void runTest(){
		String baseDirectory = "d:"+getFileSeparator()+"tmp"+getFileSeparator()+"gencode";
		
		createSourceDirectory(baseDirectory);
		//Se crea el modelo de datos
		createDataModel();
		//Se crea el modelo de neogcio
		createBusinessModel();
		//Se crea la vista del Sistema
		createViewModel(baseDirectory);

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
	 * Se crea el modelo de la Vista ya sea Web o de Escritorio, dependiendo del modelo seleccionado
	 * **/
	public void createViewModel(String basePath){

		//Datos Dummy===================================================
		log.debug("Generate Code Entities-JSF");
		Entity sysObject = DummyServiceData.createObject();
		//==============================================================

		//Crear una pagina JSF
		//JSFCodeGenerator jsfCodeGenerator = new JSFCodeGenerator(sysObject);
		String sourceCode = "";//jsfCodeGenerator.getSourceCode();
		createSourceFile(basePath+getFileSeparator()+"src"+getFileSeparator()+"view"+getFileSeparator(),sysObject.getName(),".jspx",sourceCode);
		log.debug(sourceCode);
		//Se Crea el archivo con el codigo fuente
		//createSourceFile(jsfSourceCode);

	}

	public void createBusinessModel(){
		
	}

	public void createDataModel(){
		
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
			// TODO Auto-generated catch block
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
