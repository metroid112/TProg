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
	List<DtUsuario> listaUsuarios = (LinkedList<DtUsuario>) request.getAttribute("USUARIOS");
	if (listaUsuarios.isEmpty()) { %>
	  <h1>No hay usuarios.</h1>
<% } else { %>
	  <table class="table">
	  <thead>
	    <tr>
	      <th scope="col">Nick</th>
	    </tr>
	  </thead>
	  <tbody>
<% for (DtUsuario usuario : listaUsuarios) { %>
		<tr>
		  <th scope="row"> 
			<form action="/ConsultaUsuario" method="GET">
			<input type="hidden" name="ID" value="<%= usuario.nick %>">
			<button><%= usuario.nick %></button>
			</form>
		  </th>
	    <tr>
<% } %>
	  </tbody>
	</table>
<% 	}
%>
<jsp:include page="/WEB-INF/extras/script.jsp" />
</body>
</html>