<%-- 
    Document   : EventsControl
    Created on : 28/02/2019, 08:41:27 PM
    Author     : mauri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Events Control</title>
        <style>
           body {background-color: #ECEFF1; font-family: sans-serif; text-align: center; font-size: 10px; color: #245A64;}
           .conexion_status{padding: 20px; background-color: #000000;border-radius: 5px;width: 20%;color:#ffffff;margin-left: 38.5%;margin-right: auto;}
           .boton{background: #AFC5FF;border-radius: 3px;border: none;color: white;padding: 5px;cursor: pointer;margin:5px;}
            
        </style>
    </head>
    <body>
        <div class="contenedor">
            <div class="title">
                Events Control
            </div>
            <div class="options">
                <button class="boton" onclick=""> Invitados </button>
                <button class="boton" onclick=""> Mesas </button>
            </div>
        </div>
        <button class="boton" onclick="window.location.href = '/Events' "> Salir a Inicio </button>
    </body>
</html>


 