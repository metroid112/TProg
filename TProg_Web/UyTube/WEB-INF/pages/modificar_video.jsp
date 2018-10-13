<%@page import="datatypes.DtUsuario"%>
<%@page import="datatypes.DtVideo"%>
<%@page import="java.util.List"%>
<%@page import="java.text.ParseException,
java.text.DateFormat,
java.text.SimpleDateFormat,
java.time.Duration,
java.util.Date" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<title>UyTube - Modificar video</title>
</head>
<body>
	<% if (request.getAttribute("DUPLICADO") != null) { %>
		<h1><%= request.getAttribute("DUPLICADO") %></h1>
	<% } %>
	<% DtVideo video = (DtVideo) request.getAttribute("VIDEO"); %>
	<% String nombreVideo = video.nombre; %>
	<% String categoria = video.categoria; %>
	<% String descripcion = video.descripcion; %>
	<% String url = video.Url; %>
	<% String visibilidad = video.visible ? "Publico" : "Privado"; %>
	<% String horas = Long.toString(video.duracion.toHours()); %>
	<% String minutos = Long.toString((video.duracion.getSeconds() % (3600)) / 60); %>
	<% String segundos = Long.toString(video.duracion.getSeconds() % 60); %>
	<%
	DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	String date = format.format(video.fecha);
	%>

	<script type="text/javascript">
    function validate() {
        	alert("La duracion tiene que ser positiva.");
    }
    </script>
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
		<input type="number" name="test" min="0" oninput="validity.valid||(value='');">
		Duracion (H M S): <input type="number" name="duracionH" id="hora" min="0" oninput="validity.valid||(value='');" value="<%= horas %>"required><input type="number" name="duracionM" id="minuto" value="<%= minutos %>"required><input type="number" id="segundo" name="duracionS" value="<%= segundos %>"required>*
		<br><br>
		Fecha: <input type="date" value="<%= date %>" name="fecha" required>*
		<input type="hidden" name="modificar"  value="">
		<button type="submit" onclick="validate()">Modificar datos</button>
		<button form="volver" type="submit">Cancelar</button>
	</form>
	<form action="/Inicio" method="GET" id ="volver">
	</form>
</body>