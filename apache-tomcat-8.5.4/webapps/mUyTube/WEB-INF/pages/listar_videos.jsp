<%@page import="servicios.*"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<link rel="stylesheet" type="text/css" href="css/marco.css">
	<title>UyTube - Videos</title>
	<jsp:include page="/WEB-INF/extras/head.jsp" />
</head>
<body>
<div class="container">
<jsp:include page="/WEB-INF/extras/header.jsp" />
<div class="navbar navbar-default">

    <form class="navbar-form" action="VideoServlet" method="post" style="width:100%;">
        <div class="form-group"  style="display:inline; width:100%;">
         
            <div class="input-group" style="display:table;">
         
                <input class="form-control" name="txtBusqueda" placeholder="Busque aqui" autocomplete="off" autofocus="autofocus" type="text" style="width:70%; float:left;">
                <input type="hidden" name="TIPO_BUSQUEDA" value="VIDEOS">
            	<div class="input-group-btn navbar-btn2" style="border-radius:6px; width:30%; float:right;">
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
			<p style="text-align: center;">   Todos los videos: </p>
			<%} else {%>
			<p> <b>Resultados para:</b> <%= request.getParameter("txtBusqueda") %></p>
			<%}%>
			</div>
			<div class="col-1">
			</div>
			</div>
    			<div id="products" class="row view-group">
				<%for (DtVideo vid : videos) {%>
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
							Usuario: <%=vid.getUsuario()%></p>
                        </div>
                    </form>
                    </div>
                </div>
				<% } %>
            </div>

</div><!-- /.container-fluid -->
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
</body>
</html>