<%@page import="datatypes.DtVideo"%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<title>UyTube - Consulta Video</title>
</head>
<body>

	 <% DtVideo vid = (DtVideo) request.getAttribute("videoo"); %> 
	
		Nombre: lala <%= vid.nombre %>
		 <br>
		Canal: juancito 
		 <br>
		Fecha: 1/1/98 
		 <br>
		Duracion: 1:14
		 <br>
		Descripcion: no esta bueno <%= vid.descripcion %>
		 <br>
		Categoria: arboles
		 <br>
		URL: AlhJsZ1EBIU <%= vid.Url %>
		 <br>
		Me gusta: 5
		<br>
		No me gusta: 3
		<br>
		
		<!-- LA PARTE DE LOS COMENTARIOS -->
		
		Comentarios:
		<pre>
		
		Comentario 1
		 <br>
			Comentario 1.1
		<br>
			Comentario 1.2
		<br>
				Comentario 1.2.1
		<br>
		Comentario 2
		<br>
		</pre>
		<!-- FIN LA PARTE DE LOS COMENTARIOS -->
		
	<form action="/index.jsp">
	<button>Volver</button>

</body>
</html>