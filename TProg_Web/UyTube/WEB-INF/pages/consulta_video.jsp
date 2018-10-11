<%@page import="org.apache.jasper.tagplugins.jstl.core.Out"%>
<%@page import="javax.xml.ws.Response"%>
<%@page import="java.io.Writer"%>
<%@page import="datatypes.DtVideo"%>
<%@page import="datatypes.DtComentario"%>
<%@page import="datatypes.DtUsuario"%>
<%@page import="java.util.Map" %>
<%@page import="java.io.Writer"%>
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
<<<<<<< HEAD
	<div class="page">
		<jsp:include page="/WEB-INF/extras/header.jsp"></jsp:include>
		<div class="contenedor">
			 <% DtVideo vid = (DtVideo) request.getAttribute("DT_VIDEO"); %>
			
			<iframe width="420" height="315"
				src="<%= vid.Url %> ">
			</iframe>
			<br>
					
				Nombre: <%= vid.nombre %>
				 <br><br>
				Canal: <%= vid.usuario %>
				 <br><br>
				<%! DateFormat format = new SimpleDateFormat("dd/mm/yyyy");%>
				 
				Fecha: <%= format.format(vid.fecha) %> 
				 <br><br>
				 
				Duracion: <%= vid.duracion %>
				 <br><br>
				Descripcion: <%= vid.descripcion %> 
				 <br><br>
				Categoria: <%= vid.categoria %>
				 <br><br>
				URL: <%= vid.Url %>
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
				
				<pre>

				</pre>
				<!-- FIN LA PARTE DE LOS COMENTARIOS -->
				
			<form action="/index.jsp">
			<button>Volver</button>
			</form>
			</div>
	</div>
	<jsp:include page="/WEB-INF/extras/script.jsp" />
=======

	 <% DtVideo vid = (DtVideo) request.getAttribute("DT_VIDEO"); %>
	
		Nombre: <%= vid.nombre %>
		 <br><br>
		Canal: <%= vid.usuario %>
		 <br><br>
		<%! DateFormat format = new SimpleDateFormat("dd/mm/yyyy");%>
		 
		Fecha: <%= format.format(vid.fecha) %> 
		 <br><br>
		 <%! DateFormat format2 = new SimpleDateFormat("H:MM:SS");%>
		 
		Duracion: <%= format2.format(vid.duracion) %>
		 <br><br>
		Descripcion: <%= vid.descripcion %> 
		 <br><br>
		Categoria: <%= vid.categoria %>
		 <br><br>
		URL: <%= vid.Url %>
		 <br><br>
		Me gusta:  <%= vid.getCalificacionesPositivas()%> <!-- Falta listar quien hace las calificaciones -->
		<br><br>
		No me gusta:  <%= vid.getCalificacionesNegativas()%>
		<br><br>
		
		
		<!-- LA PARTE DE LOS COMENTARIOS -->
		
		Comentarios:

		<br>
		<c:set var="comentarios" value="${DT_VIDEO.comentarios}"  scope="request"/>
		<jsp:include page="comentarios.jsp" />
		<br>
		Fin comentarios.

		<!-- FIN LA PARTE DE LOS COMENTARIOS -->
		
	<form action="/index.jsp">
	<button>Volver</button>
	</form>
>>>>>>> master
</body>
</html>