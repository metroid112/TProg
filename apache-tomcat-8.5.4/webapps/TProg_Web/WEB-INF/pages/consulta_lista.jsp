<%@ page import = "java.util.List" %>
<%@ page import = "java.util.Map" %>
<%@ page import = "java.util.Map.Entry" %>
<%@ page import = "servicios.*,clases.*, utils.*" %>
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
				<% List<DtLista> listas = (List<DtLista>) request.getAttribute("LISTAS"); 				
				for (DtLista Lista : listas) { %>
					<div class="detalleClickeableLista" onclick="document.getElementById('Form<%=Lista.getIdLista()%>').submit();">		
					<form id="Form<%=Lista.getIdLista()%>" class="detClickeableLista" action="ConsultaLista" method="GET" >
						<input type="hidden" name="STATE" value="DETALLESLISTA">
						<input type="hidden" name="IDLISTA" value="<%= Lista.getIdLista() %>">
						<img class="icon" width="30%" alt="Lista de reproduccion" src="img/playlist.png">
						<br>
						<header>
						<%= Lista.getNombre() %>
						</header>
						<br>
					</form>	
					</div>
					<br>
				<% } %>
			<br>
			<% if (session.getAttribute("LOGIN") != null && session.getAttribute("LOGIN").equals(EstadoSesion.LOGIN_CORRECTO)) {
			List<DtLista> listasPrivadas = (List<DtLista>) request.getAttribute("LISTASPRIVADAS");
			List<DtLista> listasDefecto = (List<DtLista>) request.getAttribute("LISTASDEFECTO");
			if (listasPrivadas.size() != 0) {
			for (DtLista u : listasPrivadas) { %>
				<div class="detalleClickeableLista" onclick="document.getElementById('Form<%=u.getIdLista()%>').submit();">		
				<form id="Form<%=u.getIdLista()%>" class="detClickeableLista" action="ConsultaLista" method="GET">
					<input type="hidden" name="STATE" value="DETALLESLISTA">
					<img class="icon" width="30%" alt="Lista de reproduccion" src="img/playlist.png">
					<input type="hidden" name="IDLISTA" value="<%=u.getIdLista()%>">
					<br>
					<header>
					<%= u.getNombre() %>
					</header>
					<br>
				</form>	
				</div>
			<% } }
			if (listasDefecto.size() != 0) {
			  for(DtLista lista : listasDefecto) { %>
  				<div class="detalleClickeableLista" onclick="document.getElementById('Form<%=lista.getIdLista()%>').submit();">		
				<form id="Form<%=lista.getIdLista()%>" class="detClickeableLista" action="ConsultaLista" method="POST">
					<input type="hidden" name="STATE" value="DETALLESLISTA">
					<img class="icon" width="30%" alt="Lista de reproduccion" src="img/playlist.png">
					<input type="hidden" name="IDLISTA" value="<%=lista.getIdLista()%>">
					<input type="hidden" name="NOMBRELISTADEFECTO" value="<%= lista.getNombre() %>">
					<br>
					<header>
					<%= lista.getNombre() %>
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