package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

import mx.com.damsolutions.mda.util.NamingConvention;

public class Param extends Component {
	 public Param(String entityName, String entityProperty){
	    	
	    	this.entityName = entityName;
	    	this.entityProperty = entityProperty;
	    }
	@Override
	
	public String build() {
	StringBuilder param = new StringBuilder();
	param.append("<"+NamingConvention.getJsfAjaxPrefix()+"param ");
	param.append("value=\""+ getValue()+ " \"");
	param.append("assignTo=\"#{"+ NamingConvention.getClassControllerName( getEntityName() ) +"."+ getEntityProperty()+"}" + "\" ");
	param.append(" " + buildStyleClass() +" ");
	param.append("/>");
	return param.toString();
}

}
