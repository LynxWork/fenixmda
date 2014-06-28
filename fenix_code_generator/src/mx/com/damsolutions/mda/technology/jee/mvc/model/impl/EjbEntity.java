package mx.com.damsolutions.mda.technology.jee.mvc.model.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import mx.com.damsolutions.mda.core.generator.dml.DMLJpqlCodeGenerator;
import mx.com.damsolutions.mda.metamodel.Entity;
import mx.com.damsolutions.mda.metamodel.Property;
import mx.com.damsolutions.mda.technology.jee.definitions.JEEAnotationsDefinitions;
import mx.com.damsolutions.mda.util.MapDataTypes;
import mx.com.damsolutions.mda.util.NamingConvention;

public class EjbEntity extends Entity{

	public final String QUERY_TYPE_FIND_ALL = "findAll";
	public final String QUERY_TYPE_FIND_BY_RANGE = "findByRange";
	public final String QUERY_TYPE_FIND_BY_PROPERTY = "findByProperty";
	
	public final String SEQUENCE_GENERATOR_TYPE_ORACLE = "ORCL_SEQUENCE";
	public final String SEQUENCE_GENERATOR_TYPE_MYSQL = "MYSQL_AUTOINCREMENT";
	
	public final String GENERATED_VALUE_AUTO = "AUTOINCREMENT";
	
	public final String PRIMARY_KEY_TYPE_AUTO = "AUTOINCREMENT";


	public EjbEntity(Entity entity){
		this.setNamespace(entity.getNamespace());
		this.setName(entity.getName());
		this.setType(entity.getType());
		this.setId(entity.getId());
		this.setDescription(entity.getDescription());
		this.setProperties(entity.getProperties());
		this.setEntitySup(entity.getEntitySup());
	}
	

	public String build() {
		StringBuilder sb = new StringBuilder();


		/****************************************************************************************************
		 * PAQUETE DE LA CLASE
		 * **************************************************************************************************/
		sb.append("package " + getNamespace().toLowerCase()+ ";");
				
		/****************************************************************************************************
		 * CONSTRUCCION DE LAS IMPORTACIONES DE CLASES DE LA ENTIDAD
		 * **************************************************************************************************/
		sb.append(
				"import java.io.Serializable;" +
				"import java.util.List;" +
				"import javax.persistence.Column;" +
				"import javax.persistence.Entity;" +
				"import javax.persistence.GeneratedValue;" +
				"import javax.persistence.GenerationType;" +
				"import javax.persistence.Id;" +
				"import javax.persistence.NamedQueries;" +
				"import javax.persistence.NamedQuery;" +
				"import javax.persistence.OneToMany;" +
				"import javax.persistence.SequenceGenerator;" +
				"import javax.persistence.Table;");

		sb.append("import javax.persistence.OneToMany;");
		
		/****************************************************************************************************/
		
		
		/****************************************************************************************************
		 * CONSTRUCCION DE LAS META ANOTACIONES DEL EJB
		 * **************************************************************************************************/
		sb.append(getEntityAnotation()+'\n');
		sb.append(buildDefaultNamedQueries()+'\n');
		sb.append(getTableNameAnotation()+'\n');
		/****************************************************************************************************/

		/****************************************************************************************************
		 * CONSTRUCCION DE la clase
		 * **************************************************************************************************/
		sb.append(" public class "+getName()+" implements Serializable { ");
		sb.append(" private static final long serialVersionUID = 1L; ");
		
		/****************************************************************************************************
		 * CONSTRUCCION DE LAS POPIEDADES DE LA CLASE
		 * **************************************************************************************************/
		sb.append("/********************************************************************************************");
		sb.append("*                                  PROPERTY ENTITY DEFINITION                               *");
		sb.append("*********************************************************************************************/");
		sb.append(buildPrimaryKeyProperty(this.PRIMARY_KEY_TYPE_AUTO));
		sb.append( buildProperties());
		/****************************************************************************************************/

		/****************************************************************************************************
		 * CONSTRUCCION DE LOS ACCESORS DE LA CLASE
		 * **************************************************************************************************/
		sb.append("/********************************************************************************************");
		sb.append("*                                  PROPERTY ACCESSORS DEFINITION                            *");
		sb.append("********************************************************************************************/");
		sb.append( buildAccessors());
		/****************************************************************************************************/

		/****************************************************************************************************
		 * CONSTRUCCION DE LOS MUTATORS DE LA CLASE
		 * **************************************************************************************************/
		sb.append("/********************************************************************************************");
		sb.append("*                                  PROPERTY MUTATORS DEFINITION                             *");
		sb.append("*********************************************************************************************/");
		sb.append( buildMutators());
		/****************************************************************************************************/

		sb.append(" } ");
		
		/****************************************************************************************************/


		return sb.toString();
	}

	
	private String getGeneratedValueAnotation(String strategic){
		StringBuffer sb = new StringBuffer();
		if(strategic.equals(this.GENERATED_VALUE_AUTO)){
			sb.append( "@GeneratedValue( strategy = GenerationType.IDENTITY)" );
		}
		return sb.toString();
	}

	
	private String buildDefaultNamedQueries(){
		StringBuffer sb = new StringBuffer();
		List<String> arrayNamedQuery = new ArrayList<String>();
		//Build findAll
		arrayNamedQuery.add(getNamedQueryAnotation(getName(), this.QUERY_TYPE_FIND_ALL,null));
		//Build By property
		for (Property p : getProperties()) {
			arrayNamedQuery.add(getNamedQueryAnotation(getName(), this.QUERY_TYPE_FIND_BY_PROPERTY,p.getName() ));
		}
		//Build By Range
		for (Property p : getProperties()) {
			if( !p.getDataType().getName().equals(MapDataTypes.DATA_TYPE_TEXT) || 
				!p.getDataType().getName().equals(MapDataTypes.DATA_TYPE_TEXT_AREA)	){
			arrayNamedQuery.add(getNamedQueryAnotation(getName(), this.QUERY_TYPE_FIND_BY_RANGE,p.getName() ));
			}
		}
		sb.append( getNamedQueriesAnotation(arrayNamedQuery) );
		return sb.toString();
	}
	
	
	private String getNamedQueriesAnotation(List<String> namedQueryList){
		StringBuffer sb = new StringBuffer();
		sb.append(JEEAnotationsDefinitions.PERSISTENCE_ANOTATION_NAMED_QUERIES+"({");
		int i=0;
		for(String namedQuery: namedQueryList){
			if(namedQueryList.size()!=i){
				sb.append(namedQuery +",");
			}else{
				sb.append(namedQuery);
			}
			i++;
		}
		sb.append("})");
		return sb.toString();
	}

	private String getNamedQueryAnotation(String queryName, String queryType, String entityPropertyName){
		StringBuffer sb = new StringBuffer();
		DMLJpqlCodeGenerator gen = DMLJpqlCodeGenerator.getInstance();
		 //" @NamedQuery(name = \"CatError.findAll\", query = \"select o from CatError o\")})" +
		sb.append(JEEAnotationsDefinitions.PERSISTENCE_ANOTATION_NAMED_QUERY+"(");
		if(entityPropertyName!=null && entityPropertyName.length()>0){
			sb.append("name = \""+ getName() +"."+queryType+ NamingConvention.getPropertyUpperName(entityPropertyName)+ "\",");
		}else{
			sb.append("name = \""+ getName() +"."+queryType+"\",");
		}
		if(queryType.equals(this.QUERY_TYPE_FIND_ALL)){
			sb.append("query = \""+gen.getSelectStatementFindAll(getName())+"\"");
		}else if(queryType.equals(this.QUERY_TYPE_FIND_BY_PROPERTY)){
			sb.append("query = \""+gen.getSelectStatementByProperty(getName(), entityPropertyName)+"\"");
		}else if(queryType.equals(this.QUERY_TYPE_FIND_BY_RANGE)){
			sb.append("query = \""+gen.getSelectStatementByRange(getName(), entityPropertyName)+"\"");
		}
		sb.append(")");
		return sb.toString();
	}


	private String getEntityAnotation(){
		StringBuffer sb = new StringBuffer();
		sb.append(JEEAnotationsDefinitions.PERSISTENCE_ANOTATION_ENTITY);
		return sb.toString();
	}
	
	private String getTableNameAnotation(){
		StringBuffer sb = new StringBuffer();
		sb.append(JEEAnotationsDefinitions.PERSISTENCE_ANOTATION_TABLE+"(name = \""+NamingConvention.getTableName(getName())+"\")");
		return sb.toString();
	}

	public String buildPrimaryKeyProperty(String type){
		StringBuffer sb = new StringBuffer();
		sb.append(JEEAnotationsDefinitions.PERSISTENCE_ANOTATION_ID);
		if(type.equals(this.PRIMARY_KEY_TYPE_AUTO)){
	sb.append(JEEAnotationsDefinitions.PERSISTENCE_ANOTATION_GENERATED_VALUE+ "( strategy = GenerationType.IDENTITY )");
		}
		sb.append( JEEAnotationsDefinitions.PERSISTENCE_ANOTATION_COLUMN+"( name = \""+ NamingConvention.getTablePrimaryKeyName(getName()) + "\" )" );
		sb.append( "private Long " + NamingConvention.getPropertyPrimaryKeyName(getName()) + ";" );
		return sb.toString();
	}

	public String getColumnAnotation(Property property){
		//Construir las propiedades
		StringBuilder sb = new StringBuilder();
		sb.append(JEEAnotationsDefinitions.PERSISTENCE_ANOTATION_COLUMN+"(name=\"" +NamingConvention.getColumnName(property.getName())+ "\", nullable = "+property.isNillable()+", length = "+property.getLenght()+")");
		return sb.toString();
	}
	
	public String buildProperties(List<Property> property){
		StringBuilder sb = new StringBuilder();
		for (Iterator<Property> iter = property.iterator(); iter.hasNext();) {
			Property p = iter.next();
			sb.append(buildProperty(p));
		}
		return sb.toString();
	}
	
	public String buildProperties(){
		return buildProperties(getProperties());
	}

	public String buildProperty(Property property){
		//Construir las propiedades
		StringBuilder sb = new StringBuilder();
		sb.append(getColumnAnotation(property));
		sb.append(" private " + MapDataTypes.getJavaDataType(property.getDataType()) + " " + property.getName() + ";");
		return sb.toString();
	}
	
	
	public String buildAccessors(){
		return buildAccessors(getProperties());
	}
	
	public String buildAccessors(List<Property> properties){
		StringBuilder sb = new StringBuilder();
		for (Property p : properties) {
			sb.append(buildAccessor(p));
		}
		return sb.toString();
	}
	
	public String buildAccessor(Property property){
		StringBuilder sb = new StringBuilder();
		sb.append("public " + MapDataTypes.getJavaDataType(property.getDataType()) + " " + NamingConvention.getAccesorMethodName( property.getName() + "(){" ) );
		sb.append("return this." + property.getName() + ";");
		sb.append("}");
		return sb.toString();
	}

	public String buildMutators(){
		return buildMutators(getProperties());
	}
	
	public String buildMutators(List<Property> properties){
		StringBuilder sb = new StringBuilder();
		for (Property p : properties) {
			sb.append(buildMutator(p));
		}
		return sb.toString();
	}
	
	public String buildMutator(Property property){
		StringBuilder sb = new StringBuilder();
		sb.append("public " + " void " + NamingConvention.getMutatorMethodName( property.getName() + "("+ MapDataTypes.getJavaDataType(property.getDataType()) + " " + property.getName()+"){" ) );
		sb.append("this." + property.getName() + " = " + property.getName() +";");
		sb.append("}");
		return sb.toString();
	}
	
	
}
