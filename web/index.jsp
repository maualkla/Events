<%-- 
    Document   : index
    Created on : 25/02/2019, 08:48:08 PM
    Author     : Mauricio E Alcala Lopez
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="PackageEvt1.DBActions"%>
<%@page import="java.sql.Connection"%>
<%@page import="PackageEvt1.ConnectDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eventos</title>
        <link rel=StyleSheet href="eventsStyleSheet.css" type="text/css" media=screen>
    </head>
    <body>
        <video autoplay="autoplay" loop="loop" id="video_background" preload="auto" muted/>
            <source src="Nightclub.mp4" type="video/mp4" />
        </video>
        <div class="header">
            <a>EVENTOS</a>
            <button class="boton" onclick="window.location.href = '${pageContext.request.contextPath}/EventsAdmin.jsp';"> Administrador </button>
        </div>
       <div class="container">
           <div class="c-input">
               <form name="check" action="${pageContext.request.contextPath}/tuMesa" method="POST">
                   <p> NUMERO DE INVITADO: </p>
                   <input type="text"class="entrada"  name="invitado_id" value="" class="c-input" id="invitado_form">
                   <input type="submit" name="enviar" value="Buscar Mesa" class="boton" id="boton_mesa">
               </form>
           </div>
       </div>
     
       
    </body>
</html>
