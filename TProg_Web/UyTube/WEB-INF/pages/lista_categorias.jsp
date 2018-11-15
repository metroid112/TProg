<!doctype html>
<%@ page import = "servicios.*" %>
<%@ page import = "java.util.*" %>
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
			<% List<DtUniversal> listas = (List<DtUniversal>) request.getAttribute("CATEGORIAS");
				if (listas.size() == 0) { %>
					<h1>No hay categorias en el sistema.</h1>
					<br>
			<% } else { %>	
				<h1>Categorias</h1>
				<br>
					<div class="highlights">	
					<% for (DtUniversal categoriasUniversal : listas) { 
						DtCategoria categorias = (DtCategoria) categoriasUniversal;%>
							<div class="detalleClickeableCategoria" onclick="document.getElementById('Form<%= categorias.getCategoriaId() %>').submit();">	
								<form id="Form<%= categorias.getCategoriaId() %>" class="detClickeableCategoria" action="ConsultaDeCategoria" method="POST">
									<input type="hidden" name="CATEGORIA" value="<%= categorias.getNombre() %>">
									<img class="icon" width="30%" alt="DetalleVideo" src="img/categoria.png">
									<header>
									<%= categorias.getNombre() %>
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