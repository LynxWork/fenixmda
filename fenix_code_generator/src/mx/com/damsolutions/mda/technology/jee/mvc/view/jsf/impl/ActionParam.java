package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

import mx.com.damsolutions.mda.util.NamingConvention;
import mx.com.damsolutions.util.StringUtil;

public class ActionParam extends Component {
	
	public ActionParam(String id, String name, String entityName, String entityProperty){
    	
		this.id=id;
		this.name=name;
		this.entityName = entityName;
    	this.entityProperty = entityProperty;
    }
	@Override
	public String build() {
		StringBuilder param = new StringBuilder();
		param.append("<"+NamingConvention.getJsfAjaxPrefix()+"ActionParam ");
		if( !StringUtil.isNull( getId() ) ){ 
			param.append( buildId() ); 
			}
		if( !StringUtil.isNull( buildName() ) ){ 
			param.append( buildName() );
			}
		if(!StringUtil.isNull(buildActionListener())){
			param.append(buildActionListener());	
		}
		if(!StringUtil.isNull(assignTo)){
			param.append("assignTo=\"#{"+ NamingConvention.getClassControllerName( getEntityName() ) +"."+ getEntityProperty()+"}" + "\" ");
		}
		if(!StringUtil.isNull(buildBinding())){
			param.append(buildBinding());
		}
		if(!StringUtil.isNull(converter)){
			param.append("converter=\"#{"+ NamingConvention.getClassControllerName( getEntityName() ) +"."+ getEntityProperty()+"}" + "\" ");
		}
		if(!StringUtil.isNull(buildNoEscape())){
			param.append(buildNoEscape());
		}
		if(!StringUtil.isNull(buildValue())){
			param.append(buildValue());
		}
		param.append("/>");
		return param.toString();
	}
	
	@Override
	public String buildStringId(){
		return getEntityProperty()+getId()+"CmdAParam";
		
	}
	
	@Override
	public String buildStringName(){
		return getEntityProperty()+getName()+"CmdAParam";
	}

	
}
