<%@page import="datatypes.DtUsuario"%>
<%@page import="datatypes.DtVideo"%>
<%@page import="java.util.List"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<title>UyTube - Videos del propietario</title>
</head>
<body>
	<form action="/ModificarVideo" method="POST">
		<select required name="video">
		<option value="" disabled selected hidden>Seleccione un video</option>
		<% for (DtVideo video : (List<DtVideo>) request.getAttribute("VIDEOS")) { %>
			<option value="<%= video.idVideo %>"><%= video.nombre %> </option>
			<br>
		<% } %>
		</select>
		<input type="hidden" name="videoSeleccionado" value="">
		<button type="submit">Aceptar</button>
		<button form="volver" type="submit">Cancelar</button>
	</form>
	<form action="/Inicio" method="GET" id ="volver">
	</form>
</body>