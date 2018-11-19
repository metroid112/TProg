<!doctype html>
<%@ page import = "servicios.*" %>
<%@ page import = "java.util.*" %>
<html lang="en">
<head>
	<jsp:include page="/WEB-INF/extras/head.jsp" />
	<title>UyTube - Agregar video a lista</title>
</head>
<body>
	<div class="page">
		<jsp:include page="/WEB-INF/extras/header.jsp" />
		<jsp:include page="/WEB-INF/extras/sidebar.jsp" />
		<div class="contenido">
			<% if (request.getAttribute("ERROR") != null) { %>
				<h2 style = "color:red;"> <%= request.getAttribute("ERROR") %></h2>
			<% } %>
			<form action="AgregarVideoALista" method="POST">
				<h1>Videos</h1>
				<br>
				<select required name="video">
					<option value="" disabled selected hidden>Seleccione un video</option>
					<% for (DtVideo video : (List<DtVideo>) request.getAttribute("LISTA_DE_VIDEOS")) { %>
						<option value="<%= video.getIdVideo() %>"><%= video.getNombre() %> </option>
					<% } %>
				</select>
						
				<h1>Listas</h1>
				<br>
				<select required name="lista">
					<option value="" disabled selected hidden>Seleccione una lista</option>
					<% for (String listasPorDefecto : (List<String>) request.getAttribute("LISTAS_POR_DEFECTO")) { %>
						<% if (!listasPorDefecto.equals("Historial")) { %>
						<option value="D<%= listasPorDefecto %>" ><%= listasPorDefecto + " - Defecto" %></option>
						<% } %>
					<% } %>
					<% for (String listasParticulares : (List<String>) request.getAttribute("LISTAS_PARTICULARES")) { %>
						<option value="P<%= listasParticulares %>"><%= listasParticulares + " - Particular" %></option>
					<% } %>
				</select>
				<br>
				<br>
				<input type="hidden" name="agregarVideo" value="">
				<input type="submit" value="Aceptar">
			</form>
		</div>
	</div>
<jsp:include page="/WEB-INF/extras/script.jsp" />
</body>
</html>