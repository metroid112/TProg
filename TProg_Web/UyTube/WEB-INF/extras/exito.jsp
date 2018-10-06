<!doctype html>
<%@ page import = "clases.*" %>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta http-equiv="refresh" content="3;URL=http://localhost:10035/index.jsp">
</head>
<title>UyTube</title>
</head>
<body>
	<h1><b><% if (request.getAttribute("EXITO") != null) { %>
				<%= request.getAttribute("EXITO") %> 
			<% } %>
	</b></h1>
	<br>
	<h2> <b> Se redirigirá al index en 3 segundos...</b></h2>
</body>
</html>