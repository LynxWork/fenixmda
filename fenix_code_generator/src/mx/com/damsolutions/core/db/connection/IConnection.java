/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.damsolutions.core.db.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author kmejia
 */
public interface IConnection {

 public Connection getConnection();

 public void closeConnection(Connection connection,Statement statement,ResultSet resultSet);

}
