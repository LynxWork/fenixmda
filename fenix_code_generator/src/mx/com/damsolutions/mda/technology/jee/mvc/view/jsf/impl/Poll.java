package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

import mx.com.damsolutions.mda.util.NamingConvention;

public class Poll extends Component {
	@Override
	public String build() {
		StringBuilder poll = new StringBuilder();
		poll.append("<"+NamingConvention.getJsfAjaxPrefix()+"poll ");
		poll.append("id=\""+ getId()+ " \"");
		poll.append("interval=\""+ getInterval()+ " \"");
		poll.append("enabled=\"#{" + NamingConvention.getClassControllerName( getEntityName() ) +"."+ getEntityProperty() +"\"} ");
		poll.append("render=\""+ getRender()+ " \"");
		poll.append("/>");
		return poll.toString();
	}

}
