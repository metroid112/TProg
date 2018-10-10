<%@ page import = "clases.*,interfaces.*, utils.*, datatypes.*" %>
<%@ page import = "java.util.List" %>
<!doctype html>
<html lang="en">
<head>
	<%@ include file="/WEB-INF/extras/head.jsp" %>
	<title>Quitar video de lista de reproducción</title>
</head>
<body>
	<div class="page">
		<%@ include file="/WEB-INF/extras/header.jsp" %>
		<div class="contenedor">
			<br>
			Detalles de la lista 
			<% DtLista lista = ((DtLista) request.getAttribute("DTLISTA")); %>
			<%= lista.getNombre() %>
			<br>
			Videos de la lista:
			<br>
		</div>
			<br>
			<div class="listaDeVideos">
				<br>
				<% List<DtVideo> listaVideos = (List<DtVideo>) lista.getDtVideos();
				for (DtVideo video : listaVideos) { %>			
				<form action="/ConsultaVideo" method="GET">
				<div class="eleccionVideoLista">		
					<input type="hidden" name="VIDEO_ID" value="<%=video.idVideo%>">
					<button class="detalleVideo"><%= video.usuario %>-<%= video.nombre %></button>
				</div>
				</form>	
				<br>
				<% } %>
			</div>
			<br>
			Categorias de la lista:
			<br>
			<div class="listaDeCategorias">
				<br>
				<% List<String> listaCategorias = (List<String>) lista.getCategorias();
				for (String cat : listaCategorias) { %>			
				<form action="/Inicio" method="GET">
				<div class="eleccionVideoLista">		
					<input type="hidden" name="CATEGORIA" value="<%=cat%>">
					<button class="detalleCategoria"><%= cat %></button>
				</div>
				</form>	
				<br>
				<% } %>
		</div>
	<%@ include file="/WEB-INF/extras/script.jsp" %>
</body>
</html>