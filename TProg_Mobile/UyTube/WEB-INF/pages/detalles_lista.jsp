<%@page import="servicios.*"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<link rel="stylesheet" type="text/css" href="css/marco.css">
	<title>UyTube - Detalle lista</title>
	<jsp:include page="/WEB-INF/extras/head.jsp" />
</head>
<body>
<div class="container">
<jsp:include page="/WEB-INF/extras/header.jsp" />
			<% DtLista lista = (DtLista) request.getAttribute("DTLISTA");// "DTLISTA" es un DtPaquete, el casteo esta mal%>
			<p style="text-align: center; top-padding: 5px; font-size:0.9rem">   Detalles de la lista:</p>
			<% DtUsuario owner = (DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO"); %>
			<p style="text-align: center; top-padding: 5px; margin-top: 0.5rem; margin-bottom: 0.5rem;"><strong> <%= lista.getNombre() %></strong></p>
			<p style="text-align: center; top-padding: 5px; font-size:0.9rem; margin-top: 0.5rem; margin-bottom: 0.5rem;">Propietario: <%= owner.getNick() %></p>
			<p style="text-align: center; top-padding: 5px; font-size:0.9rem; margin-top: 0.5rem; margin-bottom: 0.5rem;">Tipo: <%= lista.getTipo() %></p>
			<div class="row justify-content-center">
    			<table class="table table-striped custab" style="max-width: 80%;">
    			<thead>
        		<tr>
            		<th>Categorias</th>
        		</tr>
    			</thead>
				<% List<String> listaCategorias = (List<String>) lista.getCategorias();
				if (listaCategorias.size()>0) {
				for (String cat : listaCategorias) { %>
            		<tr>
                		<td><%= cat %></td>
            		</tr>
           		<% } } else { %>
           			<tr>
                		<td>Sin categoria</td>
            		</tr>
            	<% } %>
    </table>
    </div>
    			<div class="row">
			<div class="col-1">
			</div>
			<div class="col-10">
			<p style="text-align: center; top-padding: 5px;">Videos de la lista:</p>
			</div>
			<div class="col-1">
			</div>
			</div>
				<% List<DtVideo> listaVideos = (List<DtVideo>) lista.getDtVideos();
				if (listaVideos.size() == 0) { %>
			<div class="row">
			<div class="col-1">
			</div>
			<div class="col-10">
			<p style="text-align: center; top-padding: 5px;">Sin videos.</p>
			</div>
			<div class="col-1">
			</div>
			</div>
				<%} else { %>
    			<div id="products" class="row view-group">
				<% for (DtVideo vid : listaVideos) {
					if (vid.isVisible()) { %>
                <div class="item col-xs-4 col-lg-4">
                    <div class="thumbnail card" onclick="document.getElementById('Form<%=vid.getIdVideo()%>').submit();">
                    <form id="Form<%=vid.getIdVideo()%>" action="ConsultaVideo" method="GET">
						<input type="hidden" id="1" name="VIDEO_ID" value="<%=vid.getIdVideo()%>">
                        <div class="img-event">
                            <img class="group list-group-image img-fluid" src="<%=vid.getUrlThumbnail()%>" alt="" />
                        </div>
                        <div class="caption card-body">
                            <h4 class="group card-title inner list-group-item-heading">
                                <%=vid.getNombre()%></h4>
                            <p class="group inner list-group-item-text">
							Usuario: <%=vid.getUsuario()%><br>
							Video publico
							</p>
                        </div>
                    </form>
                    </div>
                </div>
				<% } else if (!vid.isVisible() && (owner != null && vid.getUsuario().equals(owner.getNick()))) { %>
	                <div class="item col-xs-4 col-lg-4">
                    <div class="thumbnail card" onclick="document.getElementById('Form<%=vid.getIdVideo()%>').submit();">
                    <form id="Form<%=vid.getIdVideo()%>" action="ConsultaVideo" method="GET">
						<input type="hidden" id="1" name="VIDEO_ID" value="<%=vid.getIdVideo()%>">
                        <div class="img-event">
                            <img class="group list-group-image img-fluid" src="<%=vid.getUrlThumbnail()%>" alt="" />
                        </div>
                        <div class="caption card-body">
                            <h4 class="group card-title inner list-group-item-heading">
                                <%=vid.getNombre()%></h4>
                            <p class="group inner list-group-item-text">
							Usuario: <%=vid.getUsuario()%>
							<br>
							Video privado
							</p>
                        </div>
                    </form>
                    </div>
                </div>
				<% }
					}} %>
            </div>

</div><!-- /.container-fluid -->
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
</body>
</html>