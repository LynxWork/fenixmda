package mx.com.damsolutions.core.db.manager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import mx.com.damsolutions.core.db.config.DataBaseConfiguration;
import mx.com.damsolutions.core.db.connection.ConnectionFactory;
import mx.com.damsolutions.core.db.connection.IConnection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DDLManager {

	private static final Log log = LogFactory.getLog(DDLManager.class);
	private Connection cnn;
	private Statement s;
	
	
	/**
	 * Funcion que se encarga de ejecutar sentencias para la creacion de objetos en base de datos.
	 * @throws SQLException 
	 * **/
	public boolean executeDDL(String strCodeDDL) throws SQLException{
	   	boolean resval = false;
		strCodeDDL = strCodeDDL.toUpperCase(); 
    	log.debug("get Connection Factory");
    	ConnectionFactory cnnFactory = new ConnectionFactory();
    	IConnection conection = cnnFactory.getConnection(DataBaseConfiguration.DATA_BASE_NAME);
    	cnn = conection.getConnection();
		log.debug("Excecute Query:"+strCodeDDL);
		s = cnn.createStatement();
		int iResval = s.executeUpdate(strCodeDDL);
		if(iResval>0){
			resval=true;
		}
		return resval;
	}


}