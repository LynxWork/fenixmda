package mx.com.damsolutions.mda.junit.generator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import mx.com.damsolutions.mda.generator.CodeGenerator;


import org.apache.log4j.Logger;

public class CodeGeneratorTest {
	
	private static Logger log = Logger.getLogger(CodeGeneratorTest.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		log.debug("Generate Code Entiry");
		//SysObject sysObject = DummyServiceData.createObject();
		//JSFCodeGenerator jsfCodeGenerator = new JSFCodeGenerator(sysObject);
		CodeGenerator codeGenerator = new CodeGenerator();
		//codeGenerator.createViewModel();

		
		
	}
	
}
