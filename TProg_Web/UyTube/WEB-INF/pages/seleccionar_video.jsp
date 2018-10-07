<%@ page import = "clases.*,interfaces.*, utils.*, datatypes.*" %>
<%@ page import = "java.util.List" %>
<!doctype html>
<html lang="en">
<head>
	<%@ include file="/WEB-INF/extras/head.jsp" %>
	<title>Quitar video de lista de reproducción</title>
</head>
<body>
	<div class="page">
		<%@ include file="/WEB-INF/extras/header.jsp" %>
		<div class="contenedor">
			<br>
			Se muestran las listas de 
			<%= ((DtUsuario)session.getAttribute("USUARIO_LOGEADO")).nombre %>
			<br>
			<br>
			Por favor seleccione una lista
		</div>
			<br>
			<div class="eleccionVideoLista">		
				<form action="/QuitarVideoDeLista" method="POST">
				<br>
				<select required name="video">
				<option value="" disabled selected hidden>Seleccione el video que quiere quitar</option>
				<% List<DtVideo> listaVideos = (List<DtVideo>) request.getAttribute("VIDEOSLISTA");
				for (DtVideo video : listaVideos) { %>
				<option value="<%= video.idVideo %>"><%= video.usuario %>-<%= video.nombre %> </option>
				<% } %>
				</select>
				<input type="hidden" name="lista" value="<%=request.getAttribute("LISTA")%>">
				<input type="hidden" name="listapublica" value="<%=request.getAttribute("LISTAPUBLICA")%>">
				<br>
				<button type="submit">Aceptar</button>
				</form>
			</div>
	</div>
	<%@ include file="/WEB-INF/extras/script.jsp" %>
</body>
</html>