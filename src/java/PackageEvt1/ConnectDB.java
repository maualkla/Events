/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackageEvt1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author mauri
 */
public class ConnectDB 
{
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/event", "root", "");
            return conn;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
