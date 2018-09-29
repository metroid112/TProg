<%@ page import = "interfaces.*, utils.*, datatypes.*" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
	<title>Index</title>
</head>
<body>
	<h1>Requerimientos m�nimos</h1>
	<div style="float: right">
		<%= session.getAttribute("LOGIN") %>
		<% if (session.getAttribute("LOGIN") != null && session.getAttribute("LOGIN").equals(EstadoSesion.LOGIN_CORRECTO)) {%>
			<br>
			<%= ((DtUsuario)session.getAttribute("USUARIO_LOGEADO")).nombre %>
			<br>
			<form action="/login" method="GET">
				<input type="hidden" name="CERRAR_SESION" value="CONFIRM">
				<button type="submit">Cerrar Sesion</button>
			</form>
		<% } %>
	</div>
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
	<a href="/ConsultaVideo">Consulta Video (WIP)</a>
	<br>
	<!-- Deberia redirigir al servlet -->
	<a href="/VideoServlet">Listar Videos (NO EXISTE CU)</a>
	<br>
	<a href="/GestorUsuarios">Listar Usuarios (NO EXISTE CU)</a>
	<br>
	<a href="jsp/quitar_video_lista.jsp">Quitar Video de Lista (WIP)</a>
	<br>
	<a href="jsp/inicio_sesion.jsp">Iniciar Sesion (WIP)</a>
	<br>
	<a href="/CargaDatos">Cargar Datos</a>
</body>
</html>
