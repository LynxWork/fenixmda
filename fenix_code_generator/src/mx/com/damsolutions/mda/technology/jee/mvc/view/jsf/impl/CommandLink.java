package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

import mx.com.damsolutions.mda.util.NamingConvention;

public class CommandLink extends Component {
	@Override
	public String build() {
		StringBuilder link = new StringBuilder();
		link.append("<"+NamingConvention.getJsfAjaxPrefix()+"commandLink ");
		link.append("event=\""+ getEvent()+ " \"");
		link.append("render=\""+ getRender()+ " \"");
		link.append("execute=\""+ getExecute()+" \"");
		link.append(" " + buildStyleClass() +" ");
		link.append("/>");
		return link.toString();
	}

}
