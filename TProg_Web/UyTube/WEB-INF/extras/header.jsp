<%@page import="servicios.*" %>
<%@page import="utils.*" %>
<div class="header">
	<div class="head-item1">
		<a href="Inicio">
			<img class="icono" width="200px" alt="UyTube" src="img/logo.png">
		</a>
	</div>
	<div class="head-item busqueda" align="center">
		<form action="Busqueda" method="post">
			<div class="form-group">
				<div class="input-group-btn">
					<input type="text" placeholder="Búsqueda" name="txtBusqueda">
					<input type="hidden" name="TIPO_BUSQUEDA" value="TODOS">
					<button>Buscar</button>
				</div>
			</div>
		</form>
	</div>
	<div class="head-item" align="right">
		<% if (session.getAttribute("USUARIO_LOGEADO") == null) {
		  session.setAttribute("LOGIN", EstadoSesion.NO_LOGIN);
		} %>
		<% if (session.getAttribute("LOGIN") == null || session.getAttribute("LOGIN").equals(EstadoSesion.NO_LOGIN)) { %>
			<form action="login" method="GET">
				<input type="hidden" name="PANTALLALOGIN" value=TRUE>
				<button type="submit">Iniciar Sesion</button>
			</form>
		<% } else if (session.getAttribute("LOGIN").equals(EstadoSesion.LOGIN_CORRECTO)) {%>
			<% DtUsuario logueado = (DtUsuario) session.getAttribute("USUARIO_LOGEADO"); %>
			<div class="thumbnail">
  				<img src="<%= logueado.getIdImagen() %>" alt="Image"/>
			</div>
			Iniciado como <%= logueado.getNick() %>
			<br>
			<form action="login" method="GET">
				<input type="hidden" name="CERRAR_SESION" value="CONFIRM">
				<button class="btnHeader" type="submit">Cerrar Sesion</button>
			</form>
		<% } %>
	</div>
</div>