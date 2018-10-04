<%@page import="datatypes.*" %>
<%@page import="utils.*" %>

<div class="header">
	<div class="head-item">
		<img width="30%" alt="UyTube" src="img/logo.png">
	</div>
	<div class="head-item" align="center">
	Buscador
	</div>
	<div class="head-item" align="right">
		<% if (session.getAttribute("LOGIN") == null || session.getAttribute("LOGIN").equals(EstadoSesion.NO_LOGIN)) { %>
			<a href="/inicio_sesion.jsp">Iniciar Sesion (WIP)</a>
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