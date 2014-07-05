package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

import mx.com.damsolutions.mda.util.NamingConvention;
import mx.com.damsolutions.util.StringUtil;

public class ActionParam extends Component {
	
	public ActionParam(String entityName, String entityProperty){
    	
    	this.entityName = entityName;
    	this.entityProperty = entityProperty;
    }
	@Override
	public String build() {
		StringBuilder param = new StringBuilder();
		param.append("<"+NamingConvention.getJsfAjaxPrefix()+"ActionParam ");
		if( !StringUtil.isNull( getId() ) ){ param.append( buildId() ); }
		if( !StringUtil.isNull( buildName() ) ){ param.append( buildName() );}
		param.append("actionListener=\""+ getActionListener()+ " \"");
		param.append("assignTo=\"#{"+ NamingConvention.getClassControllerName( getEntityName() ) +"."+ getEntityProperty()+"}" + "\" ");
		param.append("binding=\""+ getBinding()+ " \"");
		param.append("converter=\""+ getConverter()+ " \"");
		param.append("noEscape=\""+ getNoEscape()+ " \"");
		param.append("value=\""+ getValue()+ " \"");
		param.append(" " + buildStyleClass() +" ");
		param.append("/>");
		return param.toString();
	}
	
	
}
