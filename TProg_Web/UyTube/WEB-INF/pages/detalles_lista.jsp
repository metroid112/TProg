<%@ page import = "clases.*, utils.*, datatypes.*" %>
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
			Detalles de la lista
			<% DtLista lista = (DtLista) request.getAttribute("DTLISTA"); 	// "DTLISTA" es un DtPaquete, el casteo esta mal%>
			<% DtUsuario owner = (DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO"); %>
			<%= lista.getNombre() %>
			<br>
			Videos de la lista:
			<br>
				<div class="highlights">
					<% List<DtVideo> listaVideos = (List<DtVideo>) lista.getDtVideos();
					if (lista.getNombre().equals("Historial") && lista.getTipo().equals("Defecto")) {
						
					}
					for (DtVideo video : listaVideos) {
						if (video.visible || (owner != null && video.usuario.equals(owner))) { %>
					<div class="detalleClickeableVideo"onclick="document.getElementById('Form<%=video.idVideo%>').submit();">
					<form id="Form<%=video.idVideo%>" class="detClickeableVideo" action="ConsultaVideo" method="GET">
						<input type="hidden" name="VIDEO_ID" value="<%=video.idVideo%>">
						<img class="icon" width="30%" alt="DetalleVideo" src="<%=video.urlThumbnail%>">
						<header>
						<%= video.nombre %>
						<br>
						User: <%= video.usuario %>
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
				<% } } %>
			</div>
		</div>
		</div>
	<jsp:include page="/WEB-INF/extras/script.jsp" />
</body>
</html>
