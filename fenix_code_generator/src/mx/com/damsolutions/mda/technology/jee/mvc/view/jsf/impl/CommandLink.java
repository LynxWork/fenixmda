package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

import mx.com.damsolutions.mda.util.NamingConvention;

public class CommandLink extends Component {
	
	 public CommandLink(String entityName, String entityProperty){
	    	
	    	this.entityName = entityName;
	    	this.entityProperty = entityProperty;
	    }
	@Override
	public String build() {
		StringBuilder link = new StringBuilder();
		link.append("<"+NamingConvention.getJsfAjaxPrefix()+"commandLink ");
		link.append(NamingConvention.getIdJsfImplPrefix()+"=\"" +"CommandLink" + " \"");
		link.append("action=\""+ getAction()+ " \"");
		link.append("actionListener=\""+ getActionListener()+ " \"");
		link.append("binding=\""+ getBinding()+ " \"");
		link.append("bypassUpdates=\""+ getBypassUpdates()+ " \"");
		link.append("charset=\""+ getCharset()+ " \"");
		link.append("coords=\""+ getCoords()+ " \"");
		link.append("data=\""+ getData()+ " \"");
		link.append("disabled=\""+ getDisabled()+ " \"");
		link.append("execute=\""+ getExecute()+ " \"");
		link.append("hreflang=\""+ getHreflang()+ " \"");
		link.append("immediate=\""+ getImmediate()+ " \"");
		link.append("immediate=\""+ getImmediate()+ " \"");
		link.append("limitRender=\""+ getLimitRender()+ " \"");
		link.append("limitToList=\""+ getLimitToList()+ " \"");
		link.append("onbeforedomupdate=\""+ getOnbeforedomupdate()+ " \"");
		link.append("onbegin=\""+ getOnbegin()+ " \"");
		link.append("onbegin=\""+ getOnbegin()+ " \"");
		link.append("onclick=\""+ getOnclick()+ " \"");
		link.append("oncomplete=\""+ getOncomplete()+ " \"");
		link.append("ondblclick=\""+ getOndblclick()+ " \"");
		link.append("oaccesskey=\""+ getOaccesskey()+ " \"");
		link.append("onkeydown=\""+ getOnkeydown()+ " \"");
		link.append("onkeypress=\""+ getOnkeypress()+ " \"");
		link.append("onkeyup=\""+ getOnkeyup()+ " \"");
		link.append("onmousedown=\""+ getOnmousedown()+ " \"");
		link.append("onmousemove=\""+ getOnmousemove()+ " \"");
		link.append("onmouseout=\""+ getOnmouseout()+ " \"");
		link.append("onmouseover=\""+ getOnmouseover()+ " \"");
		link.append("onmouseup=\""+ getOnmouseup()+ " \"");
		link.append("rel=\""+ getRel()+ " \"");
		link.append("render=\""+ getRel()+ " \"");
		link.append("rendered=\""+ getRender()+ " \"");
		link.append("rev=\""+ getRev()+ " \"");
		link.append("shape=\""+ getShape()+ " \"");
		link.append("status=\""+ getStatus()+ " \"");
		link.append("style=\""+ getStyle()+ " \"");
		link.append("styleClass=\""+ getStyleClass()+ " \"");
		link.append("title=\""+ getTitle()+ " \"");
		link.append("type=\""+ getType()+ " \"");
		link.append("value=\""+ getValue()+ " \"");
		link.append(" " + buildStyleClass() +" ");
		link.append("/>");
		return link.toString();
	}

}
