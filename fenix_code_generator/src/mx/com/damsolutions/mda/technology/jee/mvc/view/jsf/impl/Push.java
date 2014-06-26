package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

import mx.com.damsolutions.mda.util.NamingConvention;

public class Push extends Component {
	@Override
	public String toString() {
		StringBuilder push = new StringBuilder();
		push.append("<"+NamingConvention.getJsfAjaxPrefix()+"push ");
		push.append("id=\""+ getId()+ " \"");
		push.append("address=\""+ getAddress()+ " \"");
		push.append("/>");
		return push.toString();
	}

}
