package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

import mx.com.damsolutions.mda.util.NamingConvention;

public class Message extends Text {

	@Override
	public String build() {
		StringBuilder resVal = new StringBuilder(); 
		resVal.append("<"+NamingConvention.getJsfImplPrefix()+"message ");
		resVal.append("id=\"" + getId() + "Message\" ");
		resVal.append( buildStyleClass());
		resVal.append(buildForComponent());
		resVal.append(" > ");
		//End tag
		resVal.append(" </"+NamingConvention.getJsfImplPrefix()+"message> ");
		return resVal.toString();
	}

}
