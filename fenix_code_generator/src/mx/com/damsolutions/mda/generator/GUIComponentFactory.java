package mx.com.damsolutions.mda.generator;

import org.apache.log4j.Logger;

import mx.com.damsolutions.mda.metamodel.Property;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.Component;
import mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl.InputTextField;
import mx.com.damsolutions.mda.base.Framework;
import mx.com.damsolutions.mda.base.Language;

public class GUIComponentFactory {

	private static Logger log = Logger.getLogger(GUIComponentFactory.class);
	
	private Language language;
	private Framework framework;
	private InputTextField component;
	
	public Framework getFramework() {
		return framework;
	}

	public void setFramework(Framework framework) {
		this.framework = framework;
	}

	public GUIComponentFactory(Language language){
		this.language = language;
	}

	public GUIComponentFactory(Framework framework){
		this.framework = framework;
	}
	
	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}
	
	public Component getInputTextField(Property property){
		component = new InputTextField("nameId","Nombre","Usuario","nombre");
		if(framework!=null){
			if(framework.getName().equals("JBOSS_SEAM")){
				log.debug("SEAM Framework");
				log.debug("log.debug(SEAM Framework);"+property.getEntity().getName());
				component.setId(property.getId().toString());
				component.setEntityName(property.getEntity().getName());
				component.setEntityProperty(property.getName());
				component.setName(property.getEntity().getName());
			}else{
				log.debug("Not Framework");
			} 
		}else{
			log.debug("No Technology");
		}
		return component;
	}


}
