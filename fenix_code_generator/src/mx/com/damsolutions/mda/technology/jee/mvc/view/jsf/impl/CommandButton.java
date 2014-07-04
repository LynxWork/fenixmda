package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

import mx.com.damsolutions.mda.util.NamingConvention;

public class CommandButton extends Component {
	
	public String build() {
		//propiedad=\"" + string + "\" "
		StringBuilder button = new StringBuilder();
		button.append("<"+NamingConvention.getJsfAjaxPrefix()+"CommandButton ");
		button.append(NamingConvention.getIdJsfImplPrefix()+"=\"" +"CommandButton" + " \"");
		button.append("accesskey=\""+ getAccesskey()+ " \"");
		button.append("action=\""+ getAction()+ " \"");
		button.append("actionListener=\""+ getActionListener()+ " \"");
		button.append("ajaxSingle=\""+ getAjaxSingle()+ " \"");
		button.append("alt=\""+ getAlt()+ " \"");
		button.append("binding=\""+ getBinding()+ " \"");
		button.append("bypassUpdates=\""+ getBypassUpdates()+ " \"");
		button.append("data=\""+ getData()+ " \"");
		button.append("dir=\""+ getDir()+ " \"");
		button.append("disabled=\""+ getDisabled()+ " \"");
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
		button.append("onclick=\""+ getOnclick()+ " \"");
		button.append("oncomplete=\""+ getOncomplete()+ " \"");
		button.append("ondblclick=\""+ getOndblclick()+ " \"");
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
		button.append("/>");
		return button.toString();
	}

}
