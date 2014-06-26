package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

import mx.com.damsolutions.mda.util.NamingConvention;

public class A4jAjax extends Component{
	@Override
	public String toString() {
		StringBuilder ajax = new StringBuilder();
		ajax.append("<"+NamingConvention.getJsfAjaxPrefix()+"ajax ");
		ajax.append("event=\""+ getEvent()+ " \"");
		ajax.append("render=\""+ getRender()+ " \"");
		ajax.append("execute=\""+ getExecute()+" \"");
		ajax.append("/>");
		return ajax.toString();
	}
}
