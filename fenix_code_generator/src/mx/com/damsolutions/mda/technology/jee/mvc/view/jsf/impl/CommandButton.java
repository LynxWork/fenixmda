package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

import mx.com.damsolutions.mda.util.NamingConvention;

public class CommandButton extends Component {
	public String toString() {
		//propiedad=\"" + string + "\" "
		StringBuilder ajax = new StringBuilder();
		ajax.append("<"+NamingConvention.getJsfAjaxPrefix()+"CommandButton ");
		ajax.append("event=\""+ getEvent()+ " \"");
		ajax.append("render=\""+ getRender()+ " \"");
		ajax.append("execute=\""+ getExecute()+" \"");
		ajax.append("/>");
		return ajax.toString();
	}

}
