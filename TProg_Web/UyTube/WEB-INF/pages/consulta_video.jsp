<%@page import="datatypes.DtVideo"%>
<%@page import="datatypes.DtComentario"%>
<%@page import="java.util.Map" %>


<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<title>UyTube - Consulta Video</title>
</head>
<body>

	 <% DtVideo vid = (DtVideo) request.getAttribute("DT_VIDEO"); %>
	
		Nombre: <%= vid.nombre %>
		 <br>
		Canal: <%= vid.usuario %>
		 <br>
		Fecha: <%= vid.fecha %>
		 <br>
		Duracion: <%= vid.duracion %>
		 <br>
		Descripcion: <%= vid.descripcion %> 
		 <br>
		Categoria: <%= vid.categoria %>
		 <br>
		URL: <%= vid.Url %>
		 <br>
		Me gusta:  <%= vid.getCalificacionesPositivas()%> <!-- Falta listar quien hace las calificaciones -->
		<br>
		No me gusta:  <%= vid.getCalificacionesNegativas()%>
		<br>
		
		<!-- LA PARTE DE LOS COMENTARIOS -->
		
		Comentarios:
		
		<%! public void printComent(Map<Integer, DtComentario> comentarios, int tab){
			
			for(DtComentario comentario : comentarios.values() ){
				for(int i = 0; i < tab; i++){ %>
					 <t> x
				<%! } %>
				
				
				
				<%!				
				
				if(!comentario.hijos.isEmpty()){
					printComent(comentario.hijos,tab++);
				}
			}
		} %>
		
		<pre>
		<% printComent(vid.comentarios,0); %>		

		</pre>
		<!-- FIN LA PARTE DE LOS COMENTARIOS -->
		
	<form action="/index.jsp">
	<button>Volver</button>

</body>
</html>