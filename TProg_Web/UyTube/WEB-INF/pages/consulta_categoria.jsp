<!doctype html>
<%@ page import = "clases.*" %>
<%@ page import = "datatypes.*" %>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<title>UyTube - Consulta de categoria </title>
</head>
<body>
	<% String categoria = (String) request.getAttribute("CATEGORIA");%>
	<h1>Información de <%= "'" + categoria + "'" %></h1>
	<br>
	<h2> Videos: </h2>
		<% for (String infoVideos : (String[]) request.getAttribute("INFO_VIDEOS")) { %>
			<%= infoVideos %>
			<br>
		<% } %>
		<br>
	<h2> Listas de reproducción: </h2>
		<% for (String infoListas : (String[]) request.getAttribute("INFO_LISTAS")) { %>
			<%= infoListas %>
			<br>
		<% } %>
		<br>
	<form action="/ConsultaDeCategoria" method="GET">
		<button type="submit">Volver</button>
	</form>
</body>
</html>