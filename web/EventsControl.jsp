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
           .entrada{background-color:white; border-color:#ffffff; border-radius: 3px; border-style: solid; padding: 5px; margin: 5px;} 
           .alert-good{color: green;font-size: 200%;background-color: white;opacity: .7;padding:5px;border:none;border-radius:3px;}
           .alert-bad{cursor:default;color: red;font-size: 200%;background-color: white;opacity: .6;padding:5px;border:none;border-radius:3px;}
           .contenedor{border-color: white;border-radius: 3px;border-style: solid;width: 40%; margin-left: 30%;}
           .title{font-size: 250%;padding: 20px;}
           .options{padding: 20px;}
        </style>
    </head>
    <body>
        <div class="contenedor">
            <div class="title">
                Events Control
            </div>
            <div class="options">
                <button class="boton" onclick="window.location.href = 'InvitadosMain.jsp'"> Invitados </button>
                <button class="boton" onclick=""> Mesas </button>
            </div>
        </div>
        <button class="boton" onclick="window.location.href = '/Events' "> Salir a Inicio </button>
    </body>
</html>


 