<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<title>UyTube - Alta Video</title>
</head>
<body>
	<form action="/AltaVideo" method="POST" id="formAltaVideo">
		Nombre: <input type="text" name="nombre" required>*
		<br>
		Duración (H M S): <input type="number" name="duracionH" required><input type="number" name="duracionM" required><input type="number" name="duracionS" required>*
		<br>
		Nickname: <input type="text" name="nick" required>*
		<br>
		Correo: <input type="email" name="mail" required>*
		<br>
		Fecha de nacimiento: <input type="date" name="fecha" required>*
		<br>
		Contraseï¿½a: <input type="password" name="pass" required>*
		<br>
		Confirmar contraseï¿½a: <input type="password" name="passConfirm" required>*
		<br>
		Imagen: <input type="file" name="img">
		<br>
		Nombre del canal: <input type="text" name="nombreCanal">
		<br>
		Descripciï¿½n del canal: <textarea rows="5" cols="35" form="formAltaUsuario" name="descripcion"></textarea>
		<br>
		Visibilidad: <input type="radio" name="visibilidad" checked>Privado  <input type="radio" name="visibilidad">Publico
		<br>
		Categorï¿½a:
		<select name="categoria">
			<option value="Deportes">Deportes</option>
			<option value="Musica">Mï¿½sica</option> <!-- meter jsp aca -->
		</select>
		<br>
		<button type="submit">Aceptar</button>
	</form>
	<br>
	<form action="/index.jsp">
		<button>Volver</button>
	</form>
</body>
</html>