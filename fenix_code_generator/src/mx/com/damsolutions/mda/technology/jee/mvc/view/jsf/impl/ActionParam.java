package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

import mx.com.damsolutions.mda.util.NamingConvention;

public class ActionParam extends Component {
	
	public ActionParam(String entityName, String entityProperty){
    	
    	this.entityName = entityName;
    	this.entityProperty = entityProperty;
    }
	@Override
	public String build() {
		StringBuilder param = new StringBuilder();
		param.append("<"+NamingConvention.getJsfAjaxPrefix()+"ActionParam ");
		param.append(NamingConvention.getIdJsfImplPrefix()+"=\"" +"username" + " \"");
		param.append(NamingConvention.getNameJsfImplPrefix()+"=\"" + "Alex" +  " \"" );
		param.append("assignTo=\"#{"+ NamingConvention.getClassControllerName( getEntityName() ) +"."+ getEntityProperty()+"}" + "\" ");
		param.append(" " + buildStyleClass() +" ");
		param.append("/>");
		return param.toString();
	}

}