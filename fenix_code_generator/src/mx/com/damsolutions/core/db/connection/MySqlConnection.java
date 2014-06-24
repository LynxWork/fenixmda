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
 * @author Administrator
 */
public class MySqlConnection implements IConnection{

    String userName = "fenixmda";
    String password = "welcome1";
    String url = "jdbc:mysql://localhost/fenixmda";
    String driver = "com.mysql.jdbc.Driver";


    private Connection cnn;

    public Connection getConnection() {
        try {
            Class.forName(driver).newInstance();
            cnn = DriverManager.getConnection(url, userName, password);
            System.out.println("Database connection established;" + cnn.getMetaData().getDatabaseProductName());
        } catch (Exception e) {
            System.err.println("Cannot connect to database server" + e);
        }
        return cnn;
    }

    public void closeConnection(Connection connection,Statement statement,ResultSet resultSet) {
        if (cnn != null) {
            try {
                cnn.close();
                System.out.println("Database connection terminated");
            } catch (Exception e) {
                /* ignore close errors */
            }
        }
    }
    
}
