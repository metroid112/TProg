<%@ page import="java.util.*"%>
<%@ page import="clases.*"%>
<html>
<head>
<title>Prueba</title>
</head>
<body>
	<%= new Categoria("hola") %>
	<h1 align="center" style="color: red"> Index </h1>
	Sumas: <%= 5 + 6 %>
	<br>
	Boolean: <%= 2 * 5 > 11 %>
	<br>
	Fecha: <%= new Date() %>
	<br>
	<%
		for (int i = 0; i < 10; i++) {
			out.println("<br>" + i);
		}
	%>
	<%!
		private String s = "String1";
		public String getS() {
			return s;
		}
	%>
	<br>
	String: <%= getS() %>
	<br><br>
	Informacion del navegador: <%= request.getHeader("User-agent") %>
	<br>
	ID de session: <%= request.getSession().getId() %>
	<br><br>
	<a href="jsp/registro_usuarios.jsp"> Registrar Usuario </a>		<%-- para pasar a otra pagina --%>
</body>
</html>
