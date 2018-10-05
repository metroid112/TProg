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
		<%
		try {
	  	Fabrica.getIDatos().cargaDatos();
		out.println(Fabrica.getIVideos().getDtVideo(1).nombre);
		} catch (Exception e) {
	 	out.println(e.getMessage());
		}
		%>
		<div class="contenedor">
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
					<!-- <input type="submit" value="Alta Video (WIP)"> -->
					<button>Alta Video (WIP)</button>
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
				<form action="/ListaServlet" method="GET">
					<input type="hidden" name="STATE" value="LOADLISTAS">
					<button>Quitar Video de Lista (WIP)</button>
				</form>		<br>
				<a href="/CargaDatos">Cargar Datos</a>
			</div>
		</div>
	</div>
	<jsp:include page="WEB-INF/extras/script.jsp" />
</body>
</html>
