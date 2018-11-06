<%@page import="datatypes.DtUsuario"%>
<%@page import="datatypes.DtVideo"%>
<%@page import="java.util.List"%>
<!doctype html>
<html lang="en">
<head>
	<jsp:include page="/WEB-INF/extras/head.jsp" />
	<title>UyTube - Videos del propietario</title>
</head>
<body>
	<jsp:include page="/WEB-INF/extras/header.jsp" />
	<jsp:include page="/WEB-INF/extras/sidebar.jsp" />
	<div class="contenido">
		<br>
		<p>   Seleccione un video para modificarlo</p>
		<br>
		<div class="highlights">
			<% for (DtVideo video : (List<DtVideo>) request.getAttribute("VIDEOS")) { %>
				<div class="detalleClickeableVideo"onclick="document.getElementById('Form<%=video.idVideo%>').submit();">
					<form id="Form<%=video.idVideo%>" class="detClickeableVideo" action="ModificarVideo" method="POST">
					<input type="hidden" name="video" value="<%=video.idVideo%>">
					<input type="hidden" name="videoSeleccionado" value="">
					<img class="icon" width="30%" alt="DetalleVideo" src="<%=video.urlThumbnail%>">
					<br>
					<header>
					<%= video.nombre %>
					<br>
					User: <%= video.usuario %>
					</header>
					</form>	
				</div>
			<% } %>
		</div>
	</div>
</body>