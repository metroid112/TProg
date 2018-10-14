<%@page import="datatypes.DtUsuario"%>
<%@page import="datatypes.DtVideo"%>
<%@page import="java.util.List"%>
<!doctype html>
<html lang="en">
<head>
	<jsp:include page="/WEB-INF/extras/head.jsp" />
	<title>UyTube - Videos del propietario</title>
</head>
<body>
		<jsp:include page="/WEB-INF/extras/header.jsp" />
		<jsp:include page="/WEB-INF/extras/sidebar.jsp" />
	<form action="ModificarVideo" method="POST">
		<select required name="video">
		<option value="" disabled selected hidden>Seleccione un video</option>
		<% for (DtVideo video : (List<DtVideo>) request.getAttribute("VIDEOS")) { %>
			<option value="<%= video.idVideo %>"><%= video.nombre %> </option>
			<br>
		<% } %>
		</select>
		<input type="hidden" name="videoSeleccionado" value="">
		<button type="submit">Aceptar</button>
	</form>
</body>