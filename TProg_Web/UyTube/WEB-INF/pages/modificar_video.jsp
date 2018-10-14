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
	<jsp:include page="/WEB-INF/extras/head.jsp" />
	<title>UyTube - Modificar video</title>
</head>
<body>
		<jsp:include page="/WEB-INF/extras/header.jsp" />
		<jsp:include page="/WEB-INF/extras/sidebar.jsp" />
	<% if (request.getAttribute("DUPLICADO") != null) { %>
		<h1 style="color:red"><%= request.getAttribute("DUPLICADO") %></h1>
	<% } else if (request.getAttribute("DURACION") != null) { %>
		<h1 style="color:red"><%= request.getAttribute("DURACION") %></h1>
	<% } else if (request.getAttribute("PRIVACIDAD") != null) {%>
		<h1 style="color:red"><%= request.getAttribute("PRIVACIDAD") %></h1>
	<% } %>
	<% DtVideo video = (DtVideo) request.getAttribute("VIDEO"); %>
	<% String nombreVideo = video.nombre; %>
	<% String categoria = video.categoria; %>
	<% String descripcion = video.descripcion; %>
	<%
	  String url = video.urlVideo;
	%>
	<%
	  String visibilidad = video.visible ? "Publico" : "Privado";
	%>
	<%
	  String horas = Long.toString(video.duracion.toHours());
	%>
	<%
	  String minutos = Long.toString((video.duracion.getSeconds() % (3600)) / 60);
	%>
	<%
	  String segundos = Long.toString(video.duracion.getSeconds() % 60);
	%>
	<%
	  DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date = format.format(video.fecha);
	%>

	<form action="ModificarVideo" method="POST">
		<input type="hidden" name="oldNombre" value="<%=video.nombre%>">
		Nombre del video: <input type="text" name="nombreVideo" value="<%=video.nombre%>">
		<br><br>
		Categoria del video: 
		<select required name="categoria">
		<option value="<%=video.categoria%>"><%=video.categoria%> </option>
		<%
		  for (String cat : (String[]) request.getAttribute("CATEGORIAS")) {
		%>
			<%
			  if (!cat.equals(video.categoria)) {
			%>
				<option value="<%=cat%>"><%=cat%> </option>
				<br>
			<%
			  }
			%>
		<%
		  }
		%>
		</select>
		<br><br>
		Descripción: <textarea rows="5" cols="35" name="descripcionVideo"><%=video.descripcion%></textarea>
		<br><br>
		URL: <input type="text" name="urlVideo" value="<%=video.urlVideo%>">
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
		Duracion (H M S): <input type="number" name="duracionH" id="hora" min="0" oninput="validity.valid||(value='');" value="<%= horas %>"required><input type="number" name="duracionM" id="minuto" min="0" oninput="validity.valid||(value='');" value="<%= minutos %>"required><input type="number" id="segundo" min="0" name="duracionS" oninput="validity.valid||(value='');" value="<%= segundos %>"required>*
		<br><br>
		Fecha: <input type="date" value="<%= date %>" name="fecha" required>*
		<input type="hidden" name="modificar"  value="">
		<button type="submit" onclick="validate()">Modificar datos</button>
	</form>
</body>