<%-- 
    Document   : NInvitado
    Created on : 28/02/2019, 10:05:15 PM
    Author     : mauri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Invitado</title>
        <style>
           body {background-color: #ECEFF1; font-family: sans-serif; text-align: center; font-size: 10px; color: #245A64;}
           .conexion_status{padding: 20px; background-color: #000000;border-radius: 5px;width: 20%;color:#ffffff;margin-left: 38.5%;margin-right: auto;}
           .boton{background: #AFC5FF;border-radius: 3px;border: none;color: white;padding: 5px;cursor: pointer;margin:5px;}
           .entrada{background-color:white; border-color:#ffffff; border-radius: 3px; border-style: solid; padding: 5px; margin: 5px;}
        </style>
    </head>
    <body>
        <div class="contenedor">
            <div class="title">
                Nuevo Invitado
            </div>
            <div class="options">
                <form action="${pageContext.request.contextPath}/CreateInvitado" method="POST">
                    <p> Nombre </p>
                    <input class="entrada" type="text" value="" name="nombre" required>
                    <p> Mesa </p>
                    <input class="entrada" type="text" value="" name="mesa" required>
                    <p> Dentro </p>
                    <input type="checkbox" value="0" id="chk" >
                    <input type="submit" class="boton" value="Crear">
                </form>
            </div>
        </div>
        <button class="boton" onclick="window.location.href = 'EventsControl' "> Salir a Inicio </button>
    </body>
</html>
