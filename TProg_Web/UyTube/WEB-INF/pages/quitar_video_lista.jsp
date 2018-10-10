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
		<jsp:include page="/WEB-INF/extras/sidebar.jsp"></jsp:include>
		<div class="contenido">
			<br>
			Se muestran las listas de 
			<%= ((DtUsuario)session.getAttribute("USUARIO_LOGEADO")).nombre %>
			<br>
			<br>
			Por favor seleccione una lista
			<br>
			<% for (String u : (String[]) request.getAttribute("LISTASPUBLICAS")) { %>
				<div class="detalleClickeableLista">		
				<form action="/ListaServlet" method="GET">
					<input type="hidden" name="STATE" value="DETALLESLISTA">
					<input type="hidden" name="LISTAPUBLICA" value="S">
					<input type="hidden" name="LISTA" value="<%=u%>">
					<button class="detalleLista"><%= u %></button>
				</form>	
				</div>
			<% } %>
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
		
	</div>
	<%@ include file="/WEB-INF/extras/script.jsp" %>
</body>
</html>