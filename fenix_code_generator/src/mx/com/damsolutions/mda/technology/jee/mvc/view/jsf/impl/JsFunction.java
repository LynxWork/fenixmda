package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

import mx.com.damsolutions.mda.util.NamingConvention;

public class JsFunction extends Component {
	@Override
	public String toString() {
		StringBuilder Function = new StringBuilder();
		Function.append("<"+NamingConvention.getJsfAjaxPrefix()+"jsFunction ");
		Function.append("name=\""+ getName()+ " \"");
		Function.append("render=\""+ getRender()+ " \"");
		Function.append("/>");
		return Function.toString();
	}
	

}
