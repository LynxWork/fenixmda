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
		
		
		/*
		button.append("data=\""+ getData()+ " \"");
		button.append("dir=\""+ getDir()+ " \"");
		button.append("disabled=\""+ getDisabled()+ " \"");
		button.append("eventsQueue=\""+ getEventsQueue()+ " \"");
		button.append("focus=\""+ getFocus()+ " \"");
		button.append("ignoreDupResponses=\""+ getIgnoreDupResponses()+ " \"");
		button.append("image=\""+ getImage()+ " \"");
		button.append("immediate=\""+ getImmediate()+ " \"");
		button.append("lang=\""+ getLang()+ " \"");
		button.append("limitToList=\""+ getLimitToList()+ " \"");
		button.append("onbeforedomupdate=\""+ getOnbeforedomupdate()+ " \"");
		button.append("onblur=\""+ getOnblur()+ " \"");
		button.append("onchange=\""+ getOnchange()+ " \"");
		button.append( buildOnclick() );
		button.append("oncomplete=\""+ getOncomplete()+ " \"");
		
		button.append("onfocus=\""+ getOnfocus()+ " \"");
		button.append("onkeydown=\""+ getOnkeydown()+ " \"");
		button.append("onkeypress=\""+ getOnkeypress()+ " \"");
		button.append("onkeyup=\""+ getOnkeyup()+ " \"");
		button.append("onmousedown=\""+ getOnmousedown()+ " \"");
		button.append("onmousemove=\""+ getOnmousemove()+ " \"");
		button.append("onmouseout=\""+ getOnmouseout()+ " \"");
		button.append("onmouseover=\""+ getOnmouseover()+ " \"");
		button.append("onmouseup=\""+ getOnmouseup()+ " \"");
		button.append("process=\""+ getProcess()+ " \"");
		button.append("reRender=\""+ getReRender()+ " \"");
		button.append("rendered=\""+ getRendered()+ " \"");
		button.append("requestDelay=\""+ getRequestDelay()+ " \"");
		button.append("similarityGroupingId=\""+ getSimilarityGroupingId()+ " \"");
		button.append("size=\""+ getSize()+ " \"");
		button.append("status=\""+ getStatus()+ " \"");
		button.append("style=\""+ getStyle()+ " \"");
		button.append("styleClass=\""+ getStyleClass()+ " \"");
		button.append("tabindex=\""+ getTabindex()+ " \"");
		button.append("title=\""+ getTitle()+ " \"");
		button.append("type=\""+ getType()+ " \"");
		button.append("value=\""+ getValue()+ " \"");
		button.append(" " + buildStyleClass() +" ");
		button.append("/>");*/
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
