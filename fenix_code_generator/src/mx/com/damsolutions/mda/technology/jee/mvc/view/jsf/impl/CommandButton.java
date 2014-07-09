package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

import mx.com.damsolutions.mda.util.NamingConvention;
import mx.com.damsolutions.util.StringUtil;

public class CommandButton extends Component {
	
	public CommandButton(String id, String name, String entityName, String entityProperty){
		this.id=id;
		this.name=name;
		this.entityName = entityName;
    	this.entityProperty = entityProperty;
	}

	public String build() {
		//propiedad=\"" + string + "\" "
		StringBuilder button = new StringBuilder();
		button.append("<"+NamingConvention.getJsfAjaxPrefix()+"CommandButton ");
		if( !StringUtil.isNull( buildStringId() ) ){
			button.append( buildId() ); 
		}
		if( !StringUtil.isNull( buildName() ) ){ 
			button.append( buildName() );
		}
		if (!StringUtil.isNull(buildAccesskey())){
			button.append(buildAccesskey());
		}
		if (!StringUtil.isNull(buildAction())){
			button.append(buildAction());
		}
		if(!StringUtil.isNull(buildActionListener())){
			button.append(buildActionListener());	
		}
		if (!StringUtil.isNull(buildAjaxSingle())){
			button.append(buildAjaxSingle());
		}
		if(!StringUtil.isNull(alt)){
			button.append("alt=\""+ getAlt()+ " \" ");
		}
		if(!StringUtil.isNull(buildBinding())){
			button.append(buildBinding());
		}
		
		if(!StringUtil.isNull(buildBypassUpdates())){
			button.append(buildBypassUpdates());
		}
		if(!StringUtil.isNull(buildData())){
			button.append(buildData());
		}
		if(!StringUtil.isNull(buildDir())){
			button.append(buildDir());
		}
		if(!StringUtil.isNull(buildDisabled())){
			button.append(buildDisabled());
		}
		if(!StringUtil.isNull(buildEventsQueue())){
			button.append(buildEventsQueue());
		}
		if(!StringUtil.isNull(buildFocus())){
			button.append(buildFocus());
		}
		if(!StringUtil.isNull(buildIgnoreDupResponses())){
			button.append(buildIgnoreDupResponses());
		}
		if(!StringUtil.isNull(buildImage())){
			button.append(buildImage());
		}
		if(!StringUtil.isNull(buildImmediate())){
			button.append(buildImmediate());
		}
		if(!StringUtil.isNull(buildLang())){
			button.append(buildLang());
		}
		if(!StringUtil.isNull(buildLimitToList())){
			button.append(buildLimitToList());
		}
		if(!StringUtil.isNull(buildOnbeforedomupdate())){
			button.append(buildOnbeforedomupdate());
		}
		if(!StringUtil.isNull(onblur)){
		    button.append(" onblur=\""+ getOnblur()+ " \"");
		}
		if(!StringUtil.isNull(onchange)){
		    button.append(" onchange=\"" + " submit()"+" \"");
		}
		if(!StringUtil.isNull(buildOnclick())){
			button.append(buildOnclick());
		}
		if(!StringUtil.isNull(buildOncomplete())){
			button.append(buildOncomplete());
		}
		if(!StringUtil.isNull(buildOndblclick())){
			button.append(buildOndblclick());
		}
		if(!StringUtil.isNull(onfocus)){
			button.append(" onfocus=\""+ getOnfocus()+ " \"");
		}
		if(!StringUtil.isNull(buildOnkeydown())){
			button.append(buildOnkeydown());
		}
		if(!StringUtil.isNull(buildOnkeypress())){
			button.append(buildOnkeypress());
		}
		if(!StringUtil.isNull(buildOnkeyup())){
			button.append(buildOnkeyup());
		}
		if(!StringUtil.isNull(buildOnmousedown())){
			button.append(buildOnmousedown());
		}
		if(!StringUtil.isNull(buildOnmouseout())){
			button.append(buildOnmouseout());
		}
		if(!StringUtil.isNull(buildOnmouseover())){
			button.append(buildOnmouseover());
		}
		if(!StringUtil.isNull(buildOnmouseup())){
			button.append(buildOnmouseup());
		}
		if(!StringUtil.isNull(buildProcess())){
			button.append(buildProcess());
		}
		if(!StringUtil.isNull(buildReRender())){
			button.append(buildReRender());
		}
		if(!StringUtil.isNull(buildRendered())){
			button.append(buildRendered());
		}
		if(!StringUtil.isNull(buildRequestDelay())){
			button.append(buildRequestDelay());
		}
		if(!StringUtil.isNull(buildSimilarityGroupingId())){
			button.append(buildSimilarityGroupingId());
		}
		if(!StringUtil.isNull(size)){
			button.append(" size=\""+ "3" + " \"");
		}
		if(!StringUtil.isNull(buildStatus())){
			button.append(buildStatus());
		}
		if(!StringUtil.isNull(buildStyle())){
			button.append(buildStyle());
		}
		if(!StringUtil.isNull(buildStyleClass())){
			button.append(buildStyleClass());
		}
		if(!StringUtil.isNull(tabindex)){
			button.append("tabindex=\""+" 3 "+ " \"");
		}
		if(!StringUtil.isNull(buildTimeout())){
			button.append(buildTimeout());
		}
		if(!StringUtil.isNull(buildTitle())){
			button.append(buildTitle());
		}
		if(!StringUtil.isNull(buildType())){
			button.append(buildType());
		}
		if(!StringUtil.isNull(buildValue())){
			button.append(buildValue());
		}
		button.append("/>");
		return button.toString();
	}


	
	@Override
	public String buildStringId(){
		return getEntityProperty()+getId()+"CmdBtn";
		
	}
	
	@Override
	public String buildStringName(){
		return getEntityProperty()+getName()+"CmdBtn";
	}

}
