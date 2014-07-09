package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

import mx.com.damsolutions.mda.util.NamingConvention;
import mx.com.damsolutions.util.StringUtil;

public class AjaxListener extends Component {
	
	public AjaxListener(String id, String name, String entityName, String entityProperty){
		this.id=id;
		this.name=name;
		this.entityName = entityName;
    	this.entityProperty = entityProperty;
	}
		
		public String build() {
			StringBuilder listener = new StringBuilder();
			listener.append("<"+NamingConvention.getJsfAjaxPrefix()+"AjaxListener ");
			if( !StringUtil.isNull( getId() ) ){ 
				listener.append( buildId() ); 
				}
			if( !StringUtil.isNull( buildName() ) ){
				listener.append( buildName() );
				}
			if( !StringUtil.isNull( buildType() ) ){
				listener.append( buildType() );
				}
			listener.append("/>");
			return listener.toString();
		}
		
		@Override
		public String buildStringId(){
			return getEntityProperty()+getId()+"CmdAjl";
			
		}
		
		@Override
		public String buildStringName(){
			return getEntityProperty()+getName()+"CmdAjl";
		}

	}



