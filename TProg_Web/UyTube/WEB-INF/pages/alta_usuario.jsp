<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
				<% if (request.getAttribute("ERROR_PASS") != null && (boolean) request.getAttribute("ERROR_PASS")) { %>
					<h2>La contraseÃ±as no coinciden.</h2>
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
				<span id="boolSpan"></span>
				<br>
				Nombre: <input type="text" name="nombre" required>*
				<br>
				Apellido: <input type="text" name="apellido" required>*
				<br>
				Correo: <input type="email" id="mail" name="mail" required>* <span id="mailDisponible"></span>
				<br>
				Fecha de nacimiento: <input type="date" name="fecha" required>*
				<br>
				Contraseña: <input type="password" name="pass" id="pass" required>*
				<br>
				Confirmar contraseÃ±a: <input type="password" name="passConfirm" id="passConfirm" required>* <span id="passCoinciden"></span>
				<br>
				Imagen: <input type="file" name="img" accept="image/*">
				<br>
				Nombre del canal: <input type="text" name="nombreCanal">
				<br>
				DescripciÃ³n del canal: <textarea rows="5" cols="35" form="formAltaUsuario" name="descripcion"></textarea>
				<br>
				Visibilidad: <input type="radio" name="visibilidad" value="privado" checked>Privado  <input type="radio" name="visibilidad">PÃºblico
				<br>
				Categoría:
				<select name="categoria">
					<option selected>Sin categoría</option>
				<% for (String cat : (List<String>) request.getAttribute("CATEGORIAS")) { %>
					<option value="<%= cat %>"><%= cat %> </option>
				<% } %>
				</select>
				<br>
				<input type="hidden" name="STATE" value="ALTA">
				<button id="botonSubmit" type="submit">Aceptar</button>
				<p id="submitFail" style="color: red;"></p>
			</form>
			<br>
		</div>
	</div>
<jsp:include page="/WEB-INF/extras/script.jsp" />

<script type="text/javascript">
$(document).ready(function() {
	var deshab1 = true;
	var deshab2 = true;
	var deshab3 = true;
	$("#nick").keyup(function() {
		var txt = $("#nick").val();
		$.get("AjaxServlet", {
			tipo: "nick",
			texto : txt
		}, function (respuesta1) {
			if (respuesta1 == "true"){	//existe nick
				$("#nickDisponible").text("Nick no disponible");
				$("#nickDisponible").css("color", "red");
				deshab1 = true;
			} else {
				$("#nickDisponible").text("Nick disponible");
				$("#nickDisponible").css("color", "LimeGreen");
				deshab1 = false;
			}			
		});
	});	
	
	$("#mail").keyup(function() {
		var txt = $("#mail").val();
		$.get("AjaxServlet", {
			tipo: "mail",
			texto : txt
		}, function (respuesta2) {
			if (respuesta2 == "true"){
				$("#mailDisponible").text("Ese correo ya esta en uso");
				$("#mailDisponible").css("color", "red");
				deshab2 = true;
			} else {
				$("#mailDisponible").text("");
				deshab2 = false;
			}			
		});
	});
	
	$("#passConfirm").keyup(function() {
		var pass = $("#pass").val();
		var passConfirm = $("#passConfirm").val();
		deshab3 = (pass != passConfirm);
		if (deshab3) {
			$("#passCoinciden").text("Las contraseñas no coinciden");
			$("#passCoinciden").css("color", "red");
		} else {
			$("#passCoinciden").text("");
		}
	})
	
	$("#formAltaUsuario").submit(function(event) {
		if (deshab1 || deshab2 || deshab3) {
			$("#submitFail").text("Hay errores en los campos, revisar.");
			event.preventDefault();
		}
	});
	
});	
</script>

</body>
</html>
