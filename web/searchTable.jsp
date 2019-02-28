<%-- 
    Document   : searchTable
    Created on : 26/02/2019, 10:13:19 PM
    Author     : mauri
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="PackageEvt1.DBActions"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Events - Tu Mesa</title>
        <style>
           body {background-color: #ECEFF1; font-family: sans-serif; text-align: center; font-size: 10px; color: #245A64;}
           .conexion_status{padding: 20px; background-color: #000000;border-radius: 5px;width: 20%;color:#ffffff;margin-left: 38.5%;margin-right: auto;}
           .boton{background: #AFC5FF;border-radius: 3px;border: none;color: white;padding: 5px;cursor: pointer;margin:5px;}
            
        </style>
    </head>
    <body>
        <%  String parameter = request.getParameter("id"); %>
        <%  DBActions db = new DBActions(); %>
        <%  Connection conn = db.getConnection(); %>
        <%   if(conn==null) { out.print("Connection failed");  } %>
        <% ResultSet invitado = db.foundInvitado(conn, parameter); %>
        <% ResultSet table = db.foudTable(conn, parameter); %>
        <% out.print(table); %>
        <% out.print(invitado); %>
                  <div class="contenedor">
                      <div class="title">
                          Bienvenido <%= parameter %>
                      </div>
                      <div class="options">
                          Content
                      </div>
                  </div>
                  <button class="boton" onclick="window.location.href = '/Events' "> Regresar </button>
     </body>
</html>
