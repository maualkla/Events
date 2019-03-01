<%-- 
    Document   : EventsAdmin
    Created on : 28/02/2019, 05:50:48 PM
    Author     : Mauricio E Alcala Lopez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Events Admin</title>
    </head>
    <body>
         <style>
            body {background-color: #ECEFF1; font-family: sans-serif; text-align: center; font-size: 10px; color: #245A64;}
            .conexion_status{padding: 20px; background-color: #000000;border-radius: 5px;width: 20%;color:#ffffff;margin-left: 38.5%;margin-right: auto;}
            .boton{background: #AFC5FF;border-radius: 3px;border: none;color: white;padding: 5px;cursor: pointer;margin:5px;}
            .entrada{background-color:white; border-color:#ffffff; border-radius: 3px; border-style: solid; padding: 5px; margin: 5px;}
            
        </style>
        <div class="container">
            <div class="c-title">
                Primero accede por favor
            </div>
            <div class="c-content">
                <form action="${pageContext.request.contextPath}/Login" method="POST">
                    <p> USER NAME </p>
                    <input type="text"class="entrada" name="user" value="">
                    <p> PASSWORD </p>
                    <input type="password" class="entrada" name="pass" value="">
                    <input type="submit" value="Log in" class="boton">
                </form>
                    <button class="boton" onclick="window.location.href = '/Events'"> Inicio </button>
            </div>
        </div>
    </body>
</html>
