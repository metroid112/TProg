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
			<% if (request.getAttribute("ERROR_1") != null) {%>
				<%= request.getAttribute("ERROR_1") %>
			<br>
			<% } %>
			<% if (request.getAttribute("ERROR_2") != null) {%>
				<%= request.getAttribute("ERROR_2") %>
			<br>
			<% } %>
			<% if (request.getAttribute("ERROR_3") != null) {%>
				<%= request.getAttribute("ERROR_3") %>
			<br>
			<% } %>
			<div class="wrap-contact3">
				<form class="contact3-form validate-form" action="/AltaVideo" method="POST" id="formAltaVideo">
					<span class="contact3-form-title">
					Alta de video
					</span>
					<input type="hidden" name="STATE" value="ALTA">
					<div class="wrap-input3 validate-input" data-validate="El nombre es obligatorio">
						<input class="input3" type="text" name="nombre" placeholder="Nombre del video - requerido" required>
						<span class="focus-input3"></span>
					</div>
					<div class="wrap-input3 validate-input" data-validate="URL obligatoria">
						<input class="input3" type="url" name="url" placeholder="URL del video - requerido" required>
						<span class="focus-input3"></span>
					</div>
					<div class="wrap-input3 validate-input" data-validate="URL obligatoria">
						<input class="input3" type="text" name="url" placeholder="URL del video - requerido" required>
						<span class="focus-input3"></span>
					</div>
					<div class="wrap-input3 validate-input" data-validate="Descripcion obligatoria">
						Descripción: <textarea class="input3" rows="5" cols="35" form="formAltaVideo" name="descripcion" placeholder="Descripción - requerido" required></textarea>
						<span class="focus-input3"></span>
					</div>
					Fecha: <input type="date" name="fecha" required>*
					<select name="categoria">
						<option value="Deportes">Deportes</option>
						<option value="Musica">Música</option> <!-- meter jsp aca -->
					</select>
					<br>
					Duración (hh:mm:ss): <input type="number" name="duracionH" required><input type="number" name="duracionM" required><input type="number" name="duracionS" required>
					<br>
					<div class="container-contact3-form-btn">
						<button class="contact3-form-btn">
							Aceptar
						</button>
					</div>
					</form>
				<br>
			</div>
		</div>
	</div>
<%@ include file="/WEB-INF/extras/script.jsp" %>
</body>
</html>