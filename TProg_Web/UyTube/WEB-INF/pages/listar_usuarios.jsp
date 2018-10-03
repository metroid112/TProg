<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<title>UyTube - Lista de Usuarios</title>
</head>
<body>
	<h1>Usuarios Registrados:</h1>
	<br>
	<% for (String u : (String[]) request.getAttribute("USUARIOS_REGISTRADOS")) { %>
		<%= u %> <br>
	<% } %>
</body>
</html>