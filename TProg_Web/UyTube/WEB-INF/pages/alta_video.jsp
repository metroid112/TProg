<%@page import="java.util.List"%>
<!doctype html>
<html lang="en">
<head>
	<jsp:include page="/WEB-INF/extras/head.jsp" />
	<title>UyTube - Alta Video</title>
</head>
<body>
	<div class="page">
		<jsp:include page="/WEB-INF/extras/header.jsp" />
		<jsp:include page="/WEB-INF/extras/sidebar.jsp" />
		<div class="contenido">
		<%if(request.getAttribute("ERROR_1") != null){%>
			<%= request.getAttribute("ERROR_1") %>
		<br>
		<%}
		if(request.getAttribute("ERROR_2") != null){%>
			<%= request.getAttribute("ERROR_2") %>
		<br>
		<%}
		if(request.getAttribute("ERROR_3") != null){%>
			<%= request.getAttribute("ERROR_3") %>
		<br>
		<%} %>
			<form action="AltaVideo" method="POST" id="formAltaVideo">
				<input type="hidden" name="STATE" value="ALTA">
				Nombre: <br> <input type="text" name="nombre" id="nombreVideo" required>* <span id="validVideo" style="color: red; font-size: small;"></span>
				<br>
				Duración (H M S): <br> <input type="number" name="duracionH" id="duracionH" min="0" required><input type="number" name="duracionM" id="duracionM" min="0" required><input type="number" name="duracionS" id="duracionS" min="0" required>*
				<span id="errorDuracion" style="color: red; font-size: small;"></span>
				<br>
				URL: <br> <input type="url" name="url" required>*
				<br>
				Descripción: <br> <textarea rows="5" cols="35" form="formAltaVideo" name="descripcion"></textarea>
				<br>
				Fecha: <input type="date" name="fecha" required>*
				<br>
				Categoría: <br>
				<select name="categoria">
				<% for (String cat : (List<String>) request.getAttribute("CATEGORIAS")) { %>
					<option value="<%= cat %>"><%= cat %> </option>
				<% } %>
				</select>
				<br>
				<input type="submit" value="Aceptar">
			</form>
			<br>
		</div>
	</div>
<jsp:include page="/WEB-INF/extras/script.jsp" />

<script type="text/javascript">

$(document).ready(function() {
	var habilitado = true;
	$("#nombreVideo").keyup(function() {
		var nombre = $("#nombreVideo").val(); 
		$.get("AjaxServlet",{
			texto : nombre,
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
	
	$("#formAltaVideo").submit(function(evento) {
		var hora = parseInt($("#duracionH").val());
		var min = parseInt($("#duracionM").val());
		var seg = parseInt($("#duracionS").val());
		var sum = hora + min + seg;
		if ((habilitado == false) || (sum == "0")) {
			evento.preventDefault();
			if (sum == "0") {
				$("#errorDuracion").text("La duracion no puede ser 0");
			} else {
				$("#errorDuracion").text("");
			}			
		}
	});
});

</script>

</body>
</html>
