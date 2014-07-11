package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

import mx.com.damsolutions.mda.util.NamingConvention;
import mx.com.damsolutions.util.StringUtil;

public class LoadBundle extends Component {
	public LoadBundle(String id, String name, String entityName, String entityProperty){
		this.id=id;
		this.name=name;
		this.entityName = entityName;
    	this.entityProperty = entityProperty;
	}
	
	public String build() {
		//propiedad=\"" + string + "\" "
		StringBuilder loadBundle = new StringBuilder();
		loadBundle.append("<"+NamingConvention.getJsfAjaxPrefix()+"loadBundle ");
		if( !StringUtil.isNull( buildStringId() ) ){
			loadBundle.append( buildId() ); 
		}
		if(!StringUtil.isNull( beanName )){
	        loadBundle.append(" beanName=\""+ getBeanName()+ " \"");
		}
		if(!StringUtil.isNull(buildBinding())){
			loadBundle.append(buildBinding());
		}
		if(!StringUtil.isNull(buildRendered())){
			loadBundle.append(buildRendered());
		}
		if(!StringUtil.isNull( var )){
	        loadBundle.append(" var=\""+ getBeanName()+ " \"");
		}
		
		loadBundle.append("/>");
		return loadBundle.toString();
	}
	
	@Override
	public String buildStringId(){
		return getEntityProperty()+getId()+"CmdloadBundle";
		
	}
	
	@Override
	public String buildStringName(){
		return getEntityProperty()+getName()+"CmdloadBundle";
	}
}
