package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

import mx.com.damsolutions.mda.util.NamingConvention;
import mx.com.damsolutions.util.StringUtil;

public class Poll extends Component {
	
	 public Poll(String entityName, String entityProperty){
	    	
	    	this.entityName = entityName;
	    	this.entityProperty = entityProperty;
	    }
	@Override
	public String toString() {
		StringBuilder poll = new StringBuilder();
		poll.append("<"+ NamingConvention.getJsfAjaxPrefix()+"poll "  );
		if( !StringUtil.isNull( getId() ) ){ poll.append( buildId() ); }
		if( !StringUtil.isNull( buildName() ) ){ poll.append( buildName() );}
		poll.append("interval=\"" + getInterval()+ " \"");
		poll.append("enabled=\"#{"+ NamingConvention.getClassControllerName( getEntityName() ) +"."+ getEntityProperty()+"}" + "\" ");
		poll.append("render=\" "+ getRender()+ " \"");
		poll.append("/>");
		return poll.toString();
	}

}
