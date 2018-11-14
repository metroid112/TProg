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
		<form action="ModificarUsuario" method="POST" id="formAltaUsuario" enctype="multipart/form-data">
		Nick: <input type="text" value="<%= usuario.getNick() %>" name="nick"><br>
		Nombre: <input type="text" value="<%= usuario.getNombre() %>" name="nombre"><br>
		Apellido: <input type="text" value="<%= usuario.getApellido() %>" name="apellido"><br>
		Correo: <input type="email" value="<%= usuario.getCorreo() %>" name="mail"><br>
		Fecha de nacimiento: <input type="date" value="<%= usuario.getFechaNacimiento() %>" name="fecha"><br>
		Password: <input type="password" name="pass"><br>
		Confirmar password: <input type="password" name="passConfirm"><br>
		Imagen: <input type="file" name="img" accept="image/*"><br>
		Nombre del canal: <input type="text" value="<%= usuario.getCanal() %>" name="nombreCanal"><br>
		Descripción del canal: <textarea rows="5" cols="35" form="formAltaUsuario" name="descripcion"><%= usuario.getDescripcionCanal() %></textarea><br>
		Visibilidad: <input type="radio" name="visibilidad" value="privado" <%= usuario.isPrivado() ? "checked" : "" %>>Privado  <input type="radio" name="visibilidad" <%= !usuario.isPrivado() ? "checked" : "" %>>Público<br>
		Categoría:
		<select name="categoria">
			<option selected value>Sin categoría</option>
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
</body>
</html>