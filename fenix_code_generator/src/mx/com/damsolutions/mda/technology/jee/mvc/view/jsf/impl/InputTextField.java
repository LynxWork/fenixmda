package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

import mx.com.damsolutions.mda.util.NamingConvention;

public class InputTextField extends TextField{

    protected String validator;
    protected String required;
    protected String validatorMessage;
    protected String pattern;

    public InputTextField(String id, String name,String entityName, String entityProperty){
    	this.id=id;
    	this.name=name;
    	this.entityName = entityName;
    	this.entityProperty = entityProperty;
    }

	public String getPattern() {
		return pattern;
	}


	public void setPattern(String pattern) {
		this.pattern = pattern;
	}


	public String getValidator() {
		return validator;
	}


	public void setValidator(String validator) {
		this.validator = validator;
	}


	public String getRequired() {
		return required;
	}


	public void setRequired(String required) {
		this.required = required;
	}


	public String getValidatorMessage() {
		return validatorMessage;
	}

	public void setValidatorMessage(String validatorMessage) {
		this.validatorMessage = validatorMessage;
	}

	@Override
	public String build() {
		//propiedad=\"" + string + "\" "
		StringBuilder resVal = new StringBuilder(); 
		resVal.append("<"+NamingConvention.getJsfHtmlPrefix()+"inputText ");
		resVal.append("id=\"" + getId() + "\" ");
		resVal.append("name=\"" + getName() + "\" ");
		resVal.append("label=\"" + getLabel() + "\" ");
		resVal.append("value=\"#{" + NamingConvention.getClassControllerName( getEntityName() ) +"."+ getEntityProperty() +"\"} ");
		resVal.append("shortDesc=\"" + getDescription() + "\" ");
		resVal.append("/>");
		return resVal.toString();
	}

}
