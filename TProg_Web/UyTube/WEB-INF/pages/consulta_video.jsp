<%@page import="org.apache.jasper.tagplugins.jstl.core.Out"%>
<%@page import="javax.xml.ws.Response"%>
<%@page import="java.io.Writer"%>
<%@page import="datatypes.DtVideo"%>
<%@page import="datatypes.DtComentario"%>
<%@page import="java.util.Map" %>
<%@page import="java.text.DateFormat" %>
<%@page import= "java.text.ParseException" %>
<%@page import= "java.text.SimpleDateFormat" %>



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

	 <% DtVideo vid = (DtVideo) request.getAttribute("DT_VIDEO"); %>
	
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
		Me gusta:  <%= vid.getCantidadCalificacionesPositivas()%> <!-- Falta listar quien hace las calificaciones -->
		<br><br>
		No me gusta:  <%= vid.getCantidadCalificacionesNegativas()%>
		<br><br>
		
		
		<!-- LA PARTE DE LOS COMENTARIOS -->
		
		Comentarios:
		
		<%! public void printComent(Map<Integer, DtComentario> comentarios, int tab){
			for(DtComentario comentario : comentarios.values() ){
				System.out.println(comentario.texto);
			}
		}
		
		%>
	
		<pre>
			
		</pre>
		<!-- FIN LA PARTE DE LOS COMENTARIOS -->
		
	<form action="/index.jsp">
	<button>Volver</button>

</body>
</html>