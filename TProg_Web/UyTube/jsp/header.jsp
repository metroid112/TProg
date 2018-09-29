<%@page import="datatypes.*" %>
<%@page import="utils.*" %>
<div>
	<h1>UyTube</h1>
</div>
<div>
	<%= session.getAttribute("LOGIN") %>
	<% if (session.getAttribute("LOGIN") != null && session.getAttribute("LOGIN").equals(EstadoSesion.LOGIN_CORRECTO)) {%>
		<br>
		<%= ((DtUsuario)session.getAttribute("USUARIO_LOGEADO")).nombre %>
		<br>
		<form action="/login" method="GET">
			<input type="hidden" name="CERRAR_SESION" value="CONFIRM">
			<button type="submit">Cerrar Sesion</button>
		</form>
	<% } %>
</div>