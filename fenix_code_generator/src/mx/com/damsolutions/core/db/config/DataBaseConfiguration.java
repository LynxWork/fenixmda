package mx.com.damsolutions.core.db.config;

import  mx.com.damsolutions.core.db.connection.ConnectionFactory;

public class DataBaseConfiguration {

	public static final String DATA_BASE_NAME = ConnectionFactory.MYSQL_DATABASE_NAME;
	//public static final String DATA_BASE_CODE_GENERATOR = DDLCodeGeneratorFactory.MYSQL_DATA_BASE_CODE_GENERATOR;

	//Configuraciones unicas para Bases de Datos MySql
	public static final String STORAGE_ENGINE = "innodb";

}
