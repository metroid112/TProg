<%@page import="datatypes.*" %>
<%@page import="utils.*" %>

<div class="sidebar">
	<a href="WEB-INF/pages/registro_usuarios.jsp">Prueba "registro usuario"</a>
	<% if (session.getAttribute("LOGIN") != null && session.getAttribute("LOGIN").equals(EstadoSesion.LOGIN_CORRECTO)) { %>
		<br>
		<a href="/AltaLista">Alta Lista (WIP)</a>
		<br>
		<form action="/AltaVideo" method="GET">
			<input type="hidden" name="STATE" value="LOAD">
			<button>Alta Video (WIP)</button>
		</form>
		<br>
		<form action="/AgregarVideoALista" method="GET">
			<input type="submit" value="Agregar video a lista (WIP)">
		</form>
		<br>
		<form action="/ListaServlet" method="GET">
			<input type="hidden" name="STATE" value="LOADLISTAS">
			<button>Quitar Video de Lista (WIP)</button>
		</form>
	<% } %>
	<br>
	<a href="/AltaUsuario">Alta Usuario (WIP)</a>
	<br>
	<form action="/ConsultaLista" method="GET">
		<input type="hidden" name="STATE" value="START">
		<button>Consulta de Lista (WIP)</button>
	</form>
	<br>
	<a href="WEB-INF/pages/consulta_usuario.jsp">Consulta Usuario (WIP)</a>
	<br>
	<a href="/GestorUsuarios">Listar Usuarios (NO EXISTE CU)</a>
	<br>
	<a href="/CargaDatos">Cargar Datos</a>
	<form action="/ConsultaDeCategoria" method="GET">
		<input type="submit" value="Categorias (WIP)">
	</form>
	<form action="/ModificarLista" method="GET">
		<input type="submit" value="Modificar Lista (WIP)">
	</form>
</div>
