package mx.com.damsolutions.mda.util;

import mx.com.damsolutions.mda.metamodel.DataType;

public class MapDataTypes {

	//Basic types
	public static final String DATA_TYPE_TEXT = "text";
	public static final String DATA_TYPE_NUMBER = "number";
	public static final String DATA_TYPE_FLOAT = "float";
	
	//Complex Types
	public static final String DATA_TYPE_TEXT_AREA = "textArea";
	public static final String DATA_TYPE_PASSWORD = "password";
	public static final String DATA_TYPE_CURRENCY = "currency";
	public static final String DATA_TYPE_DATE = "date";
	public static final String DATA_TYPE_DATE_TIME = "dateTime";
	public static final String DATA_TYPE_TIME12H = "time12h";
	public static final String DATA_TYPE_TIME24H = "time24h";
	public static final String DATA_TYPE_DAY = "day";

	public static String getJavaDataType(DataType dataType){
		String resval="";
		if(dataType.getName().equals( DATA_TYPE_TEXT )){
			resval="String";
		}else if(dataType.getName().equals( DATA_TYPE_NUMBER )){
			resval="Integer";
		}else if(dataType.getName().equals( DATA_TYPE_FLOAT )){
			resval="Float";
		}else if(dataType.getName().equals( DATA_TYPE_TEXT_AREA )){
			resval="String";
		}else if(dataType.getName().equals( DATA_TYPE_PASSWORD )){
			resval="String";
		}else if(dataType.getName().equals( DATA_TYPE_CURRENCY )){
			resval="Double";
		}else if(dataType.getName().equals( DATA_TYPE_DATE )){
			resval="Date";
		}else if(dataType.getName().equals( DATA_TYPE_DATE_TIME )){
			resval="Date";
		}else if(dataType.getName().equals( DATA_TYPE_TIME12H )){
			resval="Date";
		}else if(dataType.getName().equals( DATA_TYPE_TIME24H )){
			resval="Date";
		}else if(dataType.getName().equals( DATA_TYPE_DAY )){
			resval="Date";
		}
		return resval;
	}
	
}
