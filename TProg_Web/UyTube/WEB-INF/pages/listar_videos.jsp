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
		String cast;
		for(DtVideo vp: listaVideosPublicos){ 
		cast = Integer.toString(vp.idVideo);
		
		%>
			
			<%= vp.nombre %> - 
			<%= vp.usuario %>
			
			<br>
					<form action="/ConsultaVideo" method="GET">
				
					
					<input type="hidden" id="1" name="VIDEO_ID" value= "<%= cast %>" >
					
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
			String cast2;
			for (DtVideo v : listaVideosUsuario) { 
				cast2 = Integer.toString(v.idVideo);
			%>			
				
				<%= v.nombre %>
				
				<form action="/ConsultaVideo" method="GET">
				
					<input type="hidden" id="1" name="VIDEO_NOMBRE" value= "<%= cast2 %>" >
					
					<input type="hidden" id="2" name="VIDEO_CANAL" value= "<%= v.usuario %>" >
			
					<button type="submit">Consultar</button>
					
				</form>
				<br>
		<% }
	}
		else %> No has iniciado sesion <%
	%>
	<form action="/index.jsp">
	<button>Volver</button>
</body>