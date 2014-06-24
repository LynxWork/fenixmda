package mx.com.damsolutions.code.generator.factory;

import mx.com.damsolutions.mda.core.generator.DDLMySqlCodeGenerator;
import mx.com.damsolutions.mda.core.generator.IDDLCodeGenerator;

public class ClassGeneratorFactory {

	public static final String MYSQL_DATA_BASE_CODE_GENERATOR = "MySql";
	public static final String ORACLE_DATA_BASE_CODE_GENERATOR = "Oracle";
	public static final String DB2_DATA_BASE_CODE_GENERATOR = "DB2";


	public IDDLCodeGenerator getCodeGenerator(String codeGenType){
		if(codeGenType.equals(MYSQL_DATA_BASE_CODE_GENERATOR)){
			return new DDLMySqlCodeGenerator();
		}else if(codeGenType.equals(ORACLE_DATA_BASE_CODE_GENERATOR)){
			
		}else if(codeGenType.equals(DB2_DATA_BASE_CODE_GENERATOR)){
			
		} 
		 return null;
	}
	
	
	
}