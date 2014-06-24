package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.cmp;

public class Util {

	
	public static String buildHeaderComponent(){
		StringBuilder sb = new StringBuilder("");
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
					"<html xmlns=\"http://www.w3.org/1999/xhtml\""+
					"xmlns:ui=\"http://java.sun.com/jsf/facelets\""+
					"xmlns:f=\"http://java.sun.com/jsf/core\""+
					"xmlns:h=\"http://java.sun.com/jsf/html\""+
					"xmlns:a4j=\"http://richfaces.org/a4j\""+
					"xmlns:rich=\"http://richfaces.org/rich\""+
					"xmlns:composite=\"http://java.sun.com/jsf/composite\">");
		return sb.toString();
	}
	
	public static String buildFooterComponent(){
		StringBuilder sb = new StringBuilder("");
		sb.append("</html>");
		return sb.toString();
	}
	
}
