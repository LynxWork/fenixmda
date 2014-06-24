/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.damsolutions.core.db.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Juan Arturo Vargas Torres
 */
public class DerbyConnection implements IConnection{
    //String driver = "org.apache.derby.jdbc.EmbeddedDriver";

    String userName = "semantic";
    String password = "welcome1";
    String dbName="/semantic/APP;create=true";
    //String url = "jdbc:derby://localhost:1527/semantic";
    String url = "jdbc:derby:"+dbName;
    String driver = "org.apache.derby.jdbc.EmbeddedDriver";

    private Connection cnn;

    public Connection getConnection() {
        try {

            Class.forName(driver).newInstance();
            cnn = DriverManager.getConnection(url, userName, password);
            System.out.println("Database connection established;" + cnn.getMetaData().getDatabaseProductName());
        } catch (Exception e) {
            System.err.println("Cannot connect to database server " + e);
        }
        return cnn;
    }

    public void closeConnection(Connection connection,Statement statement,ResultSet resultSet) {
        if (connection != null) {
            try {
            	connection.close();
                System.out.println("Database connection terminated");
            } catch (Exception e) {
                /* ignore close errors */
            }
        }
    }


}
