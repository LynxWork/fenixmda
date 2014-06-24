package mx.com.damsolutions.core.db.metadata;

import mx.com.damsolutions.core.db.config.DataBaseConfiguration;
import mx.com.damsolutions.core.db.connection.ConnectionFactory;
import mx.com.damsolutions.core.db.connection.IConnection;
import mx.com.damsolutions.fenix.code.generator.classes.impl.Property;





import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DBMetadataService {

	private static final Log log = LogFactory.getLog(DBMetadataService.class);
	private Connection cnn;
	private Statement s;	
	
	/*
	 * Prueba de la generacion de Codigo.
	 * */
	public static void main(String[] argv){
		log.debug("Inicia el la construccion del codigo");
		DBMetadataService mds = new DBMetadataService();
		ArrayList<Property> propertyList = mds.getRowNameListFromTable("PRODUCT");
		
	}


	public ArrayList<Property> getRowNameListFromTable(String tableName){
	   	ArrayList<Property> resval = new ArrayList<Property>(); 
    	log.debug("get Connection Factory");
    	ConnectionFactory cnnFactory = new ConnectionFactory();
    	IConnection conection = cnnFactory.getConnection(DataBaseConfiguration.DATA_BASE_NAME);
    	cnn = conection.getConnection();
    	
    	Statement stmt=null;
    	ResultSet rs=null;
    	ResultSetMetaData md=null;
    	
		try {
			stmt = cnn.createStatement();
	    	rs = stmt.executeQuery("SELECT * FROM " + tableName);
	    	md = rs.getMetaData();
	    	System.out.println("\n Fetching Query.............");
	    	for (int i = 1; i <= md.getColumnCount(); i++){
	    		System.out.print(md.getColumnLabel(i) + " ");
	    		//resval.add(md);
	    	}

/*	    	    
	    	while (rs.next()) {
	    		for (int i = 1; i <= md.getColumnCount(); i++)
	    			System.out.print(rs.getString(i) + " ");
	    		System.out.println();
	    	}
*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			conection.closeConnection(cnn, stmt, rs);
		}     
		return resval;
	}
	
	
	
}
