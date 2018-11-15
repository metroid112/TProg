<%@page import="servicios.DtUsuario"%>
<%@page import="servicios.DtVideo"%>
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
		<div class="contenido">
	<% if (request.getAttribute("DUPLICADO") != null) { %>
		<h1 style="color:red"><%= request.getAttribute("DUPLICADO") %></h1>
	<% } else if (request.getAttribute("DURACION") != null) { %>
		<h1 style="color:red"><%= request.getAttribute("DURACION") %></h1>
	<% } else if (request.getAttribute("PRIVACIDAD") != null) {%>
		<h1 style="color:red"><%= request.getAttribute("PRIVACIDAD") %></h1>
	<% } %>
	<% DtVideo video = (DtVideo) request.getAttribute("VIDEO"); %>
	<% String nombreVideo = video.getNombre(); %>
	<% String categoria = video.getCategoria(); %>
	<% String descripcion = video.getDescripcion(); %>
	<%
	  String url = video.getUrlVideo();
	%>
	<%
	  String visibilidad = video.isVisible() ? "Publico" : "Privado";
	%>
	<%
	  Duration duracionVid = Duration.ofSeconds(video.getDuracionSegundos());
	  String horas = Long.toString(duracionVid.toHours());
	%>
	<%
	  String minutos = Long.toString((duracionVid.getSeconds() / 60) % 60);
	%>
	<%
	  String segundos = Long.toString(duracionVid.getSeconds() % 60);
	%>
	<%
	  DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date = format.format(video.getFecha().toGregorianCalendar().getTime());
	%>

	<form action="ModificarVideo" id="formModificarVideo" method="POST">
		<input type="hidden" name="oldNombre" value="<%=video.getNombre()%>">
		Nombre del video: <br> <input type="text" name="nombreVideo" id="nombreVideo" value="<%=video.getNombre()%>"> <span id="validVideo" style="color: red;font-size: small;"></span>
		<br>
		Categoria del video: <br>
		<select required name="categoria">
		<option value="<%=video.getCategoria()%>"><%=video.getCategoria()%> </option>
		<%
		  for (String cat : (List<String>) request.getAttribute("CATEGORIAS")) {
		%>
			<%
			  if (!cat.equals(video.getCategoria())) {
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
		<br>
		Descripción: <br>
		<textarea rows="5" cols="35" name="descripcionVideo"><%=video.getDescripcion()%></textarea>
		<br>
		URL: <br> <input type="text" name="urlVideo" value="<%=video.getUrlVideo()%>">
		<br>
		Visibilidad: <br>
		<select required name="visibilidad">
			<option value="<%= visibilidad %>"><%= visibilidad %> </option>
			<% if (visibilidad.equals("Publico")) { %>
				<option value="Privado">Privado</option>
			<% } else { %>
				<option value="Publico">Publico</option>
			<% } %>
		</select>
		<br>
		Duracion (H M S): <br> <input type="number" name="duracionH" id="hora" min="0" oninput="validity.valid||(value='');" value="<%= horas %>"required><input type="number" name="duracionM" id="minuto" min="0" oninput="validity.valid||(value='');" value="<%= minutos %>"required><input type="number" id="segundo" min="0" name="duracionS" oninput="validity.valid||(value='');" value="<%= segundos %>"required>*
		<br>
		Fecha: <br> <input type="date" value="<%= date %>" name="fecha" required>*
		<input type="hidden" name="modificar"  value="">
		<br>
		<input type="submit" value="Modificar datos">
		</div>
	</form>
<jsp:include page="/WEB-INF/extras/script.jsp" />

<script type="text/javascript">

$(document).ready(function() {
	var habilitado = true;
	$("#nombreVideo").keyup(function() {
		var nombre = $("#nombreVideo").val(); 
		$.get("AjaxServlet",{
			texto : nombre,
			textoBase : "<%= video.getNombre() %>",
			tipo : "Video"
		}, function (respuesta) {
			if (respuesta == "true") {
				habilitado = false;
				$("#validVideo").text("Nombre no valido");
			} else {
				habilitado = true;
				$("#validVideo").text("");
			}
		});
	});
	
	$("#formModificarVideo").submit(function(evento) {
		if (habilitado == false) {
			evento.preventDefault();
		}
	});
});

</script>

</body>