<%@page import="datatypes.DtUsuario"%>
<%@page import="datatypes.DtVideo"%>
<%@page import="java.util.List"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<title>UyTube - Modificar video</title>
</head>
<body>
	<% DtVideo video = (DtVideo) request.getAttribute("VIDEO"); %>
	<% String nombreVideo = video.nombre; %>
	<% String categoria = video.categoria; %>
	<% String descripcion = video.descripcion; %>
	<% String url = video.Url; %>
	<% String visibilidad = video.visible ? "Publico" : "Privado"; %>
	<form action="/ModificarVideo" method="POST">
		<input type="hidden" name="oldNombre" value="<%= video.nombre %>">
		Nombre del video: <input type="text" name="nombreVideo" value="<%= video.nombre %>">
		<br><br>
		Categoria del video: 
		<select required name="categoria">
		<option value="<%= video.categoria %>"><%= video.categoria %> </option>
		<% for (String cat : (String[]) request.getAttribute("CATEGORIAS")) { %>
			<% if (!cat.equals(video.categoria)) { %>
				<option value="<%= cat %>"><%= cat %> </option>
				<br>
			<% } %>
		<% } %>
		</select>
		<br><br>
		Descripción: <textarea rows="5" cols="35" name="descripcionVideo"><%= video.descripcion %></textarea>
		<br><br>
		URL: <input type="text" name="urlVideo" value="<%= video.Url %>">
		<br><br>
		Visibilidad: 
		<select required name="visibilidad">
			<option value="<%= visibilidad %>"><%= visibilidad %> </option>
			<% if (visibilidad.equals("Publico")) { %>
				<option value="Privado">Privado</option>
			<% } else { %>
				<option value="Publico">Publico</option>
			<% } %>
		</select>
		<br><br>
		<input type="hidden" name="modificar" value="">
		<button type="submit">Modificar datos</button>
		<button form="volver" type="submit">Cancelar</button>
	</form>
	<form action="/Inicio" method="GET" id ="volver">
	</form>
</body>