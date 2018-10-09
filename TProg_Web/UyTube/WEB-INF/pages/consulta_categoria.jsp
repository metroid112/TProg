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
	<% String[] listas = (String[]) request.getAttribute("CATEGORIAS");
		if (listas.length == 0) { %>
			<h1>No hay categorias en el sistema.</h1>
			<br>
	<% } else { %>	
		<h1>Categorias</h1>
		<br>
			<% for (String categorias : (String[]) request.getAttribute("CATEGORIAS")) { %>
				<form action="/ListarCategorias" method="GET">
					<input type hidden name="CATEGORIA" value="<%= categorias %>">
					<button type="submit"><%= categorias %></button>
				</form>
			<% } %>
		<br>
	<% } %>
	<form action="/Inicio" method="GET">
		<button type="submit">Volver</button>
	</form>
</body>
</html>