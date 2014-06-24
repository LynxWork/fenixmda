package mx.com.damsolutions.mda.util.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriteSourceFile {

	
	
	public boolean writeFile(String content, String directory, String fileName, String extencion){
		 boolean resVal = false;
		 boolean isDirectoryValid = false;
		  FileWriter fileWriter = null;
	        try {
	            File newTextFile = new File(directory+fileName+extencion);
	            File dir = new File(directory);
	            if(!dir.exists()){
	            	if(dir.mkdirs()){
	            		System.out.println("Directorio creado");
	            		isDirectoryValid = true;
	            	}else{
	            		System.out.println("No fue posible crear el directorio");
	            	}
	            }else{
	            	isDirectoryValid = true;
	            	System.out.println("El directorio no existe");
	            }
	            if(isDirectoryValid){
		            fileWriter = new FileWriter(newTextFile);
		            fileWriter.write(content);
		            fileWriter.close();
		            resVal=true;
	            }

	        } catch (IOException ex) {
	            Logger.getLogger(WriteSourceFile.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            try {
	                fileWriter.close();
	            } catch (IOException ex) {
	                Logger.getLogger(WriteSourceFile.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	        return resVal;
	}
	
	
}
