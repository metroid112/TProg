<%@ page import = "java.util.List" %>
<%@ page import = "java.util.Map" %>
<%@ page import = "java.util.Map.Entry" %>
<%@ page import = "clases.*,interfaces.*, utils.*, datatypes.*" %>
<!doctype html>
<html lang="en">
<head>
	<jsp:include page="/WEB-INF/extras/head.jsp" />
	<title>Consulta listas</title>
</head>
<body>
	<div class="page">
		<jsp:include page="/WEB-INF/extras/header.jsp" />
		<jsp:include page="/WEB-INF/extras/sidebar.jsp" />
		<div class= "contenido">
			<br>
			Por favor seleccione una lista
			<br>
			<div class="highlights">
				<% Map<Integer, ListaParticular> listas = (Map<Integer, ListaParticular>) request.getAttribute("LISTAS");
				for (Entry<Integer, ListaParticular> Lista : listas.entrySet() ) { %>
					<div class="detalleClickeableLista" onclick="document.getElementById('Form<%=Lista.getValue().getId()%>').submit();">		
					<form id="Form<%=Lista.getValue().getId()%>" class="detClickeableLista" action="ConsultaLista" method="GET" >
						<input type="hidden" name="STATE" value="DETALLESLISTA">
						<input type="hidden" name="IDLISTA" value="<%= Lista.getValue().getId() %>">
						<img class="icon" width="30%" alt="Lista de reproduccion" src="img/playlist.png">
						<br>
						<header>
						<%= Lista.getValue().getNombre() %>
						</header>
						<br>
					</form>	
					</div>
					<br>
				<% } %>
			<br>
			<% if (session.getAttribute("LOGIN") != null && session.getAttribute("LOGIN").equals(EstadoSesion.LOGIN_CORRECTO)) {
			List<DtLista> listasPrivadas = (List<DtLista>) request.getAttribute("LISTASPRIVADAS");
			if (listasPrivadas.size() != 0) {
			for (DtLista u : listasPrivadas) { %>
				<div class="detalleClickeableLista" onclick="document.getElementById('Form<%=u.getId()%>').submit();">		
				<form id="Form<%=u.getId()%>" class="detClickeableLista" action="ConsultaLista" method="GET">
					<input type="hidden" name="STATE" value="DETALLESLISTA">
					<img class="icon" width="30%" alt="Lista de reproduccion" src="img/playlist.png">
					<input type="hidden" name="IDLISTA" value="<%=u.getId()%>">
					<br>
					<header>
					<%= u.getNombre() %>
					</header>
					<br>
				</form>	
				</div>
			<% } } } %>
			<br>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/extras/script.jsp" />
</body>
</html>