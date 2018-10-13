<!doctype html>
<%@ page import = "clases.*" %>
<%@ page import = "datatypes.*" %>
<html lang="en">
<head>
	<%@ include file="/WEB-INF/extras/head.jsp" %>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<title>UyTube - Lista de categorias </title>
</head>
<body>
	<div class="page">
		<%@ include file="/WEB-INF/extras/header.jsp" %>
		<jsp:include page="/WEB-INF/extras/sidebar.jsp"></jsp:include>
		<div class="contenido">
			<% String[] listas = (String[]) request.getAttribute("CATEGORIAS");
				if (listas.length == 0) { %>
					<h1>No hay categorias en el sistema.</h1>
					<br>
			<% } else { %>	
				<h1>Categorias</h1>
				<br>
					<% for (String categorias : (String[]) request.getAttribute("CATEGORIAS")) { %>
						<form action="/ConsultaDeCategoria" method="GET">
							<input type hidden name="CATEGORIA" value="<%= categorias %>">
							<button type="submit"><%= categorias %></button>
						</form>
					<% } %>
				<br>
			<% } %>
			<form action="/Inicio" method="GET">
				<button type="submit">Volver</button>
			</form>
		</div>
	</div>
<%@ include file="/WEB-INF/extras/script.jsp" %>
</body>
</html>