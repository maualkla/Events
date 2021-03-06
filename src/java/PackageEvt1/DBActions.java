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
            public boolean removeInvitados(Connection conn, String identificador){
                boolean success = false;
                try {    

                    String query = "delete from invitados where invitado_id = "+identificador+"";
                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                    // execute the preparedstatement
                   success =  preparedStmt.execute();
                   conn.close();
                } catch (SQLException ex) {
                    success = false;
                    Logger.getLogger(DBActions.class.getName()).log(Level.SEVERE, null, ex);
                }
                 return success;
            }
            
            // Actualizando Invitados
            public boolean updateInvitados(Connection conn, String invitado_id, String nombre, String mesa ){
                boolean success = false;
                try {    
                    String query = "UPDATE invitados SET nombre = '"+nombre+"', mesa = '"+mesa+"' WHERE invitado_id = ?";
                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setInt(1, Integer.parseInt(invitado_id));
                   success =  preparedStmt.execute();
                } catch (SQLException ex) {
                    success = false;
                    Logger.getLogger(DBActions.class.getName()).log(Level.SEVERE, null, ex);
                }
                 return success;
            }
            
            // Regresa la informacion del Invitado
            public ResultSet foundInvitado(Connection conn, String id)
            {
                try
                {
                    Statement st = conn.createStatement();
                    ResultSet info;
                    String query = " select * from invitado where invitado_id = " + id + " OR nombre LIKE '%" + id + "%'";
                    info = st.executeQuery(query);
                    return info;
                }
                 catch(SQLException ex)
                {
                    Logger.getLogger(DBActions.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                }
                        
            }
            
            // Regresa la informacion de la mesa 
            public ResultSet foudTable(Connection conn, String id)
            {
                try
                {
                    String mesa = "";
                    Statement rs = conn.createStatement();
                    ResultSet info;
                    String query = " select * from invitado where invitado_id = " + id + " OR nombre LIKE '%" + id + "%'";
                    info = rs.executeQuery(query);
                    while (info.next())
                    {
                        mesa = info.getString("mesa");
                    }
                    Statement st = conn.createStatement();
                    ResultSet  mesas ;
                    String query2 =  "Select * from mesas where nombre = '" + mesa + "'  ";
                    mesas = st.executeQuery(query2);
                    return mesas;
                }
                catch(SQLException ex)
                {
                    Logger.getLogger(DBActions.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                }
            }
            // Regresa true or false cuando se hace el login
            public boolean loginUser(Connection conn, String pass, String user)
            {
                try
                {
                    String name = null;
                    boolean access = false;
                    Statement rs = conn.createStatement();
                    ResultSet info;
                    String query = " select * from admin where user ='" + user + "' AND pass = '" + pass + "'";
                    info = rs.executeQuery(query);
                    while (info.next())
                    {
                        name = info.getString("nombre");
                    }
                    if (name != null)
                    {
                        access = true;
                    }
                    return access;
                }
                catch(SQLException ex)
                {
                    Logger.getLogger(DBActions.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
            }

    public ResultSet foundInvitado(Connection conn, ResultSet invitado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
