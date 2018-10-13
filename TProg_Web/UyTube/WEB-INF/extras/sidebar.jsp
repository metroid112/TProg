<%@page import="datatypes.*" %>
<%@page import="utils.*" %>

<div class="sidebar">
	<% if (session.getAttribute("LOGIN") != null && session.getAttribute("LOGIN").equals(EstadoSesion.LOGIN_CORRECTO)) { %>
		<br>
		<form action="/AltaLista" method="GET">
			<button>Alta Lista</button>
		</form>
		<br>
		<form action="/AltaVideo" method="GET">
			<input type="hidden" name="STATE" value="LOAD">
			<button>Alta Video</button>
		</form>
		<br>
		<form action="/AgregarVideoALista" method="GET">
			<button>Agregar video a lista</button>
		</form>
		<br>
		<form action="/ListaServlet" method="GET">
			<input type="hidden" name="STATE" value="LOADLISTAS">
			<button>Quitar Video de Lista</button>
		</form>
		<form action="/ModificarVideo" method="GET">
			<input type="submit" value="Modificar video (WIP)">
		</form>
	<% } %>
	<br>
	<form action="/AltaUsuario" method="GET">
		<button>Alta Usuario</button>
	</form>
	<br>
	<form action="/ConsultaLista" method="GET">
		<input type="hidden" name="STATE" value="START">
		<button>Consulta de Lista</button>
	</form>
	<br>
	<form action="/ConsultaUsuario" method="GET">
		<input type="hidden" name="STATE" value="LISTAR">
		<button>Consulta Usuario</button>
	</form>
	<br>
	<a href="/GestorUsuarios">Listar Usuarios (NO EXISTE CU)</a>
	<br>
	<form action="/ConsultaDeCategoria" method="GET">
		<button>Listar Categorias</button>
	</form>
	<form action="/ModificarLista" method="GET">
		<button>Modificar Lista</button>
	</form>
	<form action="/VideoServlet" method="GET">
		<button>Listar Videos</button>
	</form>
	<br>
	<form action="/GestorUsuarios" method="GET">
		<button>Listar Usuarios</button>
	</form>
	<br>
	<form action="/CargaDatos" method="GET">
		<button>Cargar Datos</button>
	</form>
</div>
