<%@page import="servicios.*"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<link rel="stylesheet" type="text/css" href="css/marco.css">
	<title>UyTube - Listas</title>
	<style>
	a.navbar-brand {
	text-align: center;
	font-size: 0.9rem;
	}
	item.hover {
	background: #F5F5F5;
  	transition-duration: 0.3s;
	}
	</style>
</head>
<body>
<div class="container">
<jsp:include page="/WEB-INF/extras/header.jsp" />
<div class="navbar navbar-default">

    <form class="navbar-form" action="ListaServlet" method="post" style="width:100%;">
        <div class="form-group"  style="display:inline; width:100%;">
         
            <div class="input-group" style="display:table;">
         
                <input class="form-control" name="txtBusqueda" placeholder="Busque aqui" autocomplete="off" autofocus="autofocus" type="text" style="width:70%; float:left;">
                <input type="hidden" name="TIPO_BUSQUEDA" value="LISTAS">
            	<div class="input-group-btn navbar-btn" style="border-radius:6px; width:30%; float:right;">
					<button type="submit" class="btn btn-default btn-nav" style="width:100%;">
					Buscar
					</button>
				</div>
            
            </div>
          
        </div>
    </form>

    </div> 
<%
			DtBusqueda resultados = (DtBusqueda) request.getAttribute("RESULTADO_BUSQUEDA");
			List<DtLista> listas = resultados.getListas();
			List<DtUsuario> usuarios = resultados.getUsuarios();
			List<DtVideo> videos = resultados.getVideos();
			int cantResultados = listas.size() + usuarios.size() + videos.size();
			%>
			<div class="row">
			<div class="col-1">
			</div>
			<div class="col-10">
			<% if (request.getParameter("txtBusqueda") == null || request.getParameter("txtBusqueda").equals("null") || request.getParameter("txtBusqueda").equals("")) {%>
			<p style="text-align: center;">   Todas las listas: </p>
			<%} else {%>
			<p> <b>Resultados para:</b> <%= request.getParameter("txtBusqueda") %></p>
			<%}%>
			</div>
			<div class="col-1">
			</div>
			</div>
			    <div class="row col-md-6 col-md-offset-2 custyle">
    			<table class="table table-striped custab">
    			<thead>
        		<tr>
            		<th>Nombre</th>
            		<th>Tipo de lista</th>
            		<th class="text-center">Action</th>
        		</tr>
    			</thead>
    			<%for (DtLista lista : listas) {%>
            		<tr>
                		<td><%= lista.getNombre() %></td>
                		<td>probando</td>
                		<td class="text-center"><a class='btn btn-info btn-xs' href="/VideoServlet"><span class="glyphicon glyphicon-edit"></span>
                		<input type="hidden" name="STATE" value="DETALLESLISTA">
						<input type="hidden" name="IDLISTA" value="<%= lista.getIdLista() %>"> Edit</a> </td>
            		</tr>
           		<% } %>
    </table>
    </div>
</div><!-- /.container-fluid -->
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
</body>
</html>