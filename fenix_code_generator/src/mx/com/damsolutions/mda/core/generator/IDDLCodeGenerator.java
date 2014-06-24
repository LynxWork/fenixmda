package mx.com.damsolutions.mda.core.generator;

import mx.com.damsolutions.mda.metamodel.Entity;
import mx.com.damsolutions.mda.metamodel.Property;


public interface IDDLCodeGenerator {

	public String getDDLTable(Entity entity);
	
	public String getDDLTable(String prefix,Entity entity);
	
	public String getDDLColumn(Property property);
	
	public String getDDLPk(Entity entity);
	
	public String getDDLFk(Entity entitySource, Entity entityTarget);
	
	public String getDDLConstrain();
	
}
