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
	<%
		LinkedList<DtVideo> listaVideosPublicos = (LinkedList<DtVideo>) request.getAttribute("VIDEOS_PUBLICOS");
		
		for(DtVideo vp: listaVideosPublicos){ %>
			<%= vp.nombre %> - 
			<%= vp.usuario %>
			<br>
					<form action="/ConsultaVideo" method="GET">
				
					<input type="hidden" id="1" name="VIDEO_NOMBRE" value= "<%= vp.nombre %>" >
					
					<input type="hidden" id="2" name="VIDEO_CANAL" value= "<%= vp.usuario %>" >
			
					<button type="submit">Consultar</button>
					
				</form>
				<br>
		<%}
	%>
	
	
	
	
		<h1>Videos del usuario:</h1>
	<br>
		<%
		DtUsuario d = (DtUsuario)request.getSession().getAttribute("USUARIO_LOGEADO");
		if(d != null){
			LinkedList<DtVideo> listaVideosUsuario = (LinkedList<DtVideo>) request.getAttribute("VIDEOS_USUARIO");
			for (DtVideo v : listaVideosUsuario) { %>
			
				<%= v.nombre %>
				
				<form action="/ConsultaVideo" method="GET">
				
					<input type="hidden" id="1" name="VIDEO_NOMBRE" value= "<%= v.nombre %>" >
					
					<input type="hidden" id="2" name="VIDEO_CANAL" value= "<%= v.usuario %>" >
			
					<button type="submit">Consultar</button>
					
				</form>
				<br>
		<% }
	}
	%>
	<form action="/index.jsp">
	<button>Volver</button>
</body>
</