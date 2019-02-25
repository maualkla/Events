/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackageEvt1;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author mauri
 */
public class ConnectDB 
{
            public static Connection conecta() throws SQLException, ClassNotFoundException
            {
                Connection conecta = null;
                Class.forName("com.mysql.jdbc.Driver");
                String servidor = "127.0.0.1";
                String usuario = "root";
                String contra = "";
                conecta =  (Connection)DriverManager.getConnection(servidor, usuario, contra);
                return conecta;
            }
}
