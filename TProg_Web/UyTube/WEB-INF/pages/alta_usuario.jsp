<%@ page import="java.util.List" %>
<!doctype html>
<html lang="en">
<head>
	<jsp:include page="/WEB-INF/extras/head.jsp" />
	<title>UyTube - Alta Usuario</title>
</head>
<body>
	<div class="page">
		<jsp:include page="/WEB-INF/extras/header.jsp" />
		<jsp:include page="/WEB-INF/extras/sidebar.jsp" />
		<div class="contenido">
			<div id="prueba"></div> <br>
				<% if (request.getAttribute("ERROR_PASS") != null && (boolean) request.getAttribute("ERROR_PASS")) { %>
					<h2>La contraseñas no coinciden.</h2>
				<% } %>
				<% if (request.getAttribute("ERROR_NICK") != null && (boolean) request.getAttribute("ERROR_PASS")) { %>
					<h2>El nick ya esta siendo usado.</h2>
				<% } %>
				<% if (request.getAttribute("ERROR_MAIL") != null && (boolean) request.getAttribute("ERROR_PASS")) { %>
					<h2>El mail ya esta siendo usado.</h2>
				<% } %>
				<form action="AltaUsuario" method="POST" id="formAltaUsuario" enctype="multipart/form-data">
				Nickname: <input type="text" name="nick" id="nick" required>* <span id="nickDisponible"></span>
				<br>
				Nombre: <input type="text" name="nombre" required>*
				<br>
				Apellido: <input type="text" name="apellido" required>*
				<br>
				Correo: <input type="email" id="mail" name="mail" required>*<p id="mailDisponible"></p>
				<br>
				Fecha de nacimiento: <input type="date" name="fecha" required>*
				<br>
				Contrase�a: <input type="password" name="pass" required>*
				<br>
				Confirmar contraseña: <input type="password" name="passConfirm" required>*
				<br>
				Imagen: <input type="file" name="img" accept="image/*">
				<br>
				Nombre del canal: <input type="text" name="nombreCanal">
				<br>
				Descripción del canal: <textarea rows="5" cols="35" form="formAltaUsuario" name="descripcion"></textarea>
				<br>
				Visibilidad: <input type="radio" name="visibilidad" value="privado" checked>Privado  <input type="radio" name="visibilidad">Público
				<br>
				Categor�a:
				<select name="categoria">
					<option selected>Sin categor�a</option>
				<% for (String cat : (List<String>) request.getAttribute("CATEGORIAS")) { %>
					<option value="<%= cat %>"><%= cat %> </option>
				<% } %>
				</select>
				<br>
				<input type="hidden" name="STATE" value="ALTA">
				<button type="submit">Aceptar</button>
			</form>
			<br>
		</div>
	</div>
<jsp:include page="/WEB-INF/extras/script.jsp" />

<script type="text/javascript">
$(document).ready(function() {
	$("#nick").keyup(function() {
		var txt = $("#nick").val();
		$.get("AjaxServlet", {
			tipo: "nick",
			texto : txt
		}, function (respuesta) {
			$("#nickDisponible").text(respuesta);
		});
	});
});
</script>

<script type="text/javascript">
$(document).ready(function() {
	$("#mail").keyup(function() {
		var txt = $("#mail").val();
		$.get("AjaxServlet", {
			tipo: "mail",
			texto : txt
		}, function (respuesta) {
			$("#mailDisponible").text(respuesta);
		});
	});
});
</script>

</body>
</html>
