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

	
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<form action="">

</form>

<title>UyTube - Consulta Video</title>
</head>
<body>

	<div class="page">
		<jsp:include page="/WEB-INF/extras/header.jsp"></jsp:include>
		<div class="contenedor">
			 <% DtVideo vid = (DtVideo) request.getAttribute("DT_VIDEO"); %>

			<%= vid.nombre %>
				 <br><br>
			<iframe width="520" height="365"
				src="<%= vid.urlWatchtFormat() %> ">

			</iframe>
			<br>
					

				Canal: <%= vid.usuario %>
				 <br><br>
				<%! DateFormat format = new SimpleDateFormat("dd/mm/yyyy");%>
				 
				Fecha: <%= format.format(vid.fecha) %> 
				 <br><br>
				 
				Duracion: <%= vid.duracionPrintFormat() %>

				 <br><br>

				Categoria: <%= vid.categoria %>
				 <br><br>
				URL: <%= vid.Url %>
				 <br><br>
				Descripcion: <%= vid.descripcion %> 
				 <br><br>
				Me gusta: <%= vid.getCantidadCalificacionesPositivas()%>
				<%DtUsuario d = (DtUsuario)request.getSession().getAttribute("USUARIO_LOGEADO");
				String cast;
				cast = Integer.toString(vid.idVideo);
				if(d != null){ %>
						<form action="/ConsultaVideo" method="POST">
							<input type="hidden" name="VALORAR" value="POSITIVO">
							<input type="hidden" id="1" name="VIDEO_ID2" value= "<%= cast %>" >
					
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
				<br><br>
				
				No me gusta: <%= vid.getCantidadCalificacionesNegativas()%>
				<%if(d != null){ %>
						<form action="/ConsultaVideo" method="POST">
							<input type="hidden" name="VALORAR" value="NEGATIVO">
							<input type="hidden" id="1" name="VIDEO_ID2" value= "<%= cast %>" >
							
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
				<br><br>
				
				<!-- LA PARTE DE LOS COMENTARIOS -->


				Comentarios:
				
				
		<br>
		<c:set var="comentarios" value="${DT_VIDEO.comentarios}"  scope="request"/>
		<jsp:include page="comentarios.jsp" />
		<br>

				<!-- FIN LA PARTE DE LOS COMENTARIOS -->
				
			<form action="/index.jsp">
			<button>Volver</button>
			</form>
			</div>
	</div>
	<jsp:include page="/WEB-INF/extras/script.jsp" />

</body>
</html>