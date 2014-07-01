package mx.com.damsolutions.mda.core.generator.ddl;

import java.util.List;









import mx.com.damsolutions.core.db.config.DataBaseConfiguration;
import mx.com.damsolutions.mda.metamodel.Entity;
import mx.com.damsolutions.mda.metamodel.Property;
import mx.com.damsolutions.util.CharacterUtil;


public class DDLMySqlCodeGenerator implements IDDLCodeGenerator{

	public String getDDLTable(String prefix,Entity entity) {
		String prefixName = prefix+entity.getName(); 
		entity.setName(prefixName);
		return getDDLTable(entity);
	}


	/**
	 * Crea el codigo DDL para la creacion de la tabla
	 * **/
	public String getDDLTable(Entity entity) {
		StringBuilder sb = new StringBuilder();
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append("CREATE");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append("TABLE");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append(entity.getName().toUpperCase());
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append("(");
		List<Property> properties = entity.getProperties();
		//Create primary key
		sb.append(getDDLPk(entity));
		sb.append(CharacterUtil.SPACE_VALUE);
		for (Property property : properties) {
			sb.append(","+getDDLColumn(property).toUpperCase());
		}
		sb.append(")");
		if(DataBaseConfiguration.STORAGE_ENGINE!=null && DataBaseConfiguration.STORAGE_ENGINE.equals("")){
			sb.append("TYPE="+DataBaseConfiguration.STORAGE_ENGINE);
		}
		return sb.toString();
	}

	/**
	 * Genera el codigo para crear la llave primaria de la tabla
	 * **/
	public String getDDLPk(Entity entity) {
		StringBuilder sb = new StringBuilder();
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append(entity.getName().toUpperCase()+"_PK");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append("INT");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append("NOT");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append("NULL");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append("AUTO_INCREMENT");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append(", PRIMARY");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append("KEY");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append("(");
		sb.append(entity.getName().toUpperCase()+"_PK");
		sb.append(")");
		sb.append(CharacterUtil.SPACE_VALUE);
		return sb.toString();
	}

	
	public String getDDLColumn(Property property) {
		StringBuilder sb = new StringBuilder();
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append(property.getName());
		sb.append(CharacterUtil.SPACE_VALUE);
		String strMapDataType = mapDataType(property.getDataType().getName());
		if(property.getDataType().getName().equals("String")){
			strMapDataType = strMapDataType+"("+property.getLenght()+")";
		}
		sb.append(strMapDataType);
		if(property.isNillable()){
			sb.append(CharacterUtil.SPACE_VALUE);
			sb.append("NOT");
			sb.append(CharacterUtil.SPACE_VALUE);
			sb.append("NULL");			
		}
		sb.append(CharacterUtil.SPACE_VALUE);
		return sb.toString();
	}
	
	
	public String getDDLConstrain() {		
		return null;
	}

	public String getDDLFk(Entity entitySource, Entity entityTarget) {
		StringBuilder sb = new StringBuilder();
		sb.append("ALTER");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append("TABLE");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append(entitySource.getName());
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append("ADD");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append("CONSTRAINT");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append("FK_"+entitySource.getName().toUpperCase()+
				"_"+entityTarget.getName().toUpperCase());
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append("FOREIGN");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append("KEY");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append("(");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append("");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append(entityTarget.getName().toUpperCase()+"_FK");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append(")");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append("REFERENCES");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append(entityTarget.getName().toUpperCase());
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append("(");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append(entityTarget.getName().toUpperCase()+"_PK");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append("");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append(")");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append("ON");		
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append("UPDATE");		
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append("RESTRICT");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append("ON");	
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append("DELETE");
		sb.append(CharacterUtil.SPACE_VALUE);
		sb.append("RESTRICT");
		sb.append(CharacterUtil.SPACE_VALUE);
		return sb.toString();
	}


	/**
	 * Mapea los tipos de datos utilizados por el framework contra los tipos de datos 
	 * utilizados por la base de datos especifica.
	 * Tipos de datos numericos
	 * TINYINT 		1 	-128 	127
  	 * 				0 	255
	 * SMALLINT 	2 	-32768 	32767
  	 *				0 	65535
	 * MEDIUMINT 	3 	-8388608 	8388607
  	  				0 	16777215
		INT 		4 	-2147483648 	2147483647
  	  				0 	4294967295
		BIGINT 		8 	-9223372036854775808 	9223372036854775807
	  				0 	18446744073709551615
	 * Tipos de Datos de Punto Flotante
	 * FLOAT(M,D)
	 * REAL(M,D)
	 * DOUBLE(M,D)
	 * Tipos de Datos String
	 * 
	 * Tipos de Datos de Fechas
	 * DATETIME 	'0000-00-00 00:00:00'
	   DATE 	'0000-00-00'
	   TIMESTAMP 	'0000-00-00 00:00:00'
	   TIME 	'00:00:00'
	   YEAR 	0000
	 * 
	 * **/
	private String mapDataType(String type){
        String resval = "";
        if( type.equals("String") ){
            resval = "VARCHAR";
        }else if(  type.equals("Char")  ){
            resval = "CHAR";
        }else if(  type.equals("Integer")  ){
            resval = "INTEGER";
        }else if(  type.equals("Float")  ){
            resval = "FLOAT";
        }else if( type.equals("Long")  ){
            resval = "BIGINT";
        }else if( type.equals("Double")  ){
            resval = "DOUBLE";
        }else if( type.equals("Document") ){
        	resval = "BLOB";
        }else if( type.equals("Picture") ){
            resval = "BLOB";
        }else if( type.equals("Text") ){
            resval = "TEXT";
        }else if( type.equals("Character") ){
            resval = "";
        }else if( type.equals("Boolean") ){
            resval = "CHAR(1)";
        }else if( type.equals("Date") ){
            resval = "DATE";
        }else if( type.equals("Year") ){
            resval = "YEAR";
        }else if( type.equals("Time") ){
            resval = "TIME";
        }else{
            resval = "";
        }
        return resval;
	}
	
}
