<%@ page import="java.util.*"%>
<html>
<head>
<title>Prueba</title>
</head>
<body>
<br><br>
Informacion del navegador: <%= request.getHeader("User-agent") %>
<br>
ID de session: <%= request.getSession().getId() %>
</body>
</html>
