<%@ page import = "java.util.*" %>		<%-- Importo utils --%>
<html>

<head>

<title>Prueba</title>

</head>

<body>

	<h1 style= "text-align:center">Tests</h1>
	
	Sumas: <%= 5+6 %>
	<br>
	Boolean: <%= 2*5>11 %>
	<br>
	Fecha: <%= new Date() %>		<%-- Se crea una fecha y se despliega --%>
	<br>
	
	<%			// Codigo java 
	
		for (int i = 0; i < 10; i++) {
			out.println("<br>" + i);
		}
	
	%>	<%-- Termina el codigo java --%>
	
	<%!		// Con esto se pueden declarar variables y funciones
	
	private String s = "String1";
	
	public String getS() {
		
		/* out.println(s); No funciona el out aca*/
		return s;
	}
	
	%>
	
	<br>
	
	String: <%= getS() %>
	
	
</body>

</html>