<%@page import="datatypes.DtUsuario"%>
<%@page import="datatypes.DtVideo"%>
<%@page import="java.util.LinkedList"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<title>UyTube - Lista de Videos</title>
</head>
<body>
	<h1>Videos Publicos:</h1>
	<br>
	aca irian todos los videos publicos
	<h1>Videos del usuario:</h1>
	<br>
		<% 
		DtUsuario d = (DtUsuario)request.getSession().getAttribute("USUARIO_LOGEADO");
		if(d != null){
			LinkedList<DtVideo> lista = (LinkedList<DtVideo>) request.getAttribute("VIDEOS_USUARIO");
			for (DtVideo v : lista) { %>
			
				<%= v.nombre %> 
				<form action="/ConsultaVideo" method="POST" id="1">
				
				<button type="submit">Consultar</button></form>
				<br>
		<% }
	}
	%>
	<form action="/index.jsp">
	<button>Volver</button>
</body>
</