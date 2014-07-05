package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

import mx.com.damsolutions.mda.util.NamingConvention;
import mx.com.damsolutions.util.StringUtil;

public class Push extends Component {
	@Override
	public String build() {
		StringBuilder push = new StringBuilder();
		push.append("<"+NamingConvention.getJsfAjaxPrefix()+"push ");
		if( !StringUtil.isNull( getId() ) ){ push.append( buildId() ); }
		if( !StringUtil.isNull( buildName() ) ){ push.append( buildName() );}
		push.append("id=\""+ getId()+ " \"");
		push.append("address=\""+ getAddress()+ " \"");
		push.append("/>");
		return push.toString();
	}

}
