package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

import mx.com.damsolutions.mda.util.NamingConvention;

public class AjaxListener extends Component {
		@Override
		public String build() {
			StringBuilder listener = new StringBuilder();
			listener.append("<"+NamingConvention.getJsfAjaxPrefix()+"AjaxListener ");
			listener.append(NamingConvention.getTypeJsfImplPrefix()+"=\"" +"org.docs.richfaces.actionListenerBean" + " \"");
			listener.append(" " + buildStyleClass() +" ");
			listener.append("/>");
			return listener.toString();
		}
	}



