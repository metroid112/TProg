<%@page import="datatypes.DtUsuario"%>
<%@page import="datatypes.DtVideo"%>
<%@page import="java.util.List"%>
<!doctype html>
<html lang="en">
<head>
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
			<p>Videos Publicos:</p>
			<div class="highlights">
			<%
				List<DtVideo> listaVideosPublicos = (List<DtVideo>) request.getAttribute("VIDEOS_PUBLICOS");
				String cast;
				for(DtVideo vp: listaVideosPublicos){ 
				cast = Integer.toString(vp.idVideo);
				%>
					<div class="detalleClickeableVideo"onclick="document.getElementById('Form<%=vp.idVideo%>').submit();">	
					<form id="Form<%=vp.idVideo%>" class="detClickeableVideo" action="/ConsultaVideo" method="GET">
						<input type="hidden" id="1" name="VIDEO_ID" value="<%=cast%>">
						<img class="icon" width="30%" alt="DetalleVideo" src="<%= vp.UrlThumbnail %>">
						<br>
						<header>
						<%= vp.nombre %>
						<br>
						User: <%= vp.usuario %>
						</header>
					</form>	
					</div>
				<%}%>
			</div>	
			<p>Videos del usuario:</p>
			<div class="highlights">
				<%
				DtUsuario d = (DtUsuario)request.getSession().getAttribute("USUARIO_LOGEADO");
				if(d != null){ %>
				 <%
					List<DtVideo> listaVideosUsuario = (List<DtVideo>) request.getAttribute("VIDEOS_USUARIO");
					String cast2;
					for (DtVideo v : listaVideosUsuario) { 
						cast2 = Integer.toString(v.idVideo);
					%>			
					<div class="detalleClickeableVideo"onclick="document.getElementById('Form<%=v.idVideo%>').submit();">	
					<form id="Form<%=v.idVideo%>" class="detClickeableVideo" action="/ConsultaVideo" method="GET">
						<input type="hidden" id="1" name="VIDEO_ID" value="<%=cast2%>">
						<img class="icon" width="30%" alt="DetalleVideo" src="<%=v.UrlThumbnail%>">
						<br>
						<header>
						<%= v.nombre %>
						<br>
						User: <%= v.usuario %>
						</header>
					</form>	
					</div>
				<% } } %>
				</div>
		</div>
	</div>
<%@ include file="/WEB-INF/extras/script.jsp" %>
</body>
