/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlite_in_action;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author velenteenko
 */
public class DBUtils {

    private static Connection con;

    
    public static void openConnection(String connection_path)
    {
        try
        {
            // instance the driver from SQLiteJDBC_Connector
            Driver driver = (Driver) Class.forName("org.sqlite.JDBC").newInstance();
            //determinate URL variable for a SQLiteJDBC_Connector
            String url="jdbc:sqlite:"+connection_path;
            
            //trying connection
            if (con==null) {
                DriverManager.getConnection(url);
            }
           
        }
        catch(SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex)
        {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
}
