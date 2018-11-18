<!doctype html>
<%@ page import = "servicios.*" %>
<%@ page import = "java.util.*" %>
<html lang="en">
<head>
	<jsp:include page="/WEB-INF/extras/head.jsp" />
	<title>UyTube - Consulta de categoria </title>
</head>
<body>
	<div class="page">
		<jsp:include page="/WEB-INF/extras/header.jsp" />
		<jsp:include page="/WEB-INF/extras/sidebar.jsp" />
		<div class="contenido">
			<% servicios.DtCategoria dtCat = (DtCategoria) request.getAttribute("CATEGORIA");%>
			<% List<DtVideo> videos = dtCat.getVideos(); %>
			<% List<DtLista> listas = dtCat.getListas(); %>
			<h1>Informacion de <%= "'" + dtCat.getNombre() + "'" %></h1>
			<br>
			<h2> Videos: </h2>
			<% if (videos.size() == 0) { %>
				<h6>No hay videos</h6>
			<% } else { %>
				<div class="highlights">
				<%for (DtVideo vid : videos) {%>
				<div class="detalleClickeableVideo"onclick="document.getElementById('Form<%=vid.getIdVideo()%>').submit();">	
					<form id="Form<%=vid.getIdVideo()%>" class="detClickeableVideo" action="ConsultaVideo" method="GET">
						<input type="hidden" name="VIDEO_ID" value="<%=vid.getIdVideo()%>">
						<img class="icon" width="30%" alt="DetalleVideo" src="<%=vid.getUrlThumbnail()%>">
						<header>
						<%= vid.getNombre() %>
						<br>
						User: <%= vid.getUsuario() %>
						</header>
					</form>	
				</div>
				<% } %>
				</div>
			<% } %>
				<br>
			<h2> Listas de reproduccion: </h2>
			<% if (listas.size() == 0) { %>
				<h6>No hay listas</h6>
			<% } else { %>
				<div class="highlights">
				<%for (DtLista lista : listas) {%>
				<div class="detalleClickeableLista" onclick="document.getElementById('Form<%=lista.getIdLista()%>').submit();">		
					<form id="Form<%=lista.getIdLista()%>" class="detClickeableLista" action="ConsultaLista" method="GET" >
						<input type="hidden" name="STATE" value="DETALLESLISTA">
						<input type="hidden" name="IDLISTA" value="<%= lista.getIdLista() %>">
						<img class="icon" width="30%" alt="Lista de reproduccion" src="img/playlist.png">
						<br>
						<header>
						<%= lista.getNombre() %>
						</header>
						User: <%= lista.getNombreOwner() %>
						<br>
					</form>	
				</div>
				<% } %>
				</div>
			<% } %>
				<br>
			<form action="ConsultaDeCategoria" method="GET">
				<button type="submit">Volver</button>
			</form>
		</div>
	</div>
<jsp:include page="/WEB-INF/extras/script.jsp" />
</body>
</html>
