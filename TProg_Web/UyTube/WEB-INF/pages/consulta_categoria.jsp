<!doctype html>
<%@ page import = "datatypes.*" %>
<html lang="en">
<head>
	<jsp:include page="/WEB-INF/extras/head.jsp" />
	<title>UyTube - Consulta de categoria </title>
</head>
<body>
	<div class="page">
		<jsp:include page="/WEB-INF/extras/header.jsp" />
		<jsp:include page="/WEB-INF/extras/sidebar.jsp" />
		<div class="contenido">
			<% String categoria = (String) request.getAttribute("CATEGORIA");%>
			<h1>Información de <%= "'" + categoria + "'" %></h1>
			<br>
			<h2> Videos: </h2>
				<% for (String infoVideos : (String[]) request.getAttribute("INFO_VIDEOS")) { %>
					<%= infoVideos %>
					<br>
				<% } %>
				<br>
			<h2> Listas de reproducci�n: </h2>
				<% for (String infoListas : (String[]) request.getAttribute("INFO_LISTAS")) { %>
					<%= infoListas %>
					<br>
				<% } %>
				<br>
			<form action="ConsultaDeCategoria" method="GET">
				<button type="submit">Volver</button>
			</form>
		</div>
	</div>
<jsp:include page="/WEB-INF/extras/script.jsp" />
</body>
</html>
