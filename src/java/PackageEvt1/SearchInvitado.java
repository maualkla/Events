/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackageEvt1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mauri
 */
@WebServlet(name = "SearchInvitado", urlPatterns = {"/SearchInvitado"})
public class SearchInvitado extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            DBActions db = new DBActions();
            Connection conn = db.getConnection();
            String invitado = request.getParameter("param");
            out.print(invitado);
            if(conn==null)
            {
                     out.print("Connection failed");
            }
             ResultSet a_invitado = db.foundInvitado(conn, invitado);
             String nombre = null, mesa = null;
             boolean dentro = false;
             while(a_invitado.next())
             {
                 nombre = a_invitado.getString("nombre");
                 mesa = a_invitado.getString("mesa");
                 dentro = a_invitado.getBoolean("dentro");
             }
            /* TODO output your page here. You may use following sample code. */
             out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Edit Invitado</title>"); 
            out.println("</head>");
            out.println("<body>");
            out.println("<style>"
                    + " body {background-color: #ECEFF1; font-family: sans-serif; text-align: center; font-size: 10px; color: #245A64;}"
                    + ".conexion_status{padding: 20px; background-color: #000000;border-radius: 5px;width: 20%;color:#ffffff;margin-left: 38.5%;margin-right: auto;} "
                    + ".boton{background: #AFC5FF;border-radius: 3px;border: none;color: white;padding: 5px;cursor: pointer;margin:5px;}"
                    + "</style>");
            out.print(""
                    + "  <div class=\"contenedor\">"
                    + "<div class=\"title\">"
                    + " Modificar Invitado"
                    + "</div>"
                    + "<div class=\"options\">"
                    + "<form action=\"${pageContext.request.contextPath}/UpdateInvitado\" method=\"POST\">"
                     + " <p>ID de Invitado </p>"
                    + "<input class=\"entrada\" type=\"text\" value=\""+invitado+"\" name=\"nombre\" disabled>"
                    + " <p> Nombre </p>"
                    + "<input class=\"entrada\" type=\"text\" value=\""+nombre+"\" name=\"nombre\" required>"
                    + "<p> Mesa </p>"
                    + "<input class=\"entrada\" type=\"text\" value=\""+mesa+"\" name=\"mesa\" required>"
                    + "<p> Dentro </p>"
                    + "<input type=\"checkbox\" value=\""+dentro+"\" id=\"chk\" >"
                    + "<input type=\"submit\" class=\"boton\" value=\"Crear\">"
                    + "</form>"
                    + "</div>"
                    + " </div>"
                    + "<button class=\"boton\" onclick=\"window.location.href = 'InvitadosMain.jsp' \"> Regresar a Control Invitados</button>");     
                    
                    
                    
                    
                    
                
            
       
        
        }
    }
    
     

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SearchInvitado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SearchInvitado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
