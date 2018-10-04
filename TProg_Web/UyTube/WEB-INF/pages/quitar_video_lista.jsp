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
			<% for (String u : (String[]) request.getAttribute("LISTAS")) { %>
				<div class="detalleClickeableLista">		
				<form action="/ListaServlet" method="GET">
					<input type="hidden" name="LISTA" value="
			<%= u %> ">
					<button><%= u %></button>
				</form>	
				</div>
			<% } %>
			<br>
		</form>
		
	</div>
	<%@ include file="/WEB-INF/extras/script.jsp" %>
</body>
</html>