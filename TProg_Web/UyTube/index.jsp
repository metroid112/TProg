<%@ page import = "interfaces.*, utils.*, datatypes.*" %>
<!doctype html>
<html>
<head>
	<jsp:include page="WEB-INF/extras/head.jsp" />
	<title>Index</title>
</head>
<body>
	<div class="page">
		<jsp:include page="WEB-INF/extras/header.jsp"></jsp:include>
		<div class="contenedor">
			<div class="sidebar">
				<h4>Requerimientos mínimos</h4>
				<br>
				<a href="WEB-INF/pages/registro_usuarios.jsp">Prueba "registro usuario"</a>
				<br>
				<a href="WEB-INF/pages/alta_lista.jsp">Alta Lista (WIP)</a>
				<br>
				<a href="WEB-INF/pages/alta_usuario.jsp">Alta Usuario (WIP)</a>
				<br>
				<form action="/AltaVideo" method="GET">
					<input type="hidden" name="STATE" value="LOAD">
					<!-- <input type="submit" value="Alta Video (WIP)"> -->
					<button>Alta Video (WIP)</button>
				</form>
				<br>
				<a href="WEB-INF/pages/consulta_lista.jsp">Consulta Lista (WIP)</a>
				<br>
				<a href="WEB-INF/pages/consulta_usuario.jsp">Consulta Usuario (WIP)</a>
				<br>
				<a href="/GestorUsuarios">Listar Usuarios (NO EXISTE CU)</a>
				<br>
				<form action="/ListaServlet" method="GET">
					<input type="hidden" name="STATE" value="LOADLISTAS">
					<button>Quitar Video de Lista (WIP)</button>
				</form>		<br>
				<a href="/CargaDatos">Cargar Datos</a>
			</div>
		</div>
	</div>

	<br>
	<a href="WEB-INF/pages/registro_usuarios.jsp">Prueba "registro usuario"</a>
	<br>
	<a href="WEB-INF/pages/alta_lista.jsp">Alta Lista (WIP)</a>
	<br>
	<a href="WEB-INF/pages/alta_usuario.jsp">Alta Usuario (WIP)</a>
	<br>
	<form action="/AltaVideo" method="GET">
		<input type="hidden" name="STATE" value="LOAD">
		<input type="submit" value="Alta Video (WIP)">
	</form>
	<br>
	<a href="WEB-INF/pages/consulta_lista.jsp">Consulta Lista (WIP)</a>
	<br>
	<a href="WEB-INF/pages/consulta_usuario.jsp">Consulta Usuario (WIP)</a>
	<br>
	<!-- Deberia redirigir al servlet -->
	<a href="/VideoServlet">Listar Videos (NO EXISTE CU)</a>
	<br>
	<a href="/GestorUsuarios">Listar Usuarios (NO EXISTE CU)</a>
	<br>
	<a href="WEB-INF/pages/quitar_video_lista.jsp">Quitar Video de Lista (WIP)</a>
	<br>
	<a href="WEB-INF/pages/inicio_sesion.jsp">Iniciar Sesion (WIP)</a>
	<br>
	<a href="/CargaDatos">Cargar Datos</a>

	<jsp:include page="WEB-INF/extras/script.jsp" />

</body>
</html>
