<%-- 
    Document   : index
    Created on : 25/02/2019, 08:48:08 PM
    Author     : Mauricio E Alcala Lopez
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="PackageEvt1.DBActions"%>
<%@page import="java.sql.Connection"%>
<%@page import="PackageEvt1.ConnectDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Events Main</title>
        <style>
            body {background-color: #ECEFF1; font-family: sans-serif; text-align: center; font-size: 10px; color: #245A64;}
            .conexion_status{padding: 20px; background-color: #000000;border-radius: 5px;width: 20%;color:#ffffff;margin-left: 38.5%;margin-right: auto;}
            
        </style>
    </head>
    <body>
        
        <h1>Events Main Content</h1>
        
       <div class="conexion_status"> 
       <%
        DBActions db = new DBActions();
        Connection conn = db.getConnection();
        if(conn==null)
        {
                 out.print("Connection failed");
        }
        %>
       </div>
       <div class="content">
           <div class="c-input">
               <form name="check" action="searchTable.jsp" method="POST">
                   <input type="text" name="id" value="" class="c-input">
                   <input type="submit" name="enviar" value="Buscar Mesa" class="boton">
               </form>
           </div>
           <div class="c-options">
               <button> Nuevo Invitado </button>
               <button> Eliminar Invitado </button>
           </div>
       </div>
       <% 
            ResultSet invitados = db.getInvitados(conn);
            while(invitados.next())
            {%>
            <tr>
                 <td><%out.print(invitados.getInt("invitado_id"));%></td>  
                 <td><%out.print(invitados.getString("nombre"));%></td>
                 <td><%out.print(invitados.getString("mesa"));%></td> 
                 <td><%out.print(invitados.getString("dentro"));%></td>
           </tr>
           <% }
        %>
       
    </body>
</html>
