package mx.com.damsolutions.mda.technology.jee.mvc.view.jsf.impl;

import mx.com.damsolutions.mda.util.NamingConvention;

public class ValidateRegex extends Validate{

    protected String pattern;

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	
	@Override
	public String toString() {
		//propiedad=\"" + string + "\" "
		StringBuilder resVal = new StringBuilder(); 
		resVal.append("<"+NamingConvention.getJsfCorePrefix()+":ValidateRegex ");
		resVal.append("id=\"" + getId() + "ValRegex\" ");
		if(getPattern()!=null && getPattern().length()>0){
			resVal.append(" pattern=\"" + getPattern() + "\" ");
		}
		resVal.append(" > ");
		resVal.append(" </ValidateRegex> ");
		return resVal.toString();
	}
	
}
