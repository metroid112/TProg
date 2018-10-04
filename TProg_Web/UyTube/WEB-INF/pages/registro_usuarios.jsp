<%@ page import = "datatypes.*" %>
<%@ page import = "servlet.*" %>
<html>
	<head>
		<title>Registro de usuarios</title>
	</head>
	<body>
		<h1>Registro de usuarios</h1>
		<br>
		<%= new DtCalificacion(true, "usu", "vid").getLikeParsed() %> <%-- Arreglar --%>
		<br>
		<form action="/UsuarioServlet" method="POST">
			<input value="Submit" type="button" onclick="submit()" />	
		</form>
	</body>
</html>