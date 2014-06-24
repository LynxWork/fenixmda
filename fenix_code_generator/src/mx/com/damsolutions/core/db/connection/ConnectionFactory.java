package mx.com.damsolutions.core.db.connection;

/**
 *
 * @author Ing. Juan Arturo Vargas Torres.
 */
public class ConnectionFactory {

    private IConnection databaseConnection;
    
    public static final String MYSQL_DATABASE_NAME = "mySqlDataBase";
    public static final String MYSQL_DATABASE_POOLING_NAME = "mySqlDataBasePooling";
    public static final String ORACLE_DATABASE_NAME  = "OracleDataBase";
    public static final String DB2_DATABASE_NAME  = "Db2DataBase";
    public static final String DERBY_DATABASE_NAME  = "DerbyDataBase";
    
    public static final String CONFIGURED_DATABASE_NAME  = MYSQL_DATABASE_NAME;

    public IConnection getConnection(String databaseName){
    	
        if(databaseName.equals(MYSQL_DATABASE_NAME)){
        	databaseConnection = new MySqlConnection();
        }else if(databaseName.equals(ORACLE_DATABASE_NAME)){
        	//Clase por Implementar
        }else if(databaseName.equals(DB2_DATABASE_NAME)){
//        	Clase por Implementar
        }else if(databaseName.equals(MYSQL_DATABASE_POOLING_NAME)){
//        	Clase por Implementar
        }else if(databaseName.equals(DERBY_DATABASE_NAME)){
//        	Clase por Implementar
        }
        return databaseConnection;
    }

}
