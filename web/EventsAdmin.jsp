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
        <!--link rel=StyleSheet href="eventsStyleSheet.css" type="text/css" media=screen-->
    </head>
    <body>
         <style>
            body {background-color: #ECEFF1; font-family: sans-serif; text-align: center; font-size: 10px; color: #245A64;}
            .conexion_status{padding: 20px; background-color: #000000;border-radius: 5px;width: 20%;color:#ffffff;margin-left: 38.5%;margin-right: auto;}
            .boton{background: #AFC5FF;border-radius: 3px;border: none;color: white;padding: 5px;cursor: pointer;margin:5px;}
            .entrada{background-color:white; border-color:#ffffff; border-radius: 3px; border-style: solid; padding: 5px; margin: 5px;}
            .login-content{border-color: white;border-radius: 3px;border-style: solid;width: 30%; margin-left: 35%;}
            .login-form{}
            .login-elements{}
            .alert-good{color: green;font-size: 200%;background-color: white;opacity: .7;padding:5px;border:none;border-radius:3px;}
            .alert-bad{cursor:default;color: red;font-size: 200%;background-color: white;opacity: .6;padding:5px;border:none;border-radius:3px;}
            
        </style>
        <div class="container">
            <div class="c-title">
                <% Integer x = 2;
                if( request.getParameter("error") == null)
                {
                    x = 2;
                }
                else
                {
                    x = 1;
                }
                if (x == 1) 
                {%>
                   <p class='alert-bad'> Error, usuario o contraseña no validos </p>
              <%} 
                    else
                    { %>
                     <p class=''> Primero accede por favor </p>
              <%} %>
                
            </div>
            <div class="login-content">
                <form id=login-form' action="${pageContext.request.contextPath}/Login" method="POST">
                    <div class='login-elements'>
                        <p> USER NAME </p>
                        <input type="text"class="entrada" name="user" value="">
                        <p> PASSWORD </p>
                        <input type="password" class="entrada" name="pass" value=""><br>
                        <input type="submit" value="Log in" class="boton">
                    </div>
                </form>
                    <button class="boton" onclick="window.location.href = '/Events'"> Regresar a Inicio </button>
            </div>
        </div>
    </body>
</html>
