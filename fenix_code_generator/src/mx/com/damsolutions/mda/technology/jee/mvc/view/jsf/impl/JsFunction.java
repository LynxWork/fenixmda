package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

import mx.com.damsolutions.mda.util.NamingConvention;
import mx.com.damsolutions.util.StringUtil;

public class JsFunction extends Component {
private Component[] components;
	
	public JsFunction(Component... components){
		this.components = components;
		
		
	}
	
	public JsFunction(String id, String name, String entityName, String entityProperty){
		this.id=id;
		this.name=name;
		this.entityName = entityName;
    	this.entityProperty = entityProperty;
	}
	@Override
	public String build() {
		StringBuilder function = new StringBuilder();
		function.append("<"+NamingConvention.getJsfAjaxPrefix()+"jsFunction ");
		if(getComponents()!=null && getComponents().length>0){
			for(Component component: getComponents() ){
				if(component instanceof OutputTextField){
					OutputTextField outputTextField = (OutputTextField) component;
					function.append(outputTextField.toString());
				}
				//Validate more valid components inner this component
			}
		}
		if( !StringUtil.isNull( buildStringId() ) ){
			function.append( buildId() ); 
		}
		if( !StringUtil.isNull( buildName() ) ){ 
			function.append( buildName() );
		}
		if( !StringUtil.isNull( buildAction() ) ){ 
			function.append( buildAction() );
		}
		if( !StringUtil.isNull( buildActionListener() ) ){ 
			function.append( buildActionListener() );
		}
		if (!StringUtil.isNull(buildAjaxSingle())){
			function.append(buildAjaxSingle());
		}
		if( !StringUtil.isNull( buildBinding() ) ){ 
			function.append( buildBinding() );
		}
		if(!StringUtil.isNull(buildBypassUpdates())){
			function.append(buildBypassUpdates());
		}
		if( !StringUtil.isNull( buildData() ) ){ 
			function.append(buildData());
		}
		if( !StringUtil.isNull( buildEventsQueue() ) ){ 
			function.append(buildEventsQueue());
		}
		if( !StringUtil.isNull( buildFocus() ) ){ 
			function.append(buildFocus());
		}
		if( !StringUtil.isNull( buildIgnoreDupResponses() ) ){ 
			function.append(buildIgnoreDupResponses());
		}
		if( !StringUtil.isNull( buildImmediate() ) ){ 
			function.append(buildImmediate());
		}
		if( !StringUtil.isNull( buildLimitToList() ) ){ 
			function.append(buildLimitToList());
		}
		if( !StringUtil.isNull( buildOnbeforedomupdate() ) ){ 
			function.append(buildOnbeforedomupdate());
		}
		if( !StringUtil.isNull( buildOnclick() ) ){ 
			function.append(buildOnclick());
		}
		if( !StringUtil.isNull( buildOncomplete() ) ){ 
			function.append(buildOncomplete());
		}
	    if( !StringUtil.isNull( buildProcess() ) ){ 
		function.append(buildProcess());
		}
		if( !StringUtil.isNull( buildReRender() ) ){ 
			function.append(buildReRender());
		}
		if( !StringUtil.isNull( buildRendered() ) ){ 
			function.append(buildRendered());
		}
		if(!StringUtil.isNull(buildRequestDelay())){
			function.append(buildRequestDelay());
		}
		if( !StringUtil.isNull( buildSimilarityGroupingId() ) ){ 
			function.append(buildSimilarityGroupingId());
		}
		if(!StringUtil.isNull(buildStatus())){
			function.append(buildStatus());
		}
		if( !StringUtil.isNull( buildTimeout() ) ){ 
			function.append(buildTimeout());
		}
		function.append("</"+NamingConvention.getJsfAjaxPrefix()+"form >");
			return function.toString();
	}

	public Component[] getComponents() {
		return components;
	}

	public void setComponents(Component[] components) {
		this.components = components;
	}
	@Override
	public String buildStringId(){
		return getEntityName()+getId()+"CmdjsFunction";
	}
	
	@Override
	public String buildStringName(){
		return getEntityName()+getName()+"CmdjsFunction";
	}

}
