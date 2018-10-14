<!doctype html>
<%@ page import = "datatypes.*" %>
<%@ page import = "java.util.*" %>
<html lang="en">
<head>
	<jsp:include page="/WEB-INF/extras/head.jsp" />
	<title>UyTube - Modificar lista </title>
</head>
<body>
<body>
	<div class="page">
		<jsp:include page="/WEB-INF/extras/header.jsp" />
		<jsp:include page="/WEB-INF/extras/sidebar.jsp" />
		<div class="contenido">
			<% List<DtLista> checkeoLista = (List<DtLista>) request.getAttribute("LISTAS"); %>
			<% if (checkeoLista.isEmpty()) { %>
				<% String usuario = (String) request.getAttribute("USUARIO"); %>
				<h1>El usuario <%= usuario %> no tiene listas particulares.</h1>
				<br>
			<% } else {  %>
				<form action="ModificarLista" method="POST">
					<select required name="lista">
					<option value="" disabled selected hidden>Seleccione una lista</option>
					<% for (DtLista lista : (List<DtLista>) request.getAttribute("LISTAS")) { %>
						<% if (lista.isVisible()) { %>
							<option value="<%= lista.getId() %>"><%= lista.getNombre() + " - " + "Publica" %> </option>
						<% } else { %>
							<option value="<%= lista.getId() %>"><%= lista.getNombre() + " - " + "Privada" %> </option>
						<% } %>
					<% } %>
					</select>
					<input type="hidden" name="modificarLista" value="">
					<button type="submit">Aceptar</button>
				</form>
			<% } %>
		</div>
	</div>
<jsp:include page="/WEB-INF/extras/script.jsp" />
</body>
</html>