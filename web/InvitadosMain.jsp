<%-- 
    Document   : InvitadosMain
    Created on : 28/02/2019, 09:49:27 PM
    Author     : mauri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Invitados Main</title>
        <style>
           body {background-color: #ECEFF1; font-family: sans-serif; text-align: center; font-size: 10px; color: #245A64;}
           .conexion_status{padding: 20px; background-color: #000000;border-radius: 5px;width: 20%;color:#ffffff;margin-left: 38.5%;margin-right: auto;}
           .boton{background: #AFC5FF;border-radius: 3px;border: none;color: white;padding: 5px;cursor: pointer;margin:5px;}
           .entrada{background-color:white; border-color:#ffffff; border-radius: 3px; border-style: solid; padding: 5px; margin: 5px;} 
        </style>
    </head>
    <body>
        <% Integer x = 2;
                if( request.getParameter("param") == null)
                {
                    x = 2;
                }
                else
                {
                    x = 1;
                }
                if (x == 1) 
                {%>
                   <p style='color: green; font-size: 200%;'>¡Invitado Creado! </p>
              <%} 
                    else
                    { %>
                     <p>  </p>
              <%} %>
        <div class="contenedor">
            <div class="title">
                Control de Invitados
            </div>
            <div class="options">
                <form action="${pageContext.request.contextPath}/SearchInvitado" method="POST">
                    <input type="text" class="entrada" name="param" value="" >
                    <input type="submit" class="boton" value="Buscar Invitado">
                </form>
                <button class="boton" onclick="window.location.href = 'NInvitado.jsp'"> Nuevo Invitado </button>
            </div>
        </div>
        <button class="boton" onclick="window.location.href = 'EventsControl.jsp' "> Regresar a Control </button>
    </body>
</html>
