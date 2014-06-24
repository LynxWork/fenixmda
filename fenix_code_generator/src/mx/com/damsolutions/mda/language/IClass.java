package mx.com.damsolutions.mda.language;

import java.util.List;

public interface IClass {

	public String getClassDef();
	
	public String getName();

	public INameSpace getNameSpace();
	
	public String getQualifiedName();
	
	public void setName(String name);

	
	public List<IProperty> getPropertyList();

	public void setPropertyList(List<IProperty> propertyList);
	
	public String getInitClass();
	
	public String getEndClass();
	
}
