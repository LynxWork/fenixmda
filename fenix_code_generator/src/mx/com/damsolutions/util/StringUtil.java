package mx.com.damsolutions.util;

public class StringUtil {

	public static boolean isNull(String string){
		boolean resval = true;
		if(string!=null && string.length()>0){
			resval = false;
		}else{
			resval=true;
		}
		return resval;
	}

}
