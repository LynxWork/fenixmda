package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

import mx.com.damsolutions.mda.util.NamingConvention;


public class OutputTextField extends TextField {
	
	private static final String TAG_NAME = "outputText";
	@Override
	public String build() {
		StringBuilder resVal = new StringBuilder(); 
		resVal.append("<"+NamingConvention.getJsfHtmlPrefix()+TAG_NAME+" ");
		resVal.append("id=\"" + getId() + "OutTxt\" ");
		resVal.append("value=\"" + getLabel() +":\" ");
		resVal.append(buildStyleClass());
		resVal.append(" > ");
		//End tag
		resVal.append(" </"+NamingConvention.getJsfHtmlPrefix()+TAG_NAME+"> ");
		return resVal.toString();
	}
	
}
