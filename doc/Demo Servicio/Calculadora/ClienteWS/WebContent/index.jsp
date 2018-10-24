<%-- 
    Document   : index
    Created on : Oct 16, 2012, 12:42:43 PM
    Author     : tprog051
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Consumir un servicio</h1>
        <form style="margin: -8.02px; width: 10px; height: auto;" action="InfoServlet" ACTION="POST">
            <label>Ingresar:</label>
            <input id="nroi" type="text" name="nroi"/>
            <label>Ingresar:</label>
            <input id="nroj" type="text" name="nroj"/>
            <%session.setAttribute("procedencia","index");%>
            <input type="submit" value="suma" name="operador" />
        </form>
    </body>
</html>
