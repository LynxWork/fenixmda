package mx.com.damsolutions.mda.language.jee.impl;

import java.util.Iterator;
import java.util.List;

import mx.com.damsolutions.mda.language.IClass;
import mx.com.damsolutions.mda.language.INameSpace;
import mx.com.damsolutions.mda.language.IProperty;
import mx.com.damsolutions.util.CharacterUtil;

public class JClass implements IClass {

	private String name;
	private String accessModifier;
	private List<IProperty> propertyList;

	{
		//Valores por defecto
		accessModifier = JReservedWords.ACCESS_MODIFIER_PUBLIC;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(getAccessModifier());
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append(getClassDef());
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append(getInitClass());
		//Construir las propiedades
		List<IProperty> list = getPropertyList();
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			IProperty element = (IProperty) iter.next();
		}
		sb.append(getEndClass());
		return "";
	}

	public String getClassDef(){
		return JReservedWords.CLASS;
	}

	public List<IProperty> getPropertyList() {
		return propertyList;
	}

	public void setPropertyList(List<IProperty> propertyList) {
		this.propertyList = propertyList;
	}

	public String getInitClass() {
		return JReservedWords.INIT_BLOCK_CODE;
	}

	public String getEndClass() {
		return JReservedWords.END_BLOCK_CODE;
	}

	public String getAccessModifier() {
		return accessModifier;
	}

	public void setAccessModifier(String accessModifier) {
		this.accessModifier = accessModifier;
	}

	public INameSpace getNameSpace() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getQualifiedName() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
