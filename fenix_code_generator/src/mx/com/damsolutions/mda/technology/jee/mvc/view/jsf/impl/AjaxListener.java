package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

import mx.com.damsolutions.mda.util.NamingConvention;
import mx.com.damsolutions.util.StringUtil;

public class AjaxListener extends Component {
		@Override
		public String build() {
			StringBuilder listener = new StringBuilder();
			listener.append("<"+NamingConvention.getJsfAjaxPrefix()+"AjaxListener ");
			if( !StringUtil.isNull( getId() ) ){ listener.append( buildId() ); }
			if( !StringUtil.isNull( buildName() ) ){ listener.append( buildName() );}
			listener.append(" " + buildStyleClass() +" ");
			listener.append("/>");
			return listener.toString();
		}
	}



