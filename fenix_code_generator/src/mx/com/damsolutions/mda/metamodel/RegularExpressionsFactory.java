package mx.com.damsolutions.mda.metamodel;

public class RegularExpressionsFactory {

	private static RegularExpressionsFactory regularExpressionsFactory;
	
	private RegularExpressionsFactory(){
	}
	
	public static RegularExpressionsFactory getInstance(){
		if(regularExpressionsFactory==null){
			return new RegularExpressionsFactory();
		}else{
			return regularExpressionsFactory;
		}
	}
	
	/**
	 * Regresa el tipo de dato a partir del nombre asignado por parametro
	 * @param type
	 * @return DataType
	 * **/
	public RegularExpression getRegularExpressions(String type){
		RegularExpression resVal = null;
		if(type.equals("Email")){
			resVal = new RegularExpression(1,"Email","^(([a-zA-Z0-9]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5}){1,25})+([;.](([a-zA-Z0-9_\\-\\v.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5}){1,25})+)*$","Email pattern");
		}else if(type.equals("OnlyText")){
			resVal = new RegularExpression(1,"OnlyText","^([a-zA-Z]+)","Only text pattern");
		}else if(type.equals("TextAndNumber")){
			resVal = new RegularExpression(1,"TextAndNumber","^([a-zA-Z0-9]+)","Text an number pattern");
		}else if(type.equals("OnlyNumber")){
			resVal = new RegularExpression(1,"OnlyNumber","^([0-9]+)","Only number pattern");
		}
		return resVal;
	}
	
}
