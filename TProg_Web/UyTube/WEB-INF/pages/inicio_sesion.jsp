<!doctype html>
<html>
<head>
	<%@ include file="/WEB-INF/extras/head.jsp" %>
	<meta content="text/html; charset=utf-8">
	<title>UyTube - Iniciar Sesion</title>
</head>
<body>
	<div class="page">
		<%@ include file="/WEB-INF/extras/header.jsp" %>
		<jsp:include page="/WEB-INF/extras/sidebar.jsp"></jsp:include>
		<div class="contenido">
			<form action="/login" method="POST">
				Nick o correo: <input type="text" name="nickname">
				<br>
				Contraseña: <input type="password" name="pass">
				<br>
				<button type="submit">Iniciar</button>
			</form>
		</div>
	</div>
<%@ include file="/WEB-INF/extras/script.jsp" %>
</body>
</html>