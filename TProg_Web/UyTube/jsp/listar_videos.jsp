<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<title>UyTube - Lista de Videos</title>
</head>
<body>
	<h1>Videos Publicos:</h1>
	<br>

	<h2>Videos del usuario:</h2>
	<br>
		<% for (String v : (String[]) request.getAttribute("VIDEOS_USUARIO")) { %>
		<%= v %> 
		<br>
	<% } %>
</body>
</