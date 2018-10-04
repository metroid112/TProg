<!doctype html>
<%@ page import = "clases.*" %>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<title>UyTube - Alta Lista</title>
</head>
<body>
	<h1> <b>Crear lista de reproducción particular </b> </h1>
	<br>
	<% if (request.getAttribute("ERROR") != null) { %>
	<h2 style= "color:red;">
	<%= request.getAttribute("ERROR") %> 
	</h2>
	<% } %>
	<form action="/ListaServlet" method="POST" id="formListaServlet">
		Nombre de lista particular: <input type="text" name="nombreLista" required>*
		<br>
		Visibilidad: <input type="radio" name="visibilidad" checked>Privado  <input type="radio" name="visibilidad">Público
		<br>
		<button type="submit">Aceptar</button>
		<button form="formDummyServlet" type="submit">Cancelar</button>
	</form>
	<form action="/Inicio" method="GET" id ="formDummyServlet">
	</form>
</body>
</html>