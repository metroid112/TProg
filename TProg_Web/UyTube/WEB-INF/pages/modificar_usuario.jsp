<%@ page import= "servicios.*, java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
<head>
	<jsp:include page="/WEB-INF/extras/head.jsp" />
	<title>UyTube - Modificar Usuario</title>
</head>
<body>
<jsp:include page="/WEB-INF/extras/header.jsp" />
<div class="contenedor">
	<jsp:include page="/WEB-INF/extras/sidebar.jsp"/>
	<div class="contenido">
		<% DtUsuario usuario = (DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO"); %>
		<form action="ModificarUsuario" method="POST" id="formModificarUsuario" enctype="multipart/form-data">
		Nick: <input type="text" value="<%= usuario.getNick() %>" id="nick" name="nick" required><br>
		Nombre: <input type="text" value="<%= usuario.getNombre() %>" name="nombre" required><br>
		Apellido: <input type="text" value="<%= usuario.getApellido() %>" id="mail" name="apellido" required><br>
		Correo: <input type="email" value="<%= usuario.getCorreo() %>" name="mail" required><br>
		Fecha de nacimiento: <input type="date" value="<%= usuario.getFechaNacimiento().toGregorianCalendar().getTime() %>" name="fecha" required><br>
		Password: <input type="password" name="pass" id="pass" required><br>
		Confirmar password: <input type="password" name="passConfirm" id="passconfirm" required><br>
		Imagen: <input type="file" name="img" accept="image/*"><br>
		Nombre del canal: <input type="text" value="<%= usuario.getCanal() %>" name="nombreCanal"><br>
		Descripción del canal: <textarea rows="5" cols="35" form="formModificarUsuario" name="descripcion"><%= usuario.getDescripcionCanal() %></textarea><br>
		Visibilidad: <input type="radio" name="visibilidad" value="privado" <%= usuario.isPrivado() ? "checked" : "" %>>Privado  <input type="radio" name="visibilidad" <%= !usuario.isPrivado() ? "checked" : "" %>>Público<br>
		Categoría:
		<select name="categoria">
			<option <%= usuario.getCategoria().equals("Sin categoria") ? "selected" : "" %> value>Sin categoría</option>
		<% for (DtCategoria cat : (List<DtCategoria>) request.getAttribute("CATEGORIAS")) { %>
			<option value="<%= cat.getNombre() %>" <%= usuario.getCategoria().equals(cat.getNombre()) ? "selected" : "" %>><%= cat.getNombre() %> </option>
		<% } %>
		</select><br>
		<input type="hidden" name="STATE" value="MODIFICAR">
		<button type="submit">Aceptar</button>
		</form>
	</div>
</div>
<jsp:include page="/WEB-INF/extras/script.jsp" />
<script type="text/javascript">
$(document).ready(function() {
	var deshab1 = true;
	var deshab2 = true;
	var deshab3 = true;
	var nickOriginal = <%= usuario.getNick() %>
	var mailOriginal = <%= usuario.getCorreo() %>
	$("#nick").keyup(function() {
		var txt = $("#nick").val();
		$.get("AjaxServlet", {
			tipo: "nick",
			texto : txt
		}, function (respuesta1) {
			if (respuesta1 == "true" && !(txt == nickOriginal)){	//existe nick
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
			if (respuesta2 == "true" && !(txt == mailOriginal)){
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
	});
	
	$("#pass").keyup(function() {
		var pass = $("#pass").val();
		var passConfirm = $("#passConfirm").val();
		deshab3 = (pass != passConfirm);
		if (deshab3) {
			$("#passCoinciden").text("Las contraseñas no coinciden");
			$("#passCoinciden").css("color", "red");
		} else {
			$("#passCoinciden").text("");
		}
	});
	
	$("#formModificarUsuario").submit(function(event) {
		if (deshab1 || deshab2 || deshab3) {
			$("#submitFail").text("Hay errores en los campos, revisar.");
			event.preventDefault();
		}
	});
	
});	
</script>
</body>
</html>