<%@ page import="datatypes.*" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/WEB-INF/extras/head.jsp"></jsp:include>
	<title>UyTube - Busqueda</title>
</head>
<body>
	<jsp:include page="/WEB-INF/extras/header.jsp"></jsp:include>
	<div class="contenedor">
		<div class="contenido" align="center">
			<%
			DtBusqueda resultados = (DtBusqueda) request.getAttribute("RESULTADO_BUSQUEDA");
			List<DtLista> listas = resultados.listas;
			List<DtUsuario> usuarios = resultados.usuarios;
			List<DtVideo> videos = resultados.videos;
			int cantResultados = listas.size() + usuarios.size() + videos.size();
			
			%>
			
			<h3><%= cantResultados %> resultados para <%= request.getParameter("txtBusqueda") %></h3>
			<br>
			<h1>Videos</h1>
			<br>
			<%for (DtVideo vid : videos) {%>
				<div><%= vid.nombre %></div>
				<br>
			<% } %>
			<br>
			
			<h1>Canales</h1>
			<br>
			<%for (DtUsuario usuario : usuarios) {%>
				<div><%= usuario.canal %></div>
				<br>
			<% } %>
			<br>
			
			<h1>Listas</h1>
			<br>
			<%for (DtLista lista : listas) {%>
				<div><%= lista.getNombre() %></div>
				<br>
			<% } %>
	</div>
</body>
</html>