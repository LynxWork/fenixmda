package mx.com.damsolutions.code.generator.java.types;

import mx.com.damsolutions.code.generator.types.IDataType;
import mx.com.damsolutions.mda.language.INameSpace;

public class JDataType implements IDataType{

	public String name;
	public String nameSpace;
	
	public static final String INTEGER_NAME = "Integer";
	public static final String LONG_NAME = "Long";
	public static final String FLOAT_NAME = "Float";
	public static final String DOUBLE_NAME = "Double";
	public static final String CHARACTER_NAME = "Char";
	public static final String STRING_NAME = "String";
	public static final String DATE_NAME = "Date";
	
	private static final String DATA_TYPE_NAME_SPACE = "java.lang.";
	
	public static final String INTEGER_NAME_SPACE = DATA_TYPE_NAME_SPACE;
	public static final String LONG_NAME_SPACE = DATA_TYPE_NAME_SPACE;
	public static final String FLOAT_NAME_SPACE = DATA_TYPE_NAME_SPACE;
	public static final String DOUBLE_NAME_SPACE = DATA_TYPE_NAME_SPACE;
	public static final String CHARACTER_NAME_SPACE = DATA_TYPE_NAME_SPACE;
	public static final String STRING_NAME_SPACE = DATA_TYPE_NAME_SPACE;
	public static final String DATE_NAME_SPACE = "java.util.";

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public INameSpace getNameSpace() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getQualifiedName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String build(){
		return getName();
	}
}
