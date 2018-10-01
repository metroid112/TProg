<%@page import="datatypes.*" %>
<%@page import="utils.*" %>

<div id="header">
	<div class="logo">
		<img width="20%" height="20%" alt="UyTube" src="img/logo.png">
	</div>
	<div class="buscador" align="center">
	BUSCADOR
	</div>
	<div class="usuario" align="right">
		<% if (session.getAttribute("LOGIN") == null || session.getAttribute("LOGIN").equals(EstadoSesion.NO_LOGIN)) { %>
			<a href="jsp/inicio_sesion.jsp">Iniciar Sesion (WIP)</a>
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