<%@page import="servicios.DtUsuario"%>
<%@page import="servicios.DtVideo"%>
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
				<div class="detalleClickeableVideo"onclick="document.getElementById('Form<%=video.getIdVideo()%>').submit();">
					<form id="Form<%=video.getIdVideo()%>" class="detClickeableVideo" action="ModificarVideo" method="POST">
					<input type="hidden" name="video" value="<%=video.getIdVideo()%>">
					<input type="hidden" name="videoSeleccionado" value="">
					<img class="icon" width="30%" alt="DetalleVideo" src="<%=video.getUrlThumbnail()%>">
					<br>
					<header>
					<%= video.getNombre() %>
					<br>
					User: <%= video.getUsuario() %>
					</header>
					</form>	
				</div>
			<% } %>
		</div>
	</div>
</body>