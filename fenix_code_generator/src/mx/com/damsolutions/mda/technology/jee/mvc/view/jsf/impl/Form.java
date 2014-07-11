package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

import mx.com.damsolutions.mda.util.NamingConvention;
import mx.com.damsolutions.util.StringUtil;

public class Form extends Component {
	private Component[] components;
	
	public Form(Component... components){
		this.components = components;
		
		
	}
	
	public Form(String id, String name, String entityName, String entityProperty){
		this.id=id;
		this.name=name;
		this.entityName = entityName;
    	this.entityProperty = entityProperty;
	}
	@Override
	public String build() {
		//propiedad=\"" + string + "\" "
		StringBuilder form = new StringBuilder();
		form.append("<"+NamingConvention.getJsfAjaxPrefix()+"form ");
		if(getComponents()!=null && getComponents().length>0){
			for(Component component: getComponents() ){
				if(component instanceof OutputTextField){
					OutputTextField outputTextField = (OutputTextField) component;
					form.append(outputTextField.toString());
				}
				//Validate more valid components inner this component
			}
		}
		if( !StringUtil.isNull( buildStringId() ) ){
			form.append( buildId() ); 
		}
		if( !StringUtil.isNull( buildName() ) ){ 
			form.append( buildName() );
		}
		if (!StringUtil.isNull(buildAjaxSingle())){
			form.append(buildAjaxSingle());
		}
		if (!StringUtil.isNull(buildAjaxSubmit())){
			form.append(buildAjaxSubmit());
		}
		
		if(!StringUtil.isNull(buildBinding())){
			form.append(buildBinding());
		}
		
		if(!StringUtil.isNull(buildBypassUpdates())){
			form.append(buildBypassUpdates());
		}
		if(!StringUtil.isNull(buildData())){
			form.append(buildData());
		}
		if(!StringUtil.isNull(enctype)){
		    form.append(" enctype=\""+ getEnctype()+ " \"");
		}
		if(!StringUtil.isNull(buildEventsQueue())){
			form.append(buildEventsQueue());
		}
		if(!StringUtil.isNull(buildFocus())){
			form.append(buildFocus());
		}
		if(!StringUtil.isNull(buildIgnoreDupResponses())){
			form.append(buildIgnoreDupResponses());
		}
		
		if(!StringUtil.isNull(buildLimitToList())){
			form.append(buildLimitToList());
		}
		if(!StringUtil.isNull(buildOnbeforedomupdate())){
			form.append(buildOnbeforedomupdate());
		}
		if(!StringUtil.isNull(buildOncomplete())){
			form.append(buildOncomplete());
		}
		if(!StringUtil.isNull(onreset)){
		    form.append(" onreset=\""+ getOnblur()+ " \"");
		}
		if(!StringUtil.isNull(onsubmit)){
		    form.append(" onsubmit=\""+ getOnsubmit()+ " \"");
		}
		if(!StringUtil.isNull(prependId)){
		    form.append(" prependId=\""+ getPrependId()+ " \"");
		}
		if(!StringUtil.isNull(buildProcess())){
			form.append(buildProcess());
		}
		if(!StringUtil.isNull(buildReRender())){
			form.append(buildReRender());
		}
		if(!StringUtil.isNull(buildRendered())){
			form.append(buildRendered());
		}
		if(!StringUtil.isNull(buildRequestDelay())){
			form.append(buildRequestDelay());
		}
		if(!StringUtil.isNull(buildSimilarityGroupingId())){
			form.append(buildSimilarityGroupingId());
		}
		
		if(!StringUtil.isNull(buildStatus())){
			form.append(buildStatus());
		}
		if(!StringUtil.isNull(buildStyle())){
			form.append(buildStyle());
		}
		if(!StringUtil.isNull(buildStyleClass())){
			form.append(buildStyleClass());
		}
	
		if(!StringUtil.isNull(buildTimeout())){
			form.append(buildTimeout());
		}
		if(!StringUtil.isNull(target)){
		    form.append(" target=\"#{"+ NamingConvention.getClassControllerName( getEntityName() ) +"."+ getEntityProperty()+"}" + "\" ");
		}
		
		form.append("</"+NamingConvention.getJsfAjaxPrefix()+"form >");
		return form.toString();
	}
    
	
	public Component[] getComponents() {
		return components;
	}

	public void setComponents(Component[] components) {
		this.components = components;
	}
    	
	@Override
	public String buildStringId(){
		return getEntityProperty()+getId()+"CmdForm";
		
	}
	
	@Override
	public String buildStringName(){
		return getEntityProperty()+getName()+"CmdForm";
	}


}
