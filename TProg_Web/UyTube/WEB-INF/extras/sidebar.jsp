<%@page import="datatypes.*" %>
<%@page import="utils.*" %>

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
					<!-- <input type="submit" value="Alta Video (WIP)"> -->
					<button>Alta Video (WIP)</button>
				</form>
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
				<form action="/ListaServlet" method="GET">
					<input type="hidden" name="STATE" value="LOADLISTAS">
					<button>Quitar Video de Lista (WIP)</button>
				</form>		<br>
				<a href="/CargaDatos">Cargar Datos</a>
				<br>
				<form action="/AgregarVideoALista" method="GET">
					<input type="submit" value="Agregar video a lista (WIP)">
				</form>
				<form action="/ConsultaDeCategoria" method="GET">
					<input type="submit" value="Categorias (WIP)">
				</form>
			</div>