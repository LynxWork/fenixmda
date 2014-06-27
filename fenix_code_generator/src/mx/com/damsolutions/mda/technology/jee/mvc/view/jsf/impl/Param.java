package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

import mx.com.damsolutions.mda.util.NamingConvention;

public class Param extends Component {
	
	public String toString() {
	StringBuilder param = new StringBuilder();
	param.append("<"+NamingConvention.getJsfAjaxPrefix()+"param ");
	param.append("event=\""+ getEvent()+ " \"");
	param.append("render=\""+ getRender()+ " \"");
	param.append("execute=\""+ getExecute()+" \"");
	param.append("/>");
	return param.toString();
}

}
