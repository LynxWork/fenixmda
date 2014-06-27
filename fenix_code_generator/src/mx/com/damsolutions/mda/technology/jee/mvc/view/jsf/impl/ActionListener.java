package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

import mx.com.damsolutions.mda.util.NamingConvention;

public class ActionListener extends Component {
	@Override
	public String build() {
		StringBuilder ajax = new StringBuilder();
		ajax.append("<"+NamingConvention.getJsfAjaxPrefix()+"actionListener ");
		ajax.append("binding=\"#{" + NamingConvention.getClassControllerName( getEntityName() ) +"."+ getEntityProperty()+"\"} ");
		ajax.append("/>");
		return ajax.toString();
	}


}
