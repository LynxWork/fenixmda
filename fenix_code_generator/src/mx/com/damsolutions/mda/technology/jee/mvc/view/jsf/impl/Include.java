package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

import mx.com.damsolutions.mda.util.NamingConvention;
import mx.com.damsolutions.util.StringUtil;

public class Include extends Component {

	 public Include(String id, String name, String entityName, String entityProperty){
		    this.id=id;
			this.name=name;
			this.entityName = entityName;
	    	this.entityProperty = entityProperty;
	    }
	 public String build() {
			StringBuilder include = new StringBuilder();
			include.append("<"+NamingConvention.getJsfAjaxPrefix()+"Include ");
			if( !StringUtil.isNull( buildStringId() ) ){
				include.append( buildId() ); 
			}
			if( !StringUtil.isNull( buildName() ) ){ 
				include.append( buildName() );
			}
			if( !StringUtil.isNull( buildAjaxRendered() ) ){ 
				include.append( buildAjaxRendered() );
			}
			if( !StringUtil.isNull( buildBinding() ) ){ 
				include.append( buildBinding() );
			}
			if( !StringUtil.isNull( buildDir() ) ){ 
				include.append(buildDir());
			}
			if( !StringUtil.isNull( buildkeepTransient() ) ){ 
				include.append(buildkeepTransient());
			}
			if( !StringUtil.isNull( buildLang() ) ){ 
				include.append(buildLang());
			}
			if( !StringUtil.isNull( layout ) ){ 
				include.append(" layout=\""+ getLayout()+ " \"");
			}
			if( !StringUtil.isNull( buildReRender() ) ){ 
				include.append(buildReRender());
			}
			if( !StringUtil.isNull( buildStyle() ) ){ 
				include.append(buildStyle());
			}
			if(!StringUtil.isNull(buildStyleClass())){
				include.append(buildStyleClass());
			}
			if( !StringUtil.isNull( buildTitle() ) ){ 
				include.append(buildTitle());
			}
			if( !StringUtil.isNull( buildType() ) ){ 
				include.append(buildType());
			}
			if( !StringUtil.isNull( viewId ) ){ 
				include.append(" viewId=\""+ getLayout()+ " \"");
			}
			include.append("/>");
			return include.toString();
		}

		
		@Override
		public String buildStringId(){
			return getEntityName()+getId()+"CmdInclude";
		}
		
		@Override
		public String buildStringName(){
			return getEntityName()+getName()+"CmdInclude";
		}
}
