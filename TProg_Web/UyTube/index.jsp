<%@ page import = "interfaces.*, utils.*, datatypes.*" %>
<!doctype html>
<html>
<head>
	<jsp:include page="jsp/head.jsp" />
	<title>Index</title>
</head>
<body>
	<div class="page">
		<jsp:include page="jsp/header.jsp"></jsp:include>
		<div class="sidebar">
			<h4>Requerimientos mínimos</h4>
			<br>
			<a href="jsp/registro_usuarios.jsp">Prueba "registro usuario"</a>
			<br>
			<a href="jsp/alta_lista.jsp">Alta Lista (WIP)</a>
			<br>
			<a href="jsp/alta_usuario.jsp">Alta Usuario (WIP)</a>
			<br>
			<form action="/AltaVideo" method="GET">
				<input type="hidden" name="STATE" value="LOAD">
				<input type="submit" value="Alta Video (WIP)">
			</form>
			<br>
			<a href="jsp/consulta_lista.jsp">Consulta Lista (WIP)</a>
			<br>
			<a href="jsp/consulta_usuario.jsp">Consulta Usuario (WIP)</a>
			<br>
			<a href="jsp/consulta_video.jsp">Consulta Video (WIP)</a>
			<br>
			<a href="/GestorUsuarios">Listar Usuarios (NO EXISTE CU)</a>
			<br>
			<a href="jsp/quitar_video_lista.jsp">Quitar Video de Lista (WIP)</a>
			<br>
			<a href="/CargaDatos">Cargar Datos</a>
		</div>
	</div>
</body>
</html>
