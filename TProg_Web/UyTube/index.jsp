<!doctype html>
<html>
<head>
	<jsp:include page="WEB-INF/extras/head.jsp" />
	<title>UyTube - Index</title>
</head>
<body>
	<div class="page">
		<jsp:include page="WEB-INF/extras/header.jsp" />
		<div class="contenedor">
			<jsp:include page="WEB-INF/extras/sidebar.jsp" />
			<form action="Prueba" method="get">
				texto: <input type="text" name="texto">
				<button>Send</button>
			</form>
		</div>
		<jsp:include page="WEB-INF/extras/script.jsp" />
	</div>	
</body>
</html>
