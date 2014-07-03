package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

import mx.com.damsolutions.mda.util.NamingConvention;


public class HtmlCommandLink extends Component {
	
	 public HtmlCommandLink(String entityName, String entityProperty){
	    	this.entityName = entityName;
	    	this.entityProperty = entityProperty;
	    }
	@Override
	public String build() {
		StringBuilder link = new StringBuilder();
		link.append("<"+NamingConvention.getJsfAjaxPrefix()+"HtmlCommandLink ");
		link.append("action=\""+ getAction()+ " \"");
		link.append("value=\""+ getValue()+ " \"");
		link.append("enabled=\"#{"+ NamingConvention.getClassControllerName( getEntityName() ) +"."+ getEntityProperty()+"}" + "\" ");
		link.append(" " + buildStyleClass() +" ");
		link.append("/>");
		return link.toString();
	}
}
