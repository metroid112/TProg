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
	switch((String) request.getAttribute("STATE")) {
	case "LISTAR":
		List<String> listaUsuarios = (LinkedList<String>) request.getAttribute("USUARIOS");
		if (listaUsuarios.isEmpty()) { %>
			<h1>No hay usuarios.</h1>
<% 		} else { %>
			<form action="/ConsultaUsuario" method="GET">
			<input type="hidden" name="STATE" value="INFO">
			<select class="form-control form-control-lg" name="usuario" required>
<% 			for (String usuario : listaUsuarios) { %>				
				<option value="<%= usuario %>"><%= usuario %></option>				
<% 			} %>
			</select>
			<button>Seleccionar</button>
			</form>
<%		}
		break;
	case "INFO":
  		DtUsuario usuario = (DtUsuario) request.getAttribute("USUARIO");
 		if (usuario == null) { %>
	  		<h1>Usuario <%= usuario.nick %> no existe</h1>
<%	  	} else { %>
  			<h1> INFO USUARIO </h1>
  			<h2> <%= usuario.nick %> </h2>
  			<br>
  			<img alt="<%= usuario.imgPath %>" src="<%= usuario.imgPath %>">
  			<br>
  			Nombre: <%= usuario.nombre + " " + usuario.apellido %>
  			<br>
			<form action="/ConsultaUsuario" method="GET">
				<input type="hidden" name="STATE" value="LISTAR">
				<button>Consultar otro usuario</button>
			</form>
<%		}
		break;
	default: %>
	  <h1>ERROR</h1>
<%	}
%>
<form action="/Inicio" method="GET">
	<button>Volver al inicio</button>
</form>
<jsp:include page="/WEB-INF/extras/script.jsp" />
</body>
</html>