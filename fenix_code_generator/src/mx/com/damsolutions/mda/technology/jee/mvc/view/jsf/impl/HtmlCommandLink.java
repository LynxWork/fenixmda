package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

import mx.com.damsolutions.mda.util.NamingConvention;
import mx.com.damsolutions.util.StringUtil;


public class HtmlCommandLink extends Component {
	
	 public HtmlCommandLink(String id, String name, String entityName, String entityProperty){
			this.id=id;
			this.name=name;
			this.entityName = entityName;
	    	this.entityProperty = entityProperty;
	    }
	@Override
	public String build() {
		StringBuilder link = new StringBuilder();
		link.append("<"+NamingConvention.getJsfAjaxPrefix()+"HtmlCommandLink ");
		if( !StringUtil.isNull( buildStringId() ) ){
			link.append( buildId() ); 
		}
		if( !StringUtil.isNull( buildName() ) ){ 
			link.append( buildName() );
		}
		if( !StringUtil.isNull( buildAccesskey() ) ){ 
			link.append( buildAccesskey() );
		}
		if( !StringUtil.isNull( buildAction() ) ){ 
			link.append( buildAction() );
		}
		if( !StringUtil.isNull( buildActionListener() ) ){ 
			link.append( buildActionListener() );
		}
		if( !StringUtil.isNull( buildBinding() ) ){ 
			link.append( buildBinding() );
		}
		if( !StringUtil.isNull( charset ) ){ 
			link.append("charset=\""+ getCharset()+ " \"");
		}
		if( !StringUtil.isNull( coords ) ){ 
			link.append("coords=\""+ getCoords()+ " \"");
		}
		if( !StringUtil.isNull( buildData() ) ){ 
			link.append(buildData());
		}
		if( !StringUtil.isNull( buildDir() ) ){ 
			link.append(buildDir());
		}
		if( !StringUtil.isNull( buildDisabled() ) ){ 
			link.append(buildDisabled());
		}
		if( !StringUtil.isNull( buildEventsQueue() ) ){ 
			link.append(buildEventsQueue());
		}
		if( !StringUtil.isNull( buildFocus() ) ){ 
			link.append(buildFocus());
		}
		if( !StringUtil.isNull( hreflang ) ){ 
			link.append("hreflang=\""+ getHreflang()+ " \"");
		}
		if( !StringUtil.isNull( buildIgnoreDupResponses() ) ){ 
			link.append(buildIgnoreDupResponses());
		}
		if( !StringUtil.isNull( buildImmediate() ) ){ 
			link.append(buildImmediate());
		}
		if( !StringUtil.isNull( buildLang() ) ){ 
			link.append(buildLang());
		}
		if( !StringUtil.isNull( buildLimitToList() ) ){ 
			link.append(buildLimitToList());
		}
		if( !StringUtil.isNull( buildOnbeforedomupdate() ) ){ 
			link.append(buildOnbeforedomupdate());
		}
		if( !StringUtil.isNull( onblur ) ){ 
			link.append("onblur=\""+ getOnblur()+ " \"");
		}
		if( !StringUtil.isNull( buildOnclick() ) ){ 
			link.append(buildOnclick());
		}
		if( !StringUtil.isNull( buildOncomplete() ) ){ 
			link.append(buildOncomplete());
		}
		if( !StringUtil.isNull( buildOndblclick() ) ){ 
			link.append(buildOndblclick());
		}
		if( !StringUtil.isNull( onfocus ) ){ 
			link.append("onfocus=\""+ getOnblur()+ " \"");
		}
		if( !StringUtil.isNull( buildOnkeydown() ) ){ 
			link.append(buildOnkeydown());
		}
		if( !StringUtil.isNull( buildOnkeypress() ) ){ 
			link.append(buildOnkeypress());
		}
		if( !StringUtil.isNull( buildOnkeyup() ) ){ 
			link.append(buildOnkeyup());
		}
		if( !StringUtil.isNull( buildOnmousedown() ) ){ 
			link.append(buildOnmousedown());
		}
		if( !StringUtil.isNull( buildOnmousemove() ) ){ 
			link.append(buildOnmousemove());
		}
		if( !StringUtil.isNull( buildOnmouseout() ) ){ 
			link.append(buildOnmouseout());
		}
		if( !StringUtil.isNull( buildOnmouseover() ) ){ 
			link.append(buildOnmouseover());
		}
		if( !StringUtil.isNull( buildOnmouseup() ) ){ 
			link.append(buildOnmouseup());
		}
		if( !StringUtil.isNull( buildProcess() ) ){ 
			link.append(buildProcess());
		}
		if( !StringUtil.isNull( buildReRender() ) ){ 
			link.append(buildReRender());
		}
		if( !StringUtil.isNull( rel ) ){ 
			link.append("rel=\""+ getRel()+ " \"");
		}
		if( !StringUtil.isNull( buildRendered() ) ){ 
			link.append(buildRendered());
		}
		if( !StringUtil.isNull( rev ) ){ 
			link.append(" rev=\""+"2.0"+ " \"");
		}
		if( !StringUtil.isNull( shape ) ){ 
			link.append(" shape=\""+"1.0"+ " \"");
		}
		if( !StringUtil.isNull( buildStyle() ) ){ 
			link.append(buildStyle());
		}
		if( !StringUtil.isNull( tabindex ) ){ 
			link.append(" tabindex=\"#{"+ NamingConvention.getClassControllerName( getEntityName() ) +"."+ getEntityProperty()+"}" + "\" ");
		}
		if( !StringUtil.isNull( target ) ){ 
			link.append(" target=\"#{"+ NamingConvention.getClassControllerName( getEntityName() ) +"."+ getEntityProperty()+"}" + "\" ");
		}
		if( !StringUtil.isNull( buildTimeout() ) ){ 
			link.append(buildTimeout());
		}
		if( !StringUtil.isNull( buildTitle() ) ){ 
			link.append(buildTitle());
		}
		if( !StringUtil.isNull( buildType() ) ){ 
			link.append(buildType());
		}
		if( !StringUtil.isNull( buildValue() ) ){ 
			link.append(buildValue());
		}
		link.append("/>");
		return link.toString();
	}
	
	@Override
	public String buildStringId(){
		return getEntityProperty()+getId()+"CmdHCL";
		
	}
	
	@Override
	public String buildStringName(){
		return getEntityProperty()+getName()+"CmdHCL";
	}
}
