<!doctype html>
<%@ page import = "servicios.*" %>
<%@ page import = "java.util.*" %>
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
			<% servicios.DtCategoria dtCat = (DtCategoria) request.getAttribute("CATEGORIA");%>
			<% List<DtVideo> videos = dtCat.getVideos(); %>
			<% List<DtLista> listas = dtCat.getListas(); %>
			<h1>Informacion de <%= "'" + dtCat.getNombre() + "'" %></h1>
			<br>
			<h2> Videos: </h2>
				<% for (DtVideo video : videos) { %>
					<%= video.getNombre() %>
					<br>
				<% } %>
				<br>
			<h2> Listas de reproduccion: </h2>
				<% for (DtLista lista : listas) { %>
					<%= lista.getNombre() %>
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
