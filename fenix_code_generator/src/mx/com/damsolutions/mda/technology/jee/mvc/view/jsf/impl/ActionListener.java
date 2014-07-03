package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

import mx.com.damsolutions.mda.util.NamingConvention;

public class ActionListener extends Component {
	
	 public ActionListener(String entityName, String entityProperty){
	    	
	    	this.entityName = entityName;
	    	this.entityProperty = entityProperty;
	    }
	@Override
	public String build() {
		StringBuilder listener = new StringBuilder();
		listener.append("<"+NamingConvention.getJsfAjaxPrefix()+"actionListener ");
		listener.append("binding=\"#{" + NamingConvention.getClassControllerName( getEntityName() ) +"."+ getEntityProperty()+"\"} ");
		listener.append(" " + buildStyleClass() +" ");
		listener.append("/>");
		return listener.toString();
	}


}
