<%@ page import = "clases.*,interfaces.*, utils.*, datatypes.*" %>
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
				<form action="/ListaServlet" method="POST">
				<br>
				<select required name="video">
				<option value="" disabled selected hidden>Seleccione el video que quiere quitar</option>
				<% for (String video : (String[]) request.getAttribute("VIDEOSLISTA")) { %>
				<option value="<%= video %>"><%= video %> </option>
				<% } %>
				</select>	
				<br>
				</form>
			</div>
	</div>
	<%@ include file="/WEB-INF/extras/script.jsp" %>
</body>
</html>