package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

import mx.com.damsolutions.mda.util.NamingConvention;

public class Poll extends Component {
	
	 public Poll(String entityName, String entityProperty){
	    	
	    	this.entityName = entityName;
	    	this.entityProperty = entityProperty;
	    }
	@Override
	public String toString() {
		StringBuilder poll = new StringBuilder();
		poll.append("<"+ NamingConvention.getJsfAjaxPrefix()+"poll "  );
		poll.append(NamingConvention.getIdJsfImplPrefix()+"=\"" +"poll" + " \"");
		poll.append("interval=\"" + getInterval()+ " \"");
		poll.append("enabled=\"#{"+ NamingConvention.getClassControllerName( getEntityName() ) +"."+ getEntityProperty()+"}" + "\" ");
		poll.append("render=\" "+ getRender()+ " \"");
		poll.append("/>");
		return poll.toString();
	}

}
