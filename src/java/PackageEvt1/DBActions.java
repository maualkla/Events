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
            public boolean insertStudent(Connection conn,String nombre, String mesa, boolean dentro){
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
            
            public boolean removeStudent(Connection conn, Integer id){
                boolean success = false;
                try {    

                    String query = "delete from students where idStudents = ?";
                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setInt(1, id);
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
            public boolean updateStudent(Connection conn, Integer id, String name, String address){
                boolean success = false;
                try {    
                    String query = "update students set name = ?, address = ? where idStudents = ?";

                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setString(1, name);
                    preparedStmt.setString(2, address);
                    preparedStmt.setInt(3, id);
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
}
