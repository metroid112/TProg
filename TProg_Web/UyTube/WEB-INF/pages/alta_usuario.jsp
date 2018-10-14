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
				<form action="AltaUsuario" method="POST" id="formAltaUsuario">
				Nombre: <input type="text" name="nombre" required>*
				<br>
				Apellido: <input type="text" name="apellido" required>*
				<br>
				Nickname: <input type="text" name="nick" required>*
				<br>
				Correo: <input type="email" name="mail" required>*
				<br>
				Fecha de nacimiento: <input type="date" name="fecha" required>*
				<br>
				Contraseña: <input type="password" name="pass" required>*
				<br>
				Confirmar contraseña: <input type="password" name="passConfirm" required>*
				<br>
				Imagen: <input type="file" name="img">
				<br>
				Nombre del canal: <input type="text" name="nombreCanal">
				<br>
				Descripción del canal: <textarea rows="5" cols="35" form="formAltaUsuario" name="descripcion"></textarea>
				<br>
				Visibilidad: <input type="radio" name="visibilidad" checked>Privado  <input type="radio" name="visibilidad">Publico
				<br>
				Categoría:
				<select name="categoria">
				<% for (String cat : (String[]) request.getAttribute("CATEGORIAS")) { %>
					<option value="<%= cat %>"><%= cat %> </option>
				<% } %>
				</select>
				<br>
				<button type="submit">Aceptar</button>
			</form>
			<br>
		</div>
	</div>
<jsp:include page="/WEB-INF/extras/script.jsp" />
</body>
</html>