<%@page import="datatypes.DtUsuario"%>
<%@page import="datatypes.DtVideo"%>
<%@page import="java.util.List"%>
<!doctype html>
<html lang="en">
<head>
	<%@ include file="/WEB-INF/extras/head.jsp" %>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<title>UyTube - Lista de Videos</title>
</head>
<body>

	<div class="page">
		<%@ include file="/WEB-INF/extras/header.jsp" %>
		<jsp:include page="/WEB-INF/extras/sidebar.jsp"></jsp:include>
		<div class="contenido">
			<h1>Videos Publicos:</h1>
			<br>
			<%
				List<DtVideo> listaVideosPublicos = (List<DtVideo>) request.getAttribute("VIDEOS_PUBLICOS");
				String cast;
				for(DtVideo vp: listaVideosPublicos){ 
				cast = Integer.toString(vp.idVideo);
				
				%>
					
					<%= vp.nombre %> - 
					<%= vp.usuario %>
					
					
							<form action="/ConsultaVideo" method="GET">
							
							<input type="hidden" id="1" name="VIDEO_ID" value= "<%= cast %>" >
					
							<button type="submit">Consultar</button>
							
						</form>
						<br>
				<%}
			%>
			<br>
				<%
				DtUsuario d = (DtUsuario)request.getSession().getAttribute("USUARIO_LOGEADO");
				if(d != null){ %>
				<h1>Videos del usuario:</h1>
				 <%
					List<DtVideo> listaVideosUsuario = (List<DtVideo>) request.getAttribute("VIDEOS_USUARIO");
					String cast2;
					for (DtVideo v : listaVideosUsuario) { 
						cast2 = Integer.toString(v.idVideo);
					%>			
						
						<%= v.nombre %>
						
						<form action="/ConsultaVideo" method="GET">
						
							<input type="hidden" id="1" name="VIDEO_ID" value= "<%= cast2 %>" >
					
							<button type="submit">Consultar</button>
							
						</form>
						<br>
				<% }
			}
				
			%>
			<form action="/index.jsp">
			<button>Volver</button>
		</div>
	</div>
<%@ include file="/WEB-INF/extras/script.jsp" %>
</body>
