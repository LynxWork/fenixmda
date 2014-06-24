package mx.com.damsolutions.mda.language.jee.impl;

import mx.com.damsolutions.mda.language.INameSpace;

public class JNameSpace implements INameSpace {

	private String qualifiedName;
	private String nameSpace;
	
	public JNameSpace(String qualifiedName){
		this.qualifiedName = qualifiedName;
	}
	
	public String getNameSpace() {
		return nameSpace;
	}
	public void setNameSpace(String nameSpace) {
		this.nameSpace = nameSpace;
	}
	public String getQualifiedName() {
		return qualifiedName;
	}
	public void setQualifiedName(String qualifiedName) {
		this.qualifiedName = qualifiedName;
	}
	


}
