<%@ page import = "interfaces.*, utils.*, datatypes.*" %>
<%@ page import = "java.util.List" %>
<!doctype html>
<html lang="en">
<head>
	<jsp:include page="/WEB-INF/extras/head.jsp" />
	<title>Videos de la lista de reproducción</title>
</head>
<body>
	<div class="page">
		<jsp:include page="/WEB-INF/extras/header.jsp" />
		<jsp:include page="/WEB-INF/extras/sidebar.jsp" />
		<div class="contenido">
			<br>
			Seleccione el video que quiere quitar
			<br>
			<div class="highlights">
					<% List<DtVideo> listaVideos = (List<DtVideo>) request.getAttribute("VIDEOSLISTA");
					for (DtVideo video : listaVideos) { %>
					<div class="detalleClickeableVideoABorrar"onclick="document.getElementById('Form<%=video.idVideo%>').submit();">	
						<form id="Form<%=video.idVideo%>" class="detClickeableVideo" action="QuitarVideoDeLista" method="POST">
						<input type="hidden" name="listapublica" value="<%=request.getAttribute("LISTAPUBLICA")%>">
						<input type="hidden" name="lista" value="<%=request.getAttribute("LISTA")%>">
						<input type="hidden" name="video" value="<%=video.idVideo%>">
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
	</div>
	<jsp:include page="/WEB-INF/extras/script.jsp" />
</body>
</html>