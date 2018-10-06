<%@ page import = "clases.*,interfaces.*, utils.*, datatypes.*" %>
<!doctype html>
<html lang="en">
<head>
	<%@ include file="/WEB-INF/extras/head.jsp" %>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
	<title>Constulta listas</title>
</head>
<body>
	<div class="page">
		<%@ include file="/WEB-INF/extras/header.jsp" %>
		<div class="contenedor">
			<br>
			<%= ((DtUsuario)session.getAttribute("USUARIO_LOGEADO")).nombre %>
			<br>
			<br>
			Por favor seleccione una lista
		</div>
			<br>
			<% for (String u : (String[]) request.getAttribute("LISTASPRIVADAS")) { %>
				<div class="detalleClickeableLista">		
				<form action="/ListaServlet" method="GET">
					<input type="hidden" name="STATE" value="DETALLESLISTA">
					<input type="hidden" name="LISTAPUBLICA" value="N">
					<input type="hidden" name="LISTA" value="<%=u%>">
					<button class="detalleLista"><%= u %></button>
				</form>	
				</div>
			<% } %>
			<br>
		</form>
		
	</div>
	<%@ include file="/WEB-INF/extras/script.jsp" %>
</body>
</html>