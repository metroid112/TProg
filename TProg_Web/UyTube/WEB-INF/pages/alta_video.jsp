<!doctype html>
<html lang="en">
<head>
	<%@ include file="/WEB-INF/extras/head.jsp" %>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<title>UyTube - Alta Video</title>
</head>
<body>
	<div class="page">
		<%@ include file="/WEB-INF/extras/header.jsp" %>
		<jsp:include page="/WEB-INF/extras/sidebar.jsp"></jsp:include>
		<div class="contenido">
			<%= request.getAttribute("ERROR_1") %>
			<br>
			<%= request.getAttribute("ERROR_2") %>
			<br>
			<%= request.getAttribute("ERROR_3") %>
			<br>
			<form action="/AltaVideo" method="POST" id="formAltaVideo">
				<input type="hidden" name="STATE" value="ALTA">
				Nombre: <input type="text" name="nombre" required>*
				<br>
				Duración (H M S): <input type="number" name="duracionH" required><input type="number" name="duracionM" required><input type="number" name="duracionS" required>*
				<br>
				URL: <input type="url" name="url" required>*
				<br>
				Descripción: <textarea rows="5" cols="35" form="formAltaVideo" name="descripcion" required></textarea>*
				<br>
				Fecha: <input type="date" name="fecha" required>*
				<br>
				Categoría:
				<select name="categoria">
					<option value="Deportes">Deportes</option>
					<option value="Musica">Música</option> <!-- meter jsp aca -->
				</select>
				<br>
				<button type="submit">Aceptar</button>
			</form>
			<br>
			<form action="/index.jsp">
				<button>Volver</button>
			</form>
		</div>
	</div>
<%@ include file="/WEB-INF/extras/script.jsp" %>
</body>
</html>