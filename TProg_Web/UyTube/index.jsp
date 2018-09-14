<%@ page import = "java.util.*" %>		<%-- Importo utils --%>
<html>
<head>
<title>Prueba</title>
</head>
	<style>
		body {
			background-color: blue;
			background-image: url("C://Users//joaco//OneDrive//Escritorio//GIT//TProg//TProg_Workstation//img//pacheco.JPG");
		}
	</style>
<body>
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
</body>
</html>
