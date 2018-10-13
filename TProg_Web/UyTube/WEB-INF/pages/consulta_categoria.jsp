<!doctype html>
<%@ page import = "clases.*" %>
<%@ page import = "datatypes.*" %>
<html lang="en">
<head>
	<%@ include file="/WEB-INF/extras/head.jsp" %>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<title>UyTube - Consulta de categoria </title>
</head>
<body>
	<div class="page">
		<%@ include file="/WEB-INF/extras/header.jsp" %>
		<jsp:include page="/WEB-INF/extras/sidebar.jsp"></jsp:include>
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
			<h2> Listas de reproducción: </h2>
				<% for (String infoListas : (String[]) request.getAttribute("INFO_LISTAS")) { %>
					<%= infoListas %>
					<br>
				<% } %>
				<br>
			<form action="/ConsultaDeCategoria" method="GET">
				<button type="submit">Volver</button>
			</form>
		</div>
	</div>
<%@ include file="/WEB-INF/extras/script.jsp" %>
</body>
</html>