<%@ page import = "interfaces.*, utils.*, datatypes.*" %>
<!doctype html>
<html lang="en">
<head>
	<jsp:include page="/WEB-INF/extras/head.jsp" />
	<title>Quitar video de lista de reproducción</title>
</head>
<body>
	<div class="page">
		<jsp:include page="/WEB-INF/extras/header.jsp" />
		<jsp:include page="/WEB-INF/extras/sidebar.jsp" />
		<div class="contenido">
			<br>
			Se muestran las listas de 
			<%= ((DtUsuario)session.getAttribute("USUARIO_LOGEADO")).nombre %>
			<br>
			<br>
			Por favor seleccione una lista
			<br>
			<div class="highlights">
				<% for (String u : (String[]) request.getAttribute("LISTASPUBLICAS")) { %>
					<div class="detalleClickeableLista" onclick="document.getElementById('Form<%=u%>').submit();">
					<form id="Form<%=u%>" class="detClickeableLista" action="ListaServlet" method="GET">
						<input type="hidden" name="STATE" value="DETALLESLISTA">
						<input type="hidden" name="LISTAPUBLICA" value="S">
						<input type="hidden" name="LISTA" value="<%=u%>">
						<img class="icon" width="30%" alt="Lista de reproduccion" src="img/playlist.png">
						<br>
						<header>
						<%=u%>
						</header>
						<br>
					</form>	
					</div>
				<% } %>
				<br>
				<% for (String u : (String[]) request.getAttribute("LISTASPRIVADAS")) { %>
					<div class="detalleClickeableLista" onclick="document.getElementById('Form<%=u%>').submit();">
					<form id="Form<%=u%>" class="detClickeableLista" action="ListaServlet" method="GET">
						<input type="hidden" name="STATE" value="DETALLESLISTA">
						<input type="hidden" name="LISTAPUBLICA" value="N">
						<input type="hidden" name="LISTA" value="<%=u%>">
						<img class="icon" width="30%" alt="Lista de reproduccion" src="img/playlist.png">
						<br>
						<header>
						<%=u%>
						</header>
						<br>
					</form>	
					</div>
				<% } %>
				<br>
			</div>
		</div>	
	</div>
	<jsp:include page="/WEB-INF/extras/script.jsp" />
</body>
</html>