<%@page import="datatypes.DtUsuario"%>
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

	<h1>Videos del usuario:</h1>
	<br>
		<% 
		DtUsuario d = (DtUsuario)request.getSession().getAttribute("USUARIO_LOGEADO");
		if(d != null){
		for (String v : (String[]) request.getAttribute("VIDEOS_USUARIO")) { %>
		<%= v %> 
		<br>
	<% }
	}
	%>
	<form action="/index.jsp">
	<button>Volver</button>
</body>
</