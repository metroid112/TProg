<!doctype html>
<html>
<head>
	<%@ include file="/WEB-INF/extras/head.jsp" %>
	<title>UyTube - Iniciar Sesion</title>
</head>
<body>
	<div class="page">
		<jsp:include page="/WEB-INF/extras/header.jsp" />
		<jsp:include page="/WEB-INF/extras/sidebar.jsp" />
		<div class="contenido">
			<form action="login" method="POST">
				Nick o correo: <input type="text" name="nickname">
				<br>
				Contraseña: <input type="password" name="pass">
				<br>
				<button type="submit">Iniciar</button>
			</form>
		</div>
	</div>
<jsp:include page="/WEB-INF/extras/script.jsp" />
</body>
</html>