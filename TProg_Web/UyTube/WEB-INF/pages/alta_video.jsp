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
			<%= request.getAttribute("ERROR_1") %>
			<br>
			<%= request.getAttribute("ERROR_2") %>
			<br>
			<%= request.getAttribute("ERROR_3") %>
			<br>
			<form action="AltaVideo" method="POST" id="formAltaVideo">
				<input type="hidden" name="STATE" value="ALTA">
				Nombre: <input type="text" name="nombre" required>*
				<br>
				Duraci�n (H M S): <input type="number" name="duracionH" required><input type="number" name="duracionM" required><input type="number" name="duracionS" required>*
				<br>
				URL: <input type="url" name="url" required>*
				<br>
				Descripci�n: <textarea rows="5" cols="35" form="formAltaVideo" name="descripcion" required></textarea>*
				<br>
				Fecha: <input type="date" name="fecha" required>*
				<br>
				Categor�a:
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