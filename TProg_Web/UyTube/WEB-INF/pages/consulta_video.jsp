<%@page import="org.apache.jasper.tagplugins.jstl.core.Out"%>
<%@page import="javax.xml.ws.Response"%>
<%@page import="java.io.Writer"%>
<%@page import="servicios.DtVideo"%>
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
	<jsp:include page="/WEB-INF/extras/head.jsp" />
	<title>UyTube - Consulta Video</title>
</head>
<body>
	<div class="page">
		<jsp:include page="/WEB-INF/extras/header.jsp" />
		<div class="contenedor">
		<jsp:include page="/WEB-INF/extras/sidebar.jsp" />
		<div class= "contenido">
			 <% DtVideo vid = (DtVideo) request.getAttribute("DT_VIDEO"); %>
			<% String share = (String) request.getAttribute("ShareURL"); %>
			<h1><%= vid.getNombre() %></h1>
				 <br>
			
			<iframe width="700" height="465"
				src="https://www.youtube.com/embed/<%= vid.getYoutubeId() %> ">

			</iframe>
			<br>
				<h4>Canal:</h4> <%= vid.getUsuario() %>
				 <br>
				<%! DateFormat format = new SimpleDateFormat("dd/MM/yyyy");%>

				<h4>Fecha:</h4> <%= format.format(vid.getFecha().toGregorianCalendar().getTime()) %>
				 <br>	
				 
				<% 
				Long segundos = vid.getDuracionSegundos();
				String duracionString = String.format("%d:%02d:%02d", segundos / 3600, (segundos % 3600) / 60, segundos % 60); 
				%>
				<h4>Duracion:</h4> <%= duracionString %>

				 <br>
				<h4>Compartir video:</h4> <a style="width: adjust; background-color: yellow;"><%= share %></a>
				<h4>Categoria:</h4> <%= vid.getCategoria() %>
				 <br>
				<h4>URL:</h4> <%=vid.getUrlVideo()%>
				 <br>
				<h4>Descripcion:</h4> <%= vid.getDescripcion() %>
				 <br><br>
				<h5>Me gusta:</h5> <%= vid.getCalificacionesPositivas().size()%>
				<%DtUsuario d = (DtUsuario)request.getSession().getAttribute("USUARIO_LOGEADO");

				if(d != null){ %>
						<form action="ConsultaVideo" method="POST">
							<input type="hidden" name="ACCION" value="VALORAR_POSITIVO">
							<input type="hidden" id="1" name="VIDEO_ID" value= "<%= vid.getIdVideo() %>" >
							<button type="submit">Valorar</button>

						</form>

				<%} %>
				<br><br>
				<% List<String> positivos = vid.getCalificacionesPositivas();
				if(d != null && vid.getUsuario() == d.getNick()){
					for(String user: positivos){%>
						<%= user %>
					<br>
				<%}
				}
				%>
				<br>

				<h5>No me gusta:</h5> <%= vid.getCalificacionesNegativas().size()%>
				<%if(d != null){ %>
						<form action="ConsultaVideo" method="POST">
							<input type="hidden" name="ACCION" value="VALORAR_NEGATIVO">
							<input type="hidden" id="1" name="VIDEO_ID" value= "<%= vid.getIdVideo() %>" >
							<button type="submit">Valorar</button>

						</form>

				<%} %>
				<br><br>
				<% List<String> negativos = vid.getCalificacionesNegativas();
				if(d != null && vid.getUsuario() == d.getNick()){
					for(String user: negativos){%>
						<%= user %>
					<br>
				<%}
				}
				%>
				<br>

				<h4>Comentarios:</h4>

				<%if(vid.getComentarios().isEmpty()){ %>
				No hay comentarios
				<%} %>

		<c:set var="comentarios" value="${DT_VIDEO.getComentarios()}"  scope="request"/>
		<jsp:include page="comentarios.jsp" />
		<br>
		<%if(d!=null){ %>
			<form action="ConsultaVideo" method="POST">
				<input type="hidden" name="ACCION" value="COMENTAR">
				<input type="text" name="COMENTARIO">
				<input type="hidden" id="1" name="VIDEO_ID" value= "<%= vid.getIdVideo() %>" >
				<button type="submit">Comentar</button>
			</form>
		<% } %>
		</div>
	</div>
	<jsp:include page="/WEB-INF/extras/script.jsp" />
	</div>
</body>
</html>
