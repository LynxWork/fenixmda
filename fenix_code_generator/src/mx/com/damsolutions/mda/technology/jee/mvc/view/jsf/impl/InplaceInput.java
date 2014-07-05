package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

import mx.com.damsolutions.mda.util.NamingConvention;

public class InplaceInput extends InputTextField {

	public InplaceInput(String id, String name, String entityName,
			String entityProperty) {
		super(id, name, entityName, entityProperty);
		// TODO Auto-generated constructor stub
	}

	protected String defaultLabel;
	
	public String getDefaultLabel() {
		return defaultLabel;
	}

	public void setDefaultLabel(String defaultLabel) {
		this.defaultLabel = defaultLabel;
	}

	@Override
	public String build() {
		StringBuilder resVal = new StringBuilder(); 
		resVal.append("<"+NamingConvention.getJsfImplPrefix()+"inplaceInput ");
		resVal.append( buildId() );
		resVal.append("value=\"#{" + NamingConvention.getClassControllerName( getEntityName() ) +"."+ getEntityProperty() +"\"} ");
		if(getValidator()!=null && getValidator().length()>0){
			resVal.append(" validator=\"" + getValidator() + "\" ");
		}
		if(getRequired()!=null && getRequired().length()>0){
			resVal.append(" required=\""+ getRequired() +"\" ");
		}
		if(getValidatorMessage()!=null && getValidatorMessage().length()>0){
			resVal.append(" validatorMessage=\""+ getValidatorMessage() +"\" ");
		}
		if(getStyleClass()!=null && getStyleClass().length()>0){
			resVal.append(" styleClass=\""+ getStyleClass() +"\" ");
		}
		if(getDisabled()!=null && getDisabled().length()>0){
			resVal.append(" disabled=\""+ getDisabled() +"\" ");
		}
		if(getRendered()!=null && getRendered().length()>0){
			resVal.append(" rendered=\""+ getRendered() +"\" ");
		}
		resVal.append(" > ");
		//Set the validators components
		if(getMinimum()!=null && (getMinimum().length()>0 && getMaximum().length()>0)){
			ValidateLength validateLength = new ValidateLength();
			validateLength.setMinimum(getMinimum());
			validateLength.setMaximum(getMaximum());
			resVal.append(" " + validateLength.toString() + " ");
		}
		//End tag
		resVal.append(" </"+NamingConvention.getJsfImplPrefix()+"inplaceInput> ");
		return resVal.toString();
	}

	
	public String buildId(){
		return "id=\"" + this.buildNameId() + "\" ";
	}
	
	public String buildNameId(){
		return getEntityName()+getEntityProperty()+"InTxt";
	}
	

}
