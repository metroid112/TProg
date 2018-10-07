<!doctype html>
<%@ page import = "clases.*" %>
<%@ page import = "datatypes.*" %>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<title>UyTube - Lista de categorias </title>
</head>
<body>
	<form action="/Inicio" method="GET">
		<% String[] listas = (String[]) request.getAttribute("CATEGORIAS");
			if (listas.length == 0) { %>
				<h1>No hay categorias en el sistema.</h1>
				<br>
		<% } else { %>	
			<h1>Categorias</h1>
			<br>
				<% for (String categorias : (String[]) request.getAttribute("CATEGORIAS")) { %>
					<%= categorias %> 
					<br>
				<% } %>
			<br>
		<% } %>
		<button type="submit">Volver</button>
	</form>
</body>
</html>