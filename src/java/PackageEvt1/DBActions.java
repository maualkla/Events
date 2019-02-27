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
public class DBActions {
            public Connection getConnection(){
               try {
                   Class.forName("com.mysql.jdbc.Driver");
                   Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost/event", "root", "");
                   return conn;
               } catch (ClassNotFoundException ex) {
                   Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
                   return null;
               } catch (SQLException ex) {
                   Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
                   return null;
               }
            }
            
            // Traemos todos los invitados
            public ResultSet getInvitados(Connection conn){
                try {
                    Statement st = conn.createStatement();
                    // execute the query, and get a java resultset
                    ResultSet rs = st.executeQuery("Select * from invitado");

                    return rs;
                } catch (SQLException ex) {
                    Logger.getLogger(DBActions.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                }
            }
            
            //  Creamos un nuevo invitado
            public boolean insertInvitados(Connection conn,String nombre, String mesa, boolean dentro){
                boolean success = false;
                try {
                    String query = " insert into invitado  (nombre, mesa, dentro)"
                            + " values (?, ?, ?)";

                    // create the mysql insert preparedstatement
                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setString(1, nombre);
                    preparedStmt.setString (2, mesa);
                    preparedStmt.setBoolean (3, dentro);

                    // execute the preparedstatement
                    preparedStmt.execute();
                    success = true;
                    conn.close();
                } catch (SQLException ex) {
                    success = false;
                    Logger.getLogger(DBActions.class.getName()).log(Level.SEVERE, null, ex);
                }
                return success;
             }
            
            // Borrando invitados
            public boolean removeInvitados(Connection conn, String nombre){
                boolean success = false;
                try {    

                    String query = "delete from invitados where nombre = ?";
                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setString(1, nombre);
                    // execute the preparedstatement
                    preparedStmt.execute();
                   success = true;
                   conn.close();
                } catch (SQLException ex) {
                    success = false;
                    Logger.getLogger(DBActions.class.getName()).log(Level.SEVERE, null, ex);
                }
                 return success;
            }
            
            // Actualizando Invitados
            public boolean updateInvitados(Connection conn, String nombre, String mesa, boolean dentro){
                boolean success = false;
                try {    
                    String query = "update students set nombre = ?, mesa = ?, dentro = ? where nombre = ?";

                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setString(1, nombre);
                    preparedStmt.setString(2, mesa);
                    preparedStmt.setBoolean(3, dentro);
                    preparedStmt.setString(1, nombre);
                    // execute the preparedstatement
                    preparedStmt.execute();
                   success = true;
                   conn.close();
                } catch (SQLException ex) {
                    success = false;
                    Logger.getLogger(DBActions.class.getName()).log(Level.SEVERE, null, ex);
                }
                 return success;
            }
            
            public ResultSet foudTable(Connection conn, String mesa)
            {
                try
                {
                    Statement st = conn.createStatement();
                    ResultSet  mesas ;
                    String query =  "Select * from mesas where nombre = '" + mesa + "'  ";
                    mesas = st.executeQuery(query);
                     return mesas;
                }
                catch(SQLException ex)
                {
                    Logger.getLogger(DBActions.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                }
            }
}
