<!doctype html>
<%@ page import = "datatypes.*" %>
<html lang="en">
<head>
	<jsp:include page="/WEB-INF/extras/head.jsp" />
	<title>UyTube - Lista de categorias </title>
</head>
<body>
	<div class="page">
		<jsp:include page="/WEB-INF/extras/header.jsp" />
		<jsp:include page="/WEB-INF/extras/sidebar.jsp" />
		<div class="contenido">
			<% String[] listas = (String[]) request.getAttribute("CATEGORIAS");
				if (listas.length == 0) { %>
					<h1>No hay categorias en el sistema.</h1>
					<br>
			<% } else { %>	
				<h1>Categorias</h1>
				<br>
					<div class="highlights">	
					<% for (String categorias : (String[]) request.getAttribute("CATEGORIAS")) { %>
							<div class="detalleClickeableCategoria"onclick="document.getElementById('Form<%=categorias%>').submit();">	
								<form id="Form<%=categorias%>" class="detClickeableCategoria" action="ConsultaDeCategoria" method="POST">
									<input type="hidden" name="CATEGORIA" value="<%=categorias%>">
									<img class="icon" width="30%" alt="DetalleVideo" src="img/categoria.png">
									<header>
									<%= categorias %>
									</header>
								</form>	
							</div>
							<br>
					<% } %>
						</div>
				<br>
			<% } %>
		</div>
	</div>
<jsp:include page="/WEB-INF/extras/script.jsp" />
</body>
</html>