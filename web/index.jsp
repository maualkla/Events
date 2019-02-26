<%-- 
    Document   : index
    Created on : 25/02/2019, 08:48:08 PM
    Author     : Mauricio E Alcala Lopez
--%>

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
        </style>
    </head>
    <body>
        
        <h1>Events Main Content</h1>
        
        <%
        ConnectDB db = new ConnectDB();
        Connection conn = db.getConnection();
        if(conn!=null)
        {
                 out.print("Connection successfully");
        }
        else
        {
                 out.print("Connection failed");
        }
        %>
    </body>
</html>
