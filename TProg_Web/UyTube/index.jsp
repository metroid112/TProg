<%@page import="manejadores.ManejadorVideos"%>
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
			<div class="sidebar">
				<h4>Requerimientos mínimos</h4>
				<br>
				<a href="WEB-INF/pages/registro_usuarios.jsp">Prueba "registro usuario"</a>
				<br>
				<a href="/AltaLista">Alta Lista (WIP)</a>
				<br>
				<a href="WEB-INF/pages/alta_usuario.jsp">Alta Usuario (WIP)</a>
				<br>
				<form action="/AltaVideo" method="GET">
					<input type="hidden" name="STATE" value="LOAD">
					<button>Alta Video (WIP)</button>
				</form>
				<br>
				<a href="WEB-INF/pages/consulta_lista.jsp">Consulta Lista (WIP)</a>
				<br>
				<form action="/ConsultaUsuario" method="GET">
					<input type="hidden" name="STATE" value="LISTAR">
					<button>Consulta Usuario (WIP)</button>
				</form>
				<br>
				<a href="/GestorUsuarios">Listar Usuarios (NO EXISTE CU)</a>
				<br>
				<form action="/ListaServlet" method="GET">
					<input type="hidden" name="STATE" value="LOADLISTAS">
					<button>Quitar Video de Lista (WIP)</button>
				</form>		<br>
				<a href="/CargaDatos">Cargar Datos</a>
				<br>
				<form action="/AgregarVideoALista" method="GET">
					<input type="submit" value="Agregar video a lista (WIP)">
				</form>
				<form action="/ListarCategorias" method="GET">
					<input type="submit" value="Listar categorias (WIP)">
				</form>
			</div>
		</div>
	</div>

	<jsp:include page="WEB-INF/extras/script.jsp" />

</body>
</html>
