<%@ page import = "clases.*,interfaces.*, utils.*, datatypes.*" %>
<%@ page import = "java.util.List" %>
<!doctype html>
<html lang="en">
<head>
	<%@ include file="/WEB-INF/extras/head.jsp" %>
	<title>Videos de la lista de reproducción</title>
</head>
<body>
	<div class="page">
		<%@ include file="/WEB-INF/extras/header.jsp" %>
		<jsp:include page="/WEB-INF/extras/sidebar.jsp"></jsp:include>
		<div class="contenido">
			<br>
			Seleccione el video que quiere quitar
			<br>
			<div class="highlights">
					<% List<DtVideo> listaVideos = (List<DtVideo>) request.getAttribute("VIDEOSLISTA");
					for (DtVideo video : listaVideos) { %>
					<div class="detalleClickeableVideoABorrar"onclick="document.getElementById('Form<%=video.idVideo%>').submit();">	
						<form id="Form<%=video.idVideo%>" class="detClickeableVideo" action="/QuitarVideoDeLista" method="POST">
						<input type="hidden" name="listapublica" value="<%=request.getAttribute("LISTAPUBLICA")%>">
						<input type="hidden" name="lista" value="<%=request.getAttribute("LISTA")%>">
						<input type="hidden" name="video" value="<%=video.idVideo%>">
						<img class="icon" width="30%" alt="DetalleVideo" src="<%=video.UrlThumbnail%>">
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
	<%@ include file="/WEB-INF/extras/script.jsp" %>
</body>
</html>