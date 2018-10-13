<%@page import="datatypes.*" %>
<%@page import="utils.*" %>

<div class="header">
	<div class="head-item">
		<a href="/Inicio">
			<img width="30%" alt="UyTube" src="img/logo.png">
		</a>
	</div>
	<div class="head-item busqueda" align="center">
		<form action="/Busqueda" method="get">
			<div class="form-group">
				<div class="input-group-btn">
					<input type="text" placeholder="Busqueda" name="txtBusqueda">
					<input type="hidden" name="TIPO_BUSQUEDA" value="TODOS">
					<button>Buscar</button>
				</div>
			</div>
		</form>
	</div>
	<div class="head-item" align="right">
		<% if (session.getAttribute("LOGIN") == null || session.getAttribute("LOGIN").equals(EstadoSesion.NO_LOGIN)) { %>
			<form action="/login" method="GET">
				<input type="hidden" name="PANTALLALOGIN" value=TRUE>
				<button type="submit">Iniciar Sesion (WIP)</button>
			</form>
		<% } else if (session.getAttribute("LOGIN").equals(EstadoSesion.LOGIN_CORRECTO)) {%>
			Iniciado como <%= ((DtUsuario)session.getAttribute("USUARIO_LOGEADO")).nombre %>
			<br>
			<form action="/login" method="GET">
				<input type="hidden" name="CERRAR_SESION" value="CONFIRM">
				<button type="submit">Cerrar Sesion</button>
			</form>
		<% } %>
	</div>
</div>