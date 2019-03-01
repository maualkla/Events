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
        <% Integer x = 10;
                if( request.getParameter("createinvitado") == null)
                {
                    if(request.getParameter("error_createinvitado")== null)
                    {
                        if(request.getParameter("updateinvitado") == null)
                         {
                             if(request.getParameter("error_updateinvitado") == null)
                             {
                                 x = 10;
                             }
                             else
                             {
                                 x = 4;
                             }
                         }
                        else
                        {
                            x = 3;
                        }
                       
                    }
                    else
                    {
                          x = 2;
                    }
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
                    <% if (x == 2) { %> 
                     <p style="color: red; font-size: 200%;"> ¡No se creo el invitado!  </p>
                     <%} else { 
                              if(x == 3) {%>
                              <p style='color: green; font-size: 200%;'>¡Invitado Actualizado! </p>
                     <%} else { 
                              if(x == 4) {%>
                              <p style="color: red; font-size: 200%;"> ¡No se actualizo el invitado!  </p>
                              <% } } } } %>
              <%%>
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
