<%@ page import = "utils.*, servicios.*" %>
<%@ page import = "java.util.*" %>
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
			Detalles de la lista
			<% DtLista lista = (DtLista) request.getAttribute("DTLISTA");// "DTLISTA" es un DtPaquete, el casteo esta mal%>
			<% DtUsuario owner = (DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO"); %>
			<%= lista.getNombre() %>
			<br>
			Videos de la lista:
			<br>
				<div class="highlights">
					<% List<DtVideo> listaVideos = (List<DtVideo>) request.getAttribute("VIDEOS");
					boolean esHistorial = (boolean) request.getAttribute("HISTORIAL");
					PublicadorService service = new PublicadorService();
				    Publicador port = service.getPublicadorPort();
					for (DtVideo video : listaVideos) {
						if (video.isVisible()|| (owner != null && video.getUsuario().equals(owner))) { %>
					<div class="detalleClickeableVideo"onclick="document.getElementById('Form<%=video.getIdVideo()%>').submit();" style="height: 110px;">
					
					<form id="Form<%=video.getIdVideo()%>" class="detClickeableVideo" action="ConsultaVideo" method="GET">
						<input type="hidden" name="VIDEO_ID" value="<%=video.getIdVideo()%>">
						<img class="icon" width="30%" alt="DetalleVideo" src="<%=video.getUrlThumbnail()%>">
						<header>
						<%= video.getNombre() %>
						<br>
						User: <%= video.getUsuario() %>
						<% if (esHistorial) { %>
							<% int reproducciones = ((Historial) port.historialVideo(video.getIdVideo(), owner.getNick()).getContenido()).getReproducciones();
							String fechaUltimaRepr = ((Historial) port.historialVideo(video.getIdVideo(), owner.getNick()).getContenido()).getFechaUltimaReproduccion().toString(); %>
							<br>Reproducciones: <%= reproducciones %>
							<br>Fecha Ultima Reproduccion: <%= fechaUltimaRepr %>
						<% } %>
						</header>
					</form>
					</div>
					<br>
					<% } } %>
				</div>
			<br>
			<% if(lista.getTipo().equals("Particular")) { %>
			Categorias de la lista:
			<br>
			<div class="highlights">
				<% List<String> listaCategorias = (List<String>) lista.getCategorias();
				if (listaCategorias.isEmpty()) { %>
					<h6>No hay categorias</h6>
				<% } else { 
					for (String cat : listaCategorias) { %>
					<div class="detalleClickeableCategoria"onclick="document.getElementById('Form<%=cat%>').submit();">
						<form id="Form<%=cat%>" class="detClickeableCategoria" action="ConsultaDeCategoria" method="POST">
							<input type="hidden" name="CATEGORIA" value="<%=cat%>">
							<img class="icon" width="30%" alt="DetalleVideo" src="img/categoria.png">
							<header>
							<%= cat %>
							</header>
						</form>
					</div>
					<br>
				<% }}} %>
			</div>
		</div>
		</div>
	<jsp:include page="/WEB-INF/extras/script.jsp" />
</body>
</html>
