/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import PackageEvt1.DBActions;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mauri
 */
@WebServlet(urlPatterns = {"/tuMesa"})
public class tuMesa extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           
            DBActions db = new DBActions();
            Connection conn = db.getConnection();
            String invitado = request.getParameter("invitado_id");
            if(conn==null)
            {
                     out.print("Connection failed");
            }
            ResultSet a_invitado = db.foundInvitado(conn, invitado);
            ResultSet a_mesa = db.foudTable(conn, invitado);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Events Tu Mesa </title>" + request.getParameter("invitado_id")); 
            out.println("</head>");
            out.println("<body>");
            out.println("<style>"
                    + " body {background-color: #ECEFF1; font-family: sans-serif; text-align: center; font-size: 10px; color: #245A64;}"
                    + ".conexion_status{padding: 20px; background-color: #000000;border-radius: 5px;width: 20%;color:#ffffff;margin-left: 38.5%;margin-right: auto;} "
                    + ".boton{background: #AFC5FF;border-radius: 3px;border: none;color: white;padding: 5px;cursor: pointer;margin:5px;}"
                    + "</style>"
                    + " Bienvenido " + invitado
                    + "invitado" + a_invitado 
                    + "mesa" + a_mesa);
            out.println("</body>");
            out.println("</html>");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
