<!doctype html>
<%@ page import = "clases.*" %>
<%@ page import = "datatypes.*" %>
<html lang="en">
<head>
	<%@ include file="/WEB-INF/extras/head.jsp" %>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<title>UyTube - Agregar video a lista</title>
</head>
<body>
	<div class="page">
		<%@ include file="/WEB-INF/extras/header.jsp" %>
		<jsp:include page="/WEB-INF/extras/sidebar.jsp"></jsp:include>
		<div class="contenido">
			<% if (request.getAttribute("ERROR") != null) { %>
				<h2 style = "color:red;"> <%= request.getAttribute("ERROR") %></h2>
			<% } %>
			<form action="/AgregarVideoALista" method="POST">
				<h1>Videos</h1>
				<br>
				<select required name="video">
					<option value="" disabled selected hidden>Seleccione un video</option>
					<% for (DtVideo video : (DtVideo[]) request.getAttribute("LISTA_DE_VIDEOS")) { %>
						<option value="<%= video.idVideo %>"><%= video.nombre %> </option>
					<% } %>
				</select>
						
				<h1>Listas</h1>
				<br>
				<select required name="lista">
					<option value="" disabled selected hidden>Seleccione una lista</option>
					<% for (String listasPorDefecto : (String[]) request.getAttribute("LISTAS_POR_DEFECTO")) { %>
						<option value="D<%= listasPorDefecto %>" ><%= listasPorDefecto + " - Defecto" %></option>
					<% } %>
					<% for (String listasParticulares : (String[]) request.getAttribute("LISTAS_PARTICULARES")) { %>
						<option value="P<%= listasParticulares %>"><%= listasParticulares + " - Particular" %></option>
					<% } %>
				</select>
				<br>
				<br>
				<input type hidden name="agregarVideo" value="">
				<button type="submit">Aceptar</button>
				<button form="volver" type="submit">Cancelar</button>
			</form>
			<form action="/Inicio" method="GET" id ="volver">
			</form>
		</div>
	</div>
<%@ include file="/WEB-INF/extras/script.jsp" %>
</body>
</html>