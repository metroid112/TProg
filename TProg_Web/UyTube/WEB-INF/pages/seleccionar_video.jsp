<%@ page import = "utils.*, servicios.*" %>
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
					<% List<DtUniversal> listaVideos = (List<DtUniversal>) request.getAttribute("VIDEOSLISTA");
					for (DtUniversal videoUniversal : listaVideos) { 
					DtVideo video = (DtVideo) videoUniversal;%>
					<div class="detalleClickeableVideoABorrar"onclick="document.getElementById('Form<%=video.getIdVideo()%>').submit();">	
						<form id="Form<%=video.getIdVideo()%>" class="detClickeableVideo" action="QuitarVideoDeLista" method="POST">
						<input type="hidden" name="listapublica" value="<%=request.getAttribute("LISTAPUBLICA")%>">
						<input type="hidden" name="lista" value="<%=request.getAttribute("LISTA")%>">
						<input type="hidden" name="video" value="<%=video.getIdVideo()%>">
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
	</div>
	<jsp:include page="/WEB-INF/extras/script.jsp" />
</body>
</html>