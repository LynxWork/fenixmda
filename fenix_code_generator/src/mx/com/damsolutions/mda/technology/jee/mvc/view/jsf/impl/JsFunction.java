package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

import mx.com.damsolutions.mda.util.NamingConvention;

public class JsFunction extends Component {
	public JsFunction(String entityName, String entityProperty){
    	this.entityName = entityName;
    	this.entityProperty = entityProperty;
    }
	
	@Override
	public String build() {
		StringBuilder function = new StringBuilder();
		function.append("<"+NamingConvention.getJsfAjaxPrefix()+"jsFunction ");
		function.append(NamingConvention.getIdJsfImplPrefix()+"=\"" +"jsFunction" + " \"");
		function.append("name=\""+ getName()+ " \"");
		function.append("action=\"#{" + NamingConvention.getClassControllerName( getEntityName() ) +"."+ getEntityProperty() +"\"} ");
		function.append("actionListener=\"#{" + NamingConvention.getClassControllerName( getEntityName() ) +"."+ getEntityProperty() +"\"} ");
		function.append("ajaxSingle=\""+ getAjaxSingle()+ " \"");
		function.append("binding=\"#{" + NamingConvention.getClassControllerName( getEntityName() ) +"."+ getEntityProperty() +"\"} ");
        function.append("bypassUpdates=\""+ getBypassUpdates()+ " \"");
        function.append("eventsQueue=\""+ getEventsQueue()+ " \"");
        function.append("ignoreDupResponses=\""+ getIgnoreDupResponses()+ " \"");
        function.append("immediate=\""+ getImmediate()+ " \"");
        function.append("limitToList=\""+ getLimitToList()+ " \"");
        function.append("onbeforedomupdate=\""+"alert" + "(" + getOnbeforedomupdate()+ ")"+ " \"");
        function.append("oncomplete=\""+ getLimitToList()+ " \"");
        
        
        
        function.append("assignTo=\"#{" + NamingConvention.getClassControllerName( getEntityName() ) +"."+ getEntityProperty() +"\"} ");
		
		function.append("converter=\""+ getAction()+ " \"");
		
		
		function.append("render=\""+ getRender()+ " \"");
		function.append(" " + buildStyleClass() +" ");
		function.append("/>");
		return function.toString();
	}
	

}
