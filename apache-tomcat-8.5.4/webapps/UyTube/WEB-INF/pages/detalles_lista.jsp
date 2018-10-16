<%@ page import = "clases.*,interfaces.*, utils.*, datatypes.*" %>
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
			<% DtLista lista = ((DtLista) request.getAttribute("DTLISTA")); %>
			<%= lista.getNombre() %>
			<br>
			Videos de la lista:
			<br>
				<div class="highlights">
					<% List<DtVideo> listaVideos = (List<DtVideo>) lista.getDtVideos();
					for (DtVideo video : listaVideos) { %>			
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
					<% } %>
				</div>
			<br>
			<% if(lista.getTipo() == "Particular") { %>
			Categorias de la lista:
			<br>
			<div class="highlights">
				<% List<String> listaCategorias = (List<String>) lista.getCategorias();
				for (String cat : listaCategorias) { %>			
				<div class="detalleClickeableCategoria"onclick="document.getElementById('Form<%=cat%>').submit();">	
					<form id="Form<%=cat%>" class="detClickeableCategoria" action="ConsultaDeCategoria" method="GET">
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