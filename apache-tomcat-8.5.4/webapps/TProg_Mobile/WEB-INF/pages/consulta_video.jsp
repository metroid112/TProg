<%@page import="org.apache.jasper.tagplugins.jstl.core.Out"%>
<%@page import="javax.xml.ws.Response"%>
<%@page import="java.io.Writer"%>
<%@page import="servicios.DtVideo"%>
<%@page import="datatypes.DtComentario"%>
<%@page import="servicios.DtUsuario"%>
<%@page import="java.util.Map" %>
<%@page import="java.time.Duration" %>
<%@page import="java.util.List" %>
<%@page import="java.text.DateFormat" %>
<%@page import="java.util.List" %>
<%@page import= "java.text.ParseException" %>
<%@page import= "java.text.SimpleDateFormat" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
<head>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<link rel="stylesheet" type="text/css" href="css/marco.css">
	<title>UyTube - Consulta video</title>
<jsp:include page="/WEB-INF/extras/head.jsp" />
<style>
.form-control{
    margin-top: 0.5rem;
    margin-bottom: 0.5rem;
    }
</style>
</head>
<body>
<div class="container">
<jsp:include page="/WEB-INF/extras/header.jsp" />
		 <% DtVideo vid = (DtVideo) request.getAttribute("DT_VIDEO"); %>
			<div class="vid">
			<iframe width="560" height="315"
				src="https://www.youtube.com/embed/<%= vid.getYoutubeId() %>" allowfullscreen="">
			</iframe>
			</div>
			<br>
			<div class="card">
			<div class="container-fliud">
				<div class="wrapper row">
					<div class="details col-md-6">
						<h3 class="product-title"><%= vid.getNombre() %></h3>
						<div class="rating">
							<span class="review-no"><strong><%= vid.getCalificacionesPositivas().size()%></strong> Me gusta | <strong><%= vid.getCalificacionesNegativas().size()%></strong> No me gusta </span>
						</div>
						<p class="product-description"><strong>Canal:</strong> <%= vid.getUsuario() %></p>
						<%! DateFormat format = new SimpleDateFormat("dd/MM/yyyy");%>
						<p class="product-description"><strong>Fecha:</strong> <%= format.format(vid.getFecha().toGregorianCalendar().getTime()) %></p>
						<% 
						Long segundos = vid.getDuracionSegundos();
						String duracionString = String.format("%d:%02d:%02d", segundos / 3600, (segundos % 3600) / 60, segundos % 60); 
						%>
						<p class="product-description"><strong>Duracion:</strong> <%= duracionString %></p>
						<p class="product-description"><strong>Categoria:</strong> <%= vid.getCategoria() %></p>
						<p class="product-description"><strong>URL:</strong> <%= vid.getUrlVideo() %></p>
						<p class="product-description"><strong>Descripcion:</strong> <%= vid.getDescripcion() %></p>
						<div class="action">
							<button class="like btn btn-default" type="button" onclick="document.getElementById('Form2').submit();"><span class="fa fa-heart"></span></button>
							<button class="add-to-cart btn btn-default" type="button" onclick="document.getElementById('Form1').submit();">No me gusta</button>
						</div>
						<form id="Form2" action="ConsultaVideo" method="POST">
							<input type="hidden" name="ACCION" value="VALORAR_POSITIVO">
							<input type="hidden" id="1" name="VIDEO_ID" value= "<%= vid.getIdVideo() %>" >
						</form>
						<form id="Form1" action="ConsultaVideo" method="POST">
							<input type="hidden" name="ACCION" value="VALORAR_NEGATIVO">
							<input type="hidden" id="1" name="VIDEO_ID" value= "<%= vid.getIdVideo() %>" >
						</form>				
					</div>
				</div>
			</div>
		</div>
				<%DtUsuario d = (DtUsuario)request.getSession().getAttribute("USUARIO_LOGEADO");%>

				<p>Comentarios:</p>

				<%if(vid.getComentarios().isEmpty()){ %>
				No hay comentarios
				<%} %>

		<c:set var="comentarios" value="${DT_VIDEO.getComentarios()}"  scope="request"/>
		<jsp:include page="comentarios.jsp" />
		<%if(d!=null){ %>
			<form action="ConsultaVideo" method="POST">
				<input type="hidden" name="ACCION" value="COMENTAR">
				<input type="text" class="form-control" name="COMENTARIO">
				<input type="hidden" id="1" name="VIDEO_ID" value= "<%= vid.getIdVideo() %>" >
				<button type="submit" class="btn btn-default btn-round-sm btn-sm" style="border-radius: 15px;">Comentar</button>
			</form>
		<% } %>
		</div>
	</div>

</div><!-- /.container-fluid -->
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
</body>
</html>