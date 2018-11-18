<%@page import="datatypes.*" %>
<%@page import="utils.*" %>

<div class="sidebar">
	<% if (session.getAttribute("LOGIN") != null && session.getAttribute("LOGIN").equals(EstadoSesion.LOGIN_CORRECTO)) { %>
		<form action="AltaLista" method="GET">
			<button>Alta Lista</button>
		</form>
		<form action="AltaVideo" method="GET">
			<input type="hidden" name="STATE" value="LOAD">
			<button>Alta Video</button>
		</form>
		<form action="AgregarVideoALista" method="GET">
			<button>Agregar video a lista</button>
		</form>
		<form action="ListaServlet" method="GET">
			<input type="hidden" name="STATE" value="LOADLISTAS">
			<button>Quitar Video de Lista</button>
		</form>
		<form action="ModificarVideo" method="GET">
			<button>Modificar Video</button>
		</form>
		<form action="ModificarLista" method="GET">
			<button>Modificar Lista</button>
		</form>
	<% } else { %>
		<form action="AltaUsuario" method="GET">
			<input type="hidden" name="STATE" value="LOAD">
			<button>Alta Usuario</button>
		</form>
	<% } %>
	<form action="ConsultaLista" method="GET">
		<input type="hidden" name="STATE" value="START">
		<button>Consulta de Lista</button>
	</form>
	<form action="ConsultaUsuario" method="GET">
		<input type="hidden" name="STATE" value="LISTAR">
		<button>Consulta Usuario</button>
	</form>
	<form action="ConsultaDeCategoria" method="GET">
		<button>Listar Categorias</button>
	</form>
	<form action="VideoServlet" method="GET">
		<button>Listar Videos</button>
	</form>
	<form action="CargaDatos" method="GET">
		<button>Cargar Datos</button>
	</form>
</div>
