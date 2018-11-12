<%@page import="servicios.DtUsuario"%>
<%@page import="servicios.DtUniversal" %>
<%@page import="servicios.DtVideo"%>
<%@page import="java.util.List"%>
<!doctype html>
<html lang="en">
<!-- CUANDO EN EL INDEX SE LISTEN LOS VIDEOS, ESTO SE PUEDE PELAR -->
<head>
	<jsp:include page="/WEB-INF/extras/head.jsp" />
	<title>UyTube - Lista de Videos</title>
</head>
<body>
	<div class="page">
		<jsp:include page="/WEB-INF/extras/header.jsp" />
		<jsp:include page="/WEB-INF/extras/sidebar.jsp" />
		<div class="contenido">
			<p>Videos Publicos:</p>
			<div class="highlights">
			<%
				List<DtUniversal> listaVideosPublicos = (List<DtUniversal>) request.getAttribute("VIDEOS_PUBLICOS");
				String cast;
				for(DtUniversal vidUni: listaVideosPublicos) {
					DtVideo vp = (DtVideo) vidUni;
					cast = Integer.toString(vp.getIdVideo());
				%>
					<div class="detalleClickeableVideo"onclick="document.getElementById('Form<%=vp.getIdVideo()%>').submit();">	
					<form id="Form<%=vp.getIdVideo()%>" class="detClickeableVideo" action="ConsultaVideo" method="GET">
						<input type="hidden" id="1" name="VIDEO_ID" value="<%=cast%>">
						<img class="icon" width="30%" alt="DetalleVideo" src="<%=vp.getUrlThumbnail()%>">
						<br>
						<header>
						<%=vp.getNombre()%>
						<br>
						Usuario: <%=vp.getUsuario()%>
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
				   List<DtUniversal> listaVideosUsuario = (List<DtUniversal>) request.getAttribute("VIDEOS_USUARIO");
				 					String cast2;
				 					for (DtUniversal vidUni : listaVideosUsuario) { 
				 						DtVideo v = (DtVideo) vidUni;
				 						cast2 = Integer.toString(v.getIdVideo());
				 %>			
					<div class="detalleClickeableVideo"onclick="document.getElementById('Form<%=v.getIdVideo()%>').submit();">	
					<form id="Form<%=v.getIdVideo()%>" class="detClickeableVideo" action="ConsultaVideo" method="GET">
						<input type="hidden" id="1" name="VIDEO_ID" value="<%=cast2%>">
						<img class="icon" width="30%" alt="DetalleVideo" src="<%=v.getUrlThumbnail()%>">
						<br>
						<header>
						<%= v.getNombre() %>
						<br>
						User: <%= v.getUsuario() %>
						</header>
					</form>	
					</div>
				<% } } %>
				</div>
		</div>
	</div>
<jsp:include page="/WEB-INF/extras/script.jsp" />
</body>
