<%@page import="servicios.*"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<link rel="stylesheet" type="text/css" href="css/marco.css">
	<title>UyTube - Listas</title>
	<jsp:include page="/WEB-INF/extras/head.jsp" />
</head>
<body>
<div class="container">
<jsp:include page="/WEB-INF/extras/header.jsp" />
			<div class="row">
			<div class="col-1">
			</div>
			<div class="col-10">
			<p style="text-align: center; top-padding: 5px;">  Listas Reproduccion: </p>
			<p style="text-align: center; top-padding: 5px; font-size: 0.8rem;"> Clickee la lista que desee para ver mas informacion </p> 
			</div>
			<div class="col-1">
			</div>
			</div>
			    <div class="row justify-content-center">
    			<table class="table table-striped custab" style="max-width: 80%;">
    			<thead>
        		<tr>
            		<th>Nombre</th>
            		<th>Tipo</th>
            		<th class="text-center"></th>
        		</tr>
    			</thead>
    			<% DtUsuario owner = (DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO"); %>
    			<% List<DtLista> listas = (List<DtLista>) request.getAttribute("LISTAS"); 				
				for (DtLista Lista : listas) { 
				if (owner != null && Lista.getNombreOwner().equals(owner.getNick())) { %>
            		<tr class="clickeable" onclick="document.getElementById('Form<%=Lista.getIdLista()%>').submit();">
                		<td class="clickeable"><%= Lista.getNombre() %></td>
                		<td class="clickeable">Publica</td>
            		</tr>
            		<div>
                		<form id="Form<%=Lista.getIdLista()%>" action="ListaServlet" method="GET">
                		<input type="hidden" name="STATE" value="DETALLESLISTA">
						<input type="hidden" name="IDLISTA" value="<%= Lista.getIdLista() %>">
						</form>
            		</div>
           		<% } } %>
           		<% List<DtLista> listasPrivadas = (List<DtLista>) request.getAttribute("LISTASPRIVADAS");
				List<DtLista> listasDefecto = (List<DtLista>) request.getAttribute("LISTASDEFECTO");
				if (listasPrivadas.size() != 0) {
				for (DtLista u : listasPrivadas) { %>
					<tr class="clickeable" onclick="document.getElementById('Form<%=u.getIdLista()%>').submit();">
                		<td class="clickeable"><%= u.getNombre() %></td>
                		<td class="clickeable">Privada</td>
            		</tr>
            		<div>
                		<form id="Form<%=u.getIdLista()%>" action="ListaServlet" method="GET">
                		<input type="hidden" name="STATE" value="DETALLESLISTA">
						<input type="hidden" name="IDLISTA" value="<%= u.getIdLista() %>">
						</form>
            		</div>
				<% } }
				if (listasDefecto.size() != 0) {
			  	for(DtLista lista : listasDefecto) { 
			  	if (lista.getNombre().equals("Historial")) {%>			  	
			  		<tr class="clickeable" onclick="document.getElementById('Form<%=lista.getIdLista()%>').submit();">
                		<td class="clickeable"><%= lista.getNombre() %></td>
                		<td class="clickeable">Automatica</td>
                	</tr>
            		<div>
                		<form id="Form<%=lista.getIdLista()%>" action="ListaServlet" method="POST">
                		<input type="hidden" name="STATE" value="DETALLESLISTA">
						<input type="hidden" name="IDLISTA" value="<%= lista.getIdLista() %>">
						<input type="hidden" name="NOMBRELISTADEFECTO" value="<%= lista.getNombre() %>">
						</form>
            		</div>
            	<% } else { %>
			  		<tr class="clickeable" onclick="document.getElementById('Form<%=lista.getIdLista()%>').submit();">
                		<td class="clickeable"><%= lista.getNombre() %></td>
                		<td class="clickeable">Defecto</td>
                	</tr>
            		<div>
                		<form id="Form<%=lista.getIdLista()%>" action="ListaServlet" method="POST">
                		<input type="hidden" name="STATE" value="DETALLESLISTA">
						<input type="hidden" name="IDLISTA" value="<%= lista.getIdLista() %>">
						<input type="hidden" name="NOMBRELISTADEFECTO" value="<%= lista.getNombre() %>">
						</form>
            		</div>
			  	<% } } } %>
    </table>
    </div>
</div><!-- /.container-fluid -->
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
</body>
</html>