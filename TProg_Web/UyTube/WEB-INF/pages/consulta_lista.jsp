<%@ page import = "java.util.List" %>
<%@ page import = "java.util.Map" %>
<%@ page import = "java.util.Map.Entry" %>
<%@ page import = "clases.*,interfaces.*, utils.*, datatypes.*" %>
<!doctype html>
<html lang="en">
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		$(document).ready(function(){
   			$('.detalleClickeableLista').click(function() { 
    			$('.detClickeableLista').submit();
			});
		});
	</script>
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
			<%= ((DtUsuario)session.getAttribute("USUARIO_LOGEADO")).nombre %>
			<br>
			Por favor seleccione una lista
			<br>
			<% Map<Integer, ListaParticular> listas = (Map<Integer, ListaParticular>) request.getAttribute("LISTAS");
			for (Entry<Integer, ListaParticular> Lista : listas.entrySet() ) { %>
				<div class="detalleClickeableLista">		
				<form class="detClickeableLista" action="/ConsultaLista" method="GET">
					<input type="hidden" name="STATE" value="DETALLESLISTA">
					<input type="hidden" name="IDLISTA" value="<%= Lista.getValue().getId() %>">
					<input type="text" name="NombreLista" value="<%= Lista.getValue().getNombre() %>">
				</form>	
				</div>
			<% } %>
			<br>
			<% List<DtLista> listasPrivadas = (List<DtLista>) request.getAttribute("LISTASPRIVADAS");
			if (listasPrivadas.size() != 0) {
			for (DtLista u : listasPrivadas) { %>
				<div class="detalleClickeableLista">		
				<form action="/ConsultaLista" method="GET">
					<input type="hidden" name="STATE" value="DETALLESLISTA">
					<input type="hidden" name="IDLISTA" value="<%=u.getId()%>">
					<button class="detalleLista"><%= u.getNombre() %></button>
				</form>	
				</div>
			<% } } %>
			<br>
		</div>
	</div>
	<%@ include file="/WEB-INF/extras/script.jsp" %>
</body>

</html>