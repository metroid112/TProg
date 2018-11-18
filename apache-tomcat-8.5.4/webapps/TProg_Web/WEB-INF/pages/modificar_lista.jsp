<!doctype html>
<%@ page import = "servicios.*" %>
<%@ page import = "java.util.*" %>
<html lang="en">
<head>
	<jsp:include page="/WEB-INF/extras/head.jsp" />
	<title>UyTube - Modificar lista </title>
</head>
<body>
<body>
	<div class="page">
		<jsp:include page="/WEB-INF/extras/header.jsp" />
		<jsp:include page="/WEB-INF/extras/sidebar.jsp" />
		<div class="contenido">
			<div class="highlights">
			<% List<DtLista> checkeoLista = (List<DtLista>) request.getAttribute("LISTAS"); %>
			<% if (checkeoLista.isEmpty()) { %>
				<% String usuario = (String) request.getAttribute("USUARIO"); %>
				<h1>El usuario <%= usuario %> no tiene listas particulares.</h1>
				<br>
			<% } else {  %>
					<p>Seleccione una lista</p>
					<% for (DtLista lista : (List<DtLista>) request.getAttribute("LISTAS")) { %>
						<% if (lista.isVisible()) { %>
							<div class="detalleClickeableLista" onclick="document.getElementById('Form<%=lista.getIdLista()%>').submit();">		
							<form id="Form<%=lista.getIdLista()%>" class="detClickeableLista" action="ModificarLista" method="POST" >
								<input type="hidden" name="lista" value="<%= lista.getIdLista() %>">
								<input type="hidden" name="modificarLista" value="">
								<img class="icon" width="30%" alt="Lista de reproduccion" src="img/playlist.png">
								<br>
								<header>
								<%= lista.getNombre() %>
								</header>
								<br>
							</form>	
							</div>
						<% } else { %>
							<div class="detalleClickeableLista" onclick="document.getElementById('Form<%=lista.getIdLista()%>').submit();">		
							<form id="Form<%=lista.getIdLista()%>" class="detClickeableLista" action="ModificarLista" method="POST" >
								<input type="hidden" name="lista" value="<%= lista.getIdLista() %>">
								<input type="hidden" name="modificarLista" value="">
								<img class="icon" width="30%" alt="Lista de reproduccion" src="img/playlist.png">
								<br>
								<header>
								<%= lista.getNombre() %>
								</header>
								<br>
							</form>	
							</div>
						<% } %>
					<% } %>
			<% } %>
			</div>
		</div>
	</div>
<jsp:include page="/WEB-INF/extras/script.jsp" />
</body>
</html>