<%-- 
    Document   : searchTable
    Created on : 26/02/2019, 10:13:19 PM
    Author     : mauri
--%>

<%@page import="com.sun.jndi.toolkit.url.Uri"%>
<%@page import="com.sun.jndi.toolkit.url.Uri"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Events - Tu Mesa</title>
        <style>
            body {background-color: #ECEFF1; font-family: sans-serif; text-align: center; font-size: 10px; color: #245A64;}
            .conexion_status{padding: 20px; background-color: #000000;border-radius: 5px;width: 20%;color:#ffffff;margin-left: 38.5%;margin-right: auto;}
            
        </style>
    </head>
    <body>
        <% 
           String parameter = request.getParameter("id");
           
           
          %>
        <h1>TU MESA ESTA AQUÍ <%= parameter %></h1>
    </body>
</html>
