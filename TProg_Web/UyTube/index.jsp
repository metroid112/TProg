<%@ page import = "interfaces.*, utils.*, datatypes.*" %>
<!doctype html>
<html>
<head>
	<jsp:include page="WEB-INF/extras/head.jsp" />
	<title>Index</title>
</head>
<body>
	<div class="page">
		<jsp:include page="WEB-INF/extras/header.jsp"/>
		<div class="contenedor">
			<jsp:include page="WEB-INF/extras/sidebar.jsp"></jsp:include>
		</div>
	</div>

	<!-- Deberia redirigir al servlet -->
	<a href="/VideoServlet">Listar Videos (NO EXISTE CU)</a>
	<br>


	<jsp:include page="WEB-INF/extras/script.jsp" />
</body>
</html>
