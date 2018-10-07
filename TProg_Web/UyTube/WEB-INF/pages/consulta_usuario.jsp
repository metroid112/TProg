<%@ page import="datatypes.*" %>
<%@ page import="java.util.*" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<jsp:include page="/WEB-INF/extras/head.jsp" />
</head>
<title>UyTube - Consulta Usuario</title>
</head>
<body>
<jsp:include page="/WEB-INF/extras/header.jsp" />
<%! @SuppressWarnings("unchecked") %>
<%
	if (request.getAttribute("STATE").equals("LISTAR")) {
		List<String> listaUsuarios = (LinkedList<String>) request.getAttribute("USUARIOS");
		if (listaUsuarios.isEmpty()) { %>
	  <h1>No hay usuarios.</h1>
<% 		} else { %>
	  <table class="table">
	  <thead>
	    <tr>
	      <th scope="col">Nick</th>
	    </tr>
	  </thead>
	  <tbody>
<% 			for (String usuario : listaUsuarios) { %>
		<tr>
		  <th scope="row"> 
			<form action="/ConsultaUsuario" method="GET">
			<input type="hidden" name="ID" value="<%= usuario %>">
			<button><%= usuario %></button>
			</form>
		  </th>
	    <tr>
<% 			} %>
	  </tbody>
	</table>
<% 		}
	} else {
	  
	}
%>
<form action="/Inicio" method="GET">
	<button>Volver</button>
</form>
<jsp:include page="/WEB-INF/extras/script.jsp" />
</body>
</html>