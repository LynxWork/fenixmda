package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

import mx.com.damsolutions.mda.util.NamingConvention;
import mx.com.damsolutions.util.StringUtil;

public class KeepAlive extends Component {
	
	public KeepAlive(String id, String name, String entityName, String entityProperty){
		this.id=id;
		this.name=name;
		this.entityName = entityName;
    	this.entityProperty = entityProperty;
	}
	public String build() {
		//propiedad=\"" + string + "\" "
		StringBuilder keepAlive = new StringBuilder();
		keepAlive.append("<"+NamingConvention.getJsfAjaxPrefix()+"keepAlive ");
		if( !StringUtil.isNull( buildStringId() ) ){
			keepAlive.append( buildId() ); 
		}
		if( !StringUtil.isNull( buildName() ) ){ 
			keepAlive.append( buildName() );
		}
		if( !StringUtil.isNull( ajaxOnly ) ){ 
			keepAlive.append(" ajaxOnly=\"#{"+ NamingConvention.getClassControllerName( getEntityName() ) +"."+ getEntityProperty()+"}" + "\" ");
		}
		if( !StringUtil.isNull( beanName ) ){ 
			keepAlive.append(" beanName=\"#{"+ NamingConvention.getClassControllerName( getEntityName() ) +"."+ getEntityProperty()+"}" + "\" ");
		}
		keepAlive.append("/>");
		return keepAlive.toString();
	}

	@Override
	public String buildStringId(){
		return getEntityProperty()+getId()+"CmdkeepAlive";
		
	}
	
	@Override
	public String buildStringName(){
		return getEntityProperty()+getName()+"CmdkeepAlive";
	}

}
