<!doctype html>
<%@ page import = "clases.*" %>
<%@ page import = "datatypes.*" %>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<title>UyTube - Agregar video a lista</title>
</head>
<body>
	<% //if (request.getAttribute("ERROR") != null) { %>
		<h2> <%= request.getAttribute("ERROR") %></h2>
	<% //} %>
	<form action="/AgregarVideoALista" method="POST">
		<h1>Videos</h1>
		<br>
		<select required name="video">
			<option value="" disabled selected hidden>Seleccione un video</option>
			<% for (DtVideo video : (DtVideo[]) request.getAttribute("LISTA_DE_VIDEOS")) { %>
				<option value="<%= video.idVideo %>"><%= video.nombre %> </option>
			<% } %>
		</select>
				
		<h1>Listas</h1>
		<br>
		<select required name="lista">
			<option value="" disabled selected hidden>Seleccione una lista</option>
			<% for (String listasPorDefecto : (String[]) request.getAttribute("LISTAS_POR_DEFECTO")) { %>
				<option value="D<%= listasPorDefecto %>" ><%= listasPorDefecto + " - Defecto" %></option>
			<% } %>
			<% for (String listasParticulares : (String[]) request.getAttribute("LISTAS_PARTICULARES")) { %>
				<option value="P<%= listasParticulares %>"><%= listasParticulares + " - Particular" %></option>
			<% } %>
		</select>
		<br>
		<br>
		<button type="submit">Aceptar</button>
		<button form="volver" type="submit">Cancelar</button>
	</form>
	<form action="/Inicio" method="GET" id ="volver">
	</form>

</body>
</html>