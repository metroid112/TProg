<%@page import="datatypes.DtUsuario"%>
<%@page import="datatypes.DtVideo"%>
<%@page import="java.util.List"%>
<!doctype html>
<html lang="en">
<!-- CUANDO EN EL INDEX SE LISTEN LOS VIDEOS, ESTO SE PUEDE PELAR -->
<head>
	<jsp:include page="/WEB-INF/extras/head.jsp" />
	<title>UyTube - Listas de reproduccion</title>
</head>
<body>
	<div class="page">
		<jsp:include page="/WEB-INF/extras/header.jsp" />
		<jsp:include page="/WEB-INF/extras/sidebar.jsp" />
		<div class="contenido">
			<p>Videos Publicos:</p>
			<div class="highlights">
			<%
				List<DtVideo> listaVideosPublicos = (List<DtVideo>) request.getAttribute("VIDEOS_PUBLICOS");
				String cast;
				for(DtVideo vp: listaVideosPublicos) { 
				cast = Integer.toString(vp.idVideo);
				%>
					<div class="detalleClickeableVideo"onclick="document.getElementById('Form<%=vp.idVideo%>').submit();">	
					<form id="Form<%=vp.idVideo%>" class="detClickeableVideo" action="ConsultaVideo" method="GET">
						<input type="hidden" id="1" name="VIDEO_ID" value="<%=cast%>">
						<img class="icon" width="30%" alt="DetalleVideo" src="<%=vp.urlThumbnail%>">
						<br>
						<header>
						<%=vp.nombre%>
						<br>
						Usuario: <%=vp.usuario%>
						</header>
					</form>	
					</div>
				<%
				  }
				%>
			</div>	
			<p>Videos del usuario:</p>
			<div class="highlights">
				<%
				  DtUsuario d = (DtUsuario)request.getSession().getAttribute("USUARIO_LOGEADO");
								if(d != null){
				%>
				 <%
				   List<DtVideo> listaVideosUsuario = (List<DtVideo>) request.getAttribute("VIDEOS_USUARIO");
				 					String cast2;
				 					for (DtVideo v : listaVideosUsuario) { 
				 						cast2 = Integer.toString(v.idVideo);
				 %>			
					<div class="detalleClickeableVideo"onclick="document.getElementById('Form<%=v.idVideo%>').submit();">	
					<form id="Form<%=v.idVideo%>" class="detClickeableVideo" action="ConsultaVideo" method="GET">
						<input type="hidden" id="1" name="VIDEO_ID" value="<%=cast2%>">
						<img class="icon" width="30%" alt="DetalleVideo" src="<%=v.urlThumbnail%>">
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
<jsp:include page="/WEB-INF/extras/script.jsp" />
</body>
