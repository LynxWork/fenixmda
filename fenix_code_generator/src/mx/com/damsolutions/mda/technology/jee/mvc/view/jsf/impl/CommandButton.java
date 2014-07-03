package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

import mx.com.damsolutions.mda.util.NamingConvention;

public class CommandButton extends Component {
	
	public String build() {
		//propiedad=\"" + string + "\" "
		StringBuilder button = new StringBuilder();
		button.append("<"+NamingConvention.getJsfAjaxPrefix()+"CommandButton ");
		button.append("event=\""+ getEvent()+ " \"");
		button.append("render=\""+ getRender()+ " \"");
		button.append("execute=\""+ getExecute()+" \"");
		button.append(" " + buildStyleClass() +" ");
		button.append("/>");
		return button.toString();
	}

}
