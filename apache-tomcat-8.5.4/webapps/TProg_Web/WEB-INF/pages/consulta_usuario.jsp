<%@ page import="servicios.*, java.util.*, utils.*, java.text.*" %>
<!doctype html>
<html lang="es">
<head>
	<jsp:include page="/WEB-INF/extras/head.jsp" />
	<title>UyTube - Consulta Usuario</title>
</head>
<body>
<jsp:include page="/WEB-INF/extras/header.jsp" />
<div class="contenedor">
	<jsp:include page="/WEB-INF/extras/sidebar.jsp"/>
	<div class="contenido">
	<%! @SuppressWarnings("unchecked") %>
		<%
		switch((String) request.getAttribute("STATE")) {
			case "LISTAR":
				List<String> listaUsuarios = (List<String>) request.getAttribute("USUARIOS");
				if (listaUsuarios.isEmpty()) { %>
					<h1>No hay usuarios.</h1>
		 	 <% } else { %>
					<form action="ConsultaUsuario" method="GET">
						<input type="hidden" name="STATE" value="INFO">
						<select class="form-control form-control-lg" name="usuario" required>
             		 <% for (String usuario : listaUsuarios) { %>
							<option value="<%= usuario %>"><%= usuario %></option>
         				<% } %>
						</select>
						<button>Seleccionar</button>
					</form>
     <% }
			break;
		case "INFO":
		DtUsuario usuario = (DtUsuario) request.getAttribute("USUARIO");
  		List<DtVideo> videos = (List<DtVideo>) request.getAttribute("VIDEOS");
  		List<DtLista> listas = (List<DtLista>) request.getAttribute("LISTAS");
  		List<String> seguidores = (List<String>) request.getAttribute("SEGUIDORES");
  		List<String> seguidos = (List<String>) request.getAttribute("SEGUIDOS");
  		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
 			if (usuario == null) { %>
  			<h1>Usuario <%= usuario.getNick() %> no existe</h1>
     <%	} else { %>
  			<h1>INFO USUARIO</h1>
  			<h2><%= usuario.getNick() %></h2>
  			<div class="head-item" align="right">
  				<div class="thumbnail2">
  					<img alt="Imagen de <%= usuario.getNick() %>" src="/Img?id=<%= usuario.getIdImagen() %>">
  				</div>
  			</div>
  			<br>
  			Nombre: <%= usuario.getNombre() + " " + usuario.getApellido() %>
  			<br>
  			Fecha de nacimiento: <%= dateFormat.format(usuario.getFechaNacimiento().toGregorianCalendar().getTime()) %>
  			<br>
  			<h2>CANAL: <%= usuario.getCanal() %></h2>
  			Descripci�n: <%= usuario.getDescripcionCanal()%>
  			<br>
  			Categoria: <%= usuario.getCategoria() %>
  			<h3>VIDEOS PUBLICOS</h3>
     		<% for(DtVideo video : videos) { %>
  				<form action="ConsultaVideo" method="GET">
	  				<input name="VIDEO_ID" value="<%= video.getIdVideo() %>" type="hidden">
	  				<button><%= video.getNombre() %></button>
	  			</form>
	  			<br>
     		<% } %>
			<h3>LISTAS PUBLICAS</h3>
     		<%	for(DtLista lista : listas) { %>
					<form action="ConsultaLista" method="GET">
						<input name="STATE" value="DETALLESLISTA" type="hidden">
						<input name="IDLISTA" value="<%= lista.getIdLista() %>" type="hidden">
						<button><%= lista.getNombre() %></button>
					</form>
					<br>
     <%	} %>
				<h2>ESTADISTICAS</h2>
				Seguidores: <%= seguidores.size() %>
				<br>
     <%	for(String seguidor : seguidores) { %>
			 		<%= seguidor %>
				<br>
     <% } %>
			<br>
			Seguidos: <%= seguidos.size() %>
			<br>
   <% for(String seguido : seguidos) { %>
				<%= seguido %>
				<br>
   <% } %>
   <% if(session.getAttribute("LOGIN") != null && session.getAttribute("LOGIN").equals(EstadoSesion.LOGIN_CORRECTO)) {
				DtUsuario usuarioLogueado = (DtUsuario) session.getAttribute("USUARIO_LOGEADO");
				if(usuarioLogueado.getNick().equals(usuario.getNick())) { %>
				  	<form action="ModificarUsuario" method="GET">
				  		<input name="STATE" value="LOAD" type="hidden">
				  		<button>Modificar Usuario</button>
				  	</form>
     <% } else { %>
     			<%
     			boolean sigue = (boolean) request.getAttribute("SIGUE");
     			String textoSeguir = sigue ? "Dejar de seguir" : "Seguir";
     			String metodoSeguir = sigue ? "DEJAR_SEGUIR" : "SEGUIR";
     			%>
			  	<form action="Seguidores" method="GET">
			  		<input name="ACCION" value="<%= metodoSeguir %>" type="hidden">
			  		<input name="USUARIO_SEGUIDO" value="<%= usuario.getNick() %>" type="hidden">
			  		<input name="USUARIO_SEGUIDOR" value="<%= usuarioLogueado.getNick()%>" type="hidden">
			  		<button><%= textoSeguir %></button>
				</form>
     <%	}
 			} %>
 <% }
		break;
	default: %>
	  <h1>ERROR</h1>
<%} %>
	</div>
</div>
<jsp:include page="/WEB-INF/extras/script.jsp" />
</body>
</html>