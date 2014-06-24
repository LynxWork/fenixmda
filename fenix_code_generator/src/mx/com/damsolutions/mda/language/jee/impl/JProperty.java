package mx.com.damsolutions.mda.language.jee.impl;

import java.util.List;

import mx.com.damsolutions.mda.language.IProperty;

public class JProperty implements IProperty{

	public List<String> anotationList;
	public String name;
	public String type;

	public List<String> getAnotationList() {
		return anotationList;
	}
	public void setAnotationList(List<String> anotationList) {
		this.anotationList = anotationList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}