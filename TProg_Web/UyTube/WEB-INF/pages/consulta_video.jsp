<%@page import="org.apache.jasper.tagplugins.jstl.core.Out"%>
<%@page import="javax.xml.ws.Response"%>
<%@page import="java.io.Writer"%>
<%@page import="datatypes.DtVideo"%>
<%@page import="datatypes.DtComentario"%>
<%@page import="datatypes.DtUsuario"%>
<%@page import="java.util.Map" %>
<%@page import="java.util.List" %>
<%@page import="java.text.DateFormat" %>
<%@page import="java.util.List" %>
<%@page import= "java.text.ParseException" %>
<%@page import= "java.text.SimpleDateFormat" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!doctype html>
<html lang="en">
<head>

	<%@ include file="/WEB-INF/extras/head.jsp" %>
</head>
<form action="">

</form>

<title>UyTube - Consulta Video</title>
</head>
<body>

	<div class="page">
		<jsp:include page="/WEB-INF/extras/header.jsp"></jsp:include>
		<div class="contenedor">
		<jsp:include page="/WEB-INF/extras/sidebar.jsp"></jsp:include>
		<div class= "contenido">
			 <% DtVideo vid = (DtVideo) request.getAttribute("DT_VIDEO"); %>

			<h1><%= vid.nombre %></h1>
				 <br><br>
			<iframe width="700" height="465"
				src="<%= vid.urlWatchtFormat() %> ">

			</iframe>
			<br>
				<h4>Canal:</h4> <%= vid.usuario %>
				 <br>
				<%! DateFormat format = new SimpleDateFormat("dd/mm/yyyy");%>

				<h4>Fecha:</h4> <%= format.format(vid.fecha) %>
				 <br>

				<h4>Duracion:</h4> <%= vid.duracionPrintFormat() %>

				 <br>

				<h4>Categoria:</h4> <%= vid.categoria %>
				 <br>
				<h4>URL:</h4> <%= vid.Url %>
				 <br>
				<h4>Descripcion:</h4> <%= vid.descripcion %>
				 <br><br>
				<h5>Me gusta:</h5> <%= vid.getCantidadCalificacionesPositivas()%>
				<%DtUsuario d = (DtUsuario)request.getSession().getAttribute("USUARIO_LOGEADO");

				if(d != null){ %>
						<form action="/ConsultaVideo" method="POST">
							<input type="hidden" name="ACCION" value="VALORAR_POSITIVO">
							<input type="hidden" id="1" name="VIDEO_ID" value= "<%= vid.idVideo %>" >
							<button type="submit">Valorar</button>

						</form>

				<%} %>
				<br><br>
				<% List<String> positivos = vid.getCalificacionesPositivas();
				if(d != null && vid.usuario == d.nick){
					for(String user: positivos){%>
						<%= user %>
					<br>
				<%}
				}
				%>
				<br>

				<h5>No me gusta:</h5> <%= vid.getCantidadCalificacionesNegativas()%>
				<%if(d != null){ %>
						<form action="/ConsultaVideo" method="POST">
							<input type="hidden" name="ACCION" value="VALORAR_NEGATIVO">
							<input type="hidden" id="1" name="VIDEO_ID" value= "<%= vid.idVideo %>" >
							<button type="submit">Valorar</button>

						</form>

				<%} %>
				<br><br>
				<% List<String> negativos = vid.getCalificacionesNegativas();
				if(d != null && vid.usuario == d.nick){
					for(String user: negativos){%>
						<%= user %>
					<br>
				<%}
				}
				%>
				<br>

				<h4>Comentarios:</h4>

				<%if(vid.comentarios.isEmpty()){ %>
				No hay comentarios
				<%} %>

		<c:set var="comentarios" value="${DT_VIDEO.comentarios}"  scope="request"/>
		<jsp:include page="comentarios.jsp" />
		<br>
		<%if(d!=null){ %>
			<form action="/ConsultaVideo" method="POST">
				<input type="hidden" name="ACCION" value="COMENTAR">
				<input type="text" name="COMENTARIO">
				<input type="hidden" id="1" name="VIDEO_ID" value= "<%= vid.idVideo %>" >
				<button type="submit">Comentar</button>
			</form>
		<% } %>
		</div>
	</div>
	<jsp:include page="/WEB-INF/extras/script.jsp" />

</body>
</html>
