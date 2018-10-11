<!doctype html>
<%@ page import = "clases.*" %>
<%@ page import = "datatypes.*" %>
<%@ page import = "java.util.*" %>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<title>UyTube - Modificar lista </title>
</head>
<body>
	<% List<DtLista> checkeoLista = (List<DtLista>) request.getAttribute("LISTAS"); %>
	<% if (checkeoLista.isEmpty()) { %>
		<% String usuario = (String) request.getAttribute("USUARIO"); %>
		<h1>El usuario <%= usuario %> no tiene listas particulares.</h1>
		<br>
		<form action="/Inicio" method="GET">
			<button type="submit">Volver</button>
		</form>
	<% } else {  %>
		<form action="/ModificarLista" method="POST">
			<select required name="lista">
			<option value="" disabled selected hidden>Seleccione una lista</option>
			<% for (DtLista lista : (List<DtLista>) request.getAttribute("LISTAS")) { %>
				<% if (lista.isVisible()) { %>
					<option value="<%= lista.getId() %>"><%= lista.getNombre() + " - " + "Publica" %> </option>
				<% } else { %>
					<option value="<%= lista.getId() %>"><%= lista.getNombre() + " - " + "Privada" %> </option>
				<% } %>
				<br>
			<% } %>
			</select>
			<input type hidden name="modificarLista" value="">
			<button type="submit">Aceptar</button>
			<button form="volver" type="submit">Cancelar</button>
		</form>
	<form action="/Inicio" method="GET" id ="volver">
	</form>
	<% } %>
</body>
</html>