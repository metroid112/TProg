<%@ page import = "java.util.List" %>
<%@ page import = "java.util.Map" %>
<%@ page import = "java.util.Map.Entry" %>
<%@ page import = "clases.*,interfaces.*, utils.*, datatypes.*" %>

<!doctype html>
<html lang="en">
<head>
	<%@ include file="/WEB-INF/extras/head.jsp" %>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
	<title>Consulta listas</title>
</head>
<body>
	<div class="page">
		<%@ include file="/WEB-INF/extras/header.jsp" %>
		<jsp:include page="/WEB-INF/extras/sidebar.jsp"></jsp:include>
		<div class= "contenido">
			<br>
			Por favor seleccione una lista
			<br>
			<% Map<Integer, ListaParticular> listas = (Map<Integer, ListaParticular>) request.getAttribute("LISTAS");
			for (Entry<Integer, ListaParticular> Lista : listas.entrySet() ) { %>
				<div class="detalleClickeableLista" onclick="document.getElementById('Form<%=Lista.getValue().getId()%>').submit();">		
				<form id="Form<%=Lista.getValue().getId()%>" class="detClickeableLista" action="/ConsultaLista" method="GET" >
					<input type="hidden" name="STATE" value="DETALLESLISTA">
					<input type="hidden" name="IDLISTA" value="<%= Lista.getValue().getId() %>">
					<br>
					<%= Lista.getValue().getNombre() %>
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
				<form id="Form<%=u.getId()%>" action="/ConsultaLista" method="GET">
					<input type="hidden" name="STATE" value="DETALLESLISTA">
					<input type="hidden" name="IDLISTA" value="<%=u.getId()%>">
					<%= u.getNombre() %>
				</form>	
				</div>
			<% } } } %>
			<br>
		</div>
	</div>
	<%@ include file="/WEB-INF/extras/script.jsp" %>
</body>

</html>