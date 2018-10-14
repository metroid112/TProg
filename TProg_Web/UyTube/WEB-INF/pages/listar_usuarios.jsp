<!doctype html>
<html lang="en">
<head>
	<jsp:include page="/WEB-INF/extras/head.jsp" />
	<title>UyTube - Lista de Usuarios</title>
</head>
<body>
	<div class="page">
		<jsp:include page="/WEB-INF/extras/header.jsp" />
		<jsp:include page="/WEB-INF/extras/sidebar.jsp" />
		<div class="contenido">
			<h1>Usuarios Registrados:</h1>
			<br>
			<% for (String u : (String[]) request.getAttribute("USUARIOS_REGISTRADOS")) { %>
				<%= u %>
			<% } %>
		</div>
	</div>
<jsp:include page="/WEB-INF/extras/script.jsp" />
</body>
</html>