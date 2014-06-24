package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

import mx.com.damsolutions.mda.util.NamingConvention;

public class ValidateLength extends Validate{

	protected String minimum;
	protected String maximum;
	
	public String getMinimum() {
		return minimum;
	}
	public void setMinimum(String minimum) {
		this.minimum = minimum;
	}
	public String getMaximum() {
		return maximum;
	}
	public void setMaximum(String maximum) {
		this.maximum = maximum;
	}

	
	@Override
	public String toString() {
		//propiedad=\"" + string + "\" "
		StringBuilder resVal = new StringBuilder(); 
		resVal.append("<"+NamingConvention.getJsfCorePrefix()+"ValidateLength ");
		resVal.append("id=\"" + getId() + "ValLen\" ");
		if(getMinimum()!=null && getMinimum().length()>0){
			resVal.append(" minimum=\"" + getMinimum() + "\" ");
		}
		if(getMaximum()!=null && getMaximum().length()>0){
			resVal.append(" maximum=\""+ getMaximum() +"\" ");
		}
		if(getForComponent()!=null && getForComponent().length()>0){
			resVal.append(" for=\""+ getForComponent() +"\" ");
		}
		if(getBinding()!=null && getBinding().length()>0){
			resVal.append(" binding=\""+ getBinding() +"\" ");
		}
		resVal.append(" > ");
		resVal.append(" </"+NamingConvention.getJsfCorePrefix()+"ValidateLength> ");
		return resVal.toString();
	}
	
}
