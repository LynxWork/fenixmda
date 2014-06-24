package mx.com.damsolutions.mda.metamodel;


public class DataTypeFactory {

	/**
	 * Regresa el tipo de dato a partir del nombre asignado por parametro
	 * @param type
	 * @return DataType
	 * **/
	public static DataType getType(String type){
		DataType resVal;
		if(type.equals("textField")){
			resVal = getText();
		}else if(type.equals("hidden")){
			resVal = getHidden();
		}else if(type.equals("textArea")){
			resVal = getTextArea();
		}else{
			resVal = getText();
		}
		return resVal;
	}
	
	
	public static DataType getHidden(){
		return new DataType(1,"password","List of characters whit password format");
	}

	public static DataType getText(){
		return new DataType(1,"text","Text field to input text data");
	}
	
	public static DataType getTextArea(){
		return new DataType(1,"textArea","Text field to input text data in text area");
	}	
	
	
}
