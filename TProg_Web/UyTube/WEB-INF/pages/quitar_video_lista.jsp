<%@ page import = "clases.*,interfaces.*, utils.*, datatypes.*" %>
<!doctype html>
<html lang="en">
<head>
	<%@ include file="/WEB-INF/extras/head.jsp" %>
	<title>Quitar video de lista de reproducción</title>
</head>
<body>
	<div class="page">
		<%@ include file="/WEB-INF/extras/header.jsp" %>
		<div class="contenedor">
			<br>
			Se muestran las listas de 
			<%= ((DtUsuario)session.getAttribute("USUARIO_LOGEADO")).nombre %>
			<br>
			<br>
			Por favor seleccione una lista
			<br>
			<% for (String u : (String[]) request.getAttribute("LISTAS")) { %>
				<%= u %> <br>
			<% } %>
			<br>
		<form action="/ListaServlet" method="POST" id="formListaServlet">
			<input type="hidden" name="STATE" value="QUITARVIDEO">
			Nombre de lista particular: <input type="text" name="nombreLista" required>*
			<br>
			Visibilidad: <input type="radio" name="visibilidad" checked>Privado  <input type="radio" name="visibilidad">Público
			<br>
			<button type="submit">Aceptar</button>
			<button form="formDummyServlet" type="submit">Cancelar</button>
		</form>
		<form action="/Inicio" method="GET" id ="formDummyServlet">
		</form>
		</div>
		
	</div>
	<%@ include file="/WEB-INF/extras/script.jsp" %>
</body>
</html>