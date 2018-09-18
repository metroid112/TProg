<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!-- page import="com.gamebook.controllers.Login"% -->
<!--  %@page import="com.gamebook.model.Usuario"% -->
<div id="header">
    <div class="logo"><a href="/">gamebook</a></div>
    <div class="subtitulo">Porque los gamers necesitaban su red social</div>
	
	<%
		Usuario usr;
		try {
			usr = Login.getUsuarioLogueado(request);
		} catch(Exception ex){
			usr = null;
		}
		
		if(usr != null) {
	%>
	<div class="usuario">
		<a href="/usuarios">Usuarios</a> |
		<a href="/jugar">Jugar</a> |
		Logueado como <a href="/perfil"><%= usr.getNombre() %></a>
		(<%= usr.getEmail() %>)
	</div>
	<% } %>
</div>

<div id="body-container">