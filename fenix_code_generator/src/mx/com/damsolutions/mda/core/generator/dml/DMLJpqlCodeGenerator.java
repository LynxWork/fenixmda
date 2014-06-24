package mx.com.damsolutions.mda.core.generator.dml;

import mx.com.damsolutions.util.CharacterUtil;

public class DMLJpqlCodeGenerator implements IDMLCodeGenerator {

	private static DMLJpqlCodeGenerator dmlJpqlCodeGenerator;
	
	private DMLJpqlCodeGenerator(){
		
	}
	
	public static DMLJpqlCodeGenerator getInstance(){
		if(dmlJpqlCodeGenerator==null){
			return new DMLJpqlCodeGenerator();
		}else{
			return dmlJpqlCodeGenerator;
		}
	}
	

	@Override
    public String getSelectStatementByRange(String entityName,String entityPropertyName){
		StringBuilder sb = new StringBuilder();
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append(" select");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append("o");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append("from");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append( entityName + " o");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append( "where");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append( entityPropertyName + " between "+ ":"+entityPropertyName+"InitVal " + " and " + " :"+entityPropertyName+"EndVal");
    	return sb.toString();
    }


	@Override
    public String getSelectStatementByProperty(String entityName, String entityPropertyName){
		StringBuilder sb = new StringBuilder();
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append("select");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append("o");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append("from");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append( entityName + " o ");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append( " where ");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append( entityPropertyName + " = "+ ":"+entityPropertyName );
    	return sb.toString();
    }

	@Override
    public String getSelectStatementFindAll(String entityName){
		StringBuilder sb = new StringBuilder();
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append("select");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append("o");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append("from");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append( entityName + " o");
    	return sb.toString();
    }


}
