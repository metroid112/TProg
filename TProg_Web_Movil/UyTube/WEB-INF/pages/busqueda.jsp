<%@ page import="datatypes.*" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/WEB-INF/extras/head.jsp"></jsp:include>
	<title>UyTube - Busqueda</title>
</head>
<body>
	<jsp:include page="/WEB-INF/extras/header.jsp"></jsp:include>
	<div class="contenedor">
		<jsp:include page="/WEB-INF/extras/sidebar.jsp" />
		<div class="contenido">
			<div>
				<form action="Busqueda" method="post">
					<select name="TIPO_BUSQUEDA">
						<option value="TODOS">Todos</option>
						<option <c:if test="${param.TIPO_BUSQUEDA.equals('VIDEOS')}">selected</c:if> value="VIDEOS">Videos</option>
						<option <c:if test="${param.TIPO_BUSQUEDA.equals('LISTAS')}">selected</c:if> value="LISTAS">Listas</option>
						<option <c:if test="${param.TIPO_BUSQUEDA.equals('CANALES')}">selected</c:if> value="CANALES">Canales</option>
					</select>
					<select name="ORDEN_BUSQUEDA">
						<option selected hidden value="NORMAL">Orden de busqueda</option>
						<option <c:if test="${param.ORDEN_BUSQUEDA.equals('FECHA')}">selected</c:if> value="FECHA">Fecha: Descendente</option>
						<option <c:if test="${param.ORDEN_BUSQUEDA.equals('ALFABETICO')}">selected</c:if> value="ALFABETICO">Alfabeticamente: Ascendente</option>
					</select>
					<input type="hidden" value="${param.txtBusqueda}" name="txtBusqueda">
					<button type="submit">Filtrar</button>
				</form>
			</div>
			<%
			DtBusqueda resultados = (DtBusqueda) request.getAttribute("RESULTADO_BUSQUEDA");
			List<DtLista> listas = resultados.listas;
			List<DtUsuario> usuarios = resultados.usuarios;
			List<DtVideo> videos = resultados.videos;
			int cantResultados = listas.size() + usuarios.size() + videos.size();
			%>
			<h3><%= cantResultados %> resultados para <%= request.getParameter("txtBusqueda") %></h3>
			<c:if test="${param.TIPO_BUSQUEDA.equals('TODOS') || param.TIPO_BUSQUEDA.equals('VIDEOS')}">	
				<br>
				<h1>Videos</h1>
				<br>
				<div class="highlights">
				<%for (DtVideo vid : videos) {%>
				<div class="detalleClickeableVideo"onclick="document.getElementById('Form<%=vid.idVideo%>').submit();">	
					<form id="Form<%=vid.idVideo%>" class="detClickeableVideo" action="ConsultaVideo" method="GET">
						<input type="hidden" name="VIDEO_ID" value="<%=vid.idVideo%>">
						<img class="icon" width="30%" alt="DetalleVideo" src="<%=vid.urlThumbnail%>">
						<header>
						<%= vid.nombre %>
						<br>
						User: <%= vid.usuario %>
						</header>
					</form>	
				</div>
				<% } %>
				</div>
			</c:if>
			
			<c:if test="${param.TIPO_BUSQUEDA.equals('TODOS') || param.TIPO_BUSQUEDA.equals('CANALES')}">
				<br>
				<h1>Canales</h1>
				<br>
				<div class="highlights">
				<%for (DtUsuario usuario : usuarios) {%>
					<div class="detalleClickeableUsuario" onclick="document.getElementById('Form<%=usuario.nick%>').submit();">		
					<form id="Form<%= usuario.nick %>" class="detClickeableUsuario" action="ConsultaUsuario" method="POST" >
						<input type="hidden" name="STATE" value="INFO">
						<input type="hidden" name="usuario" value="<%= usuario.nick %>">
						<div class="thumbnail">
							<img class="icon" width="30%" alt="Lista de reproduccion" src="<%= usuario.imgPath %>">
						</div>
						<br>
						<header>
						<%= usuario.canal %>
						</header>
						<br>
					</form>	
				</div>
				<% } %>
				</div>
			</c:if>
			<c:if test="${param.TIPO_BUSQUEDA.equals('TODOS') || param.TIPO_BUSQUEDA.equals('LISTAS')}">
				<br>
				<h1>Listas</h1>
				<br>
				<div class="highlights">
				<%for (DtLista lista : listas) {%>
				<div class="detalleClickeableLista" onclick="document.getElementById('Form<%=lista.getId()%>').submit();">		
					<form id="Form<%=lista.getId()%>" class="detClickeableLista" action="ConsultaLista" method="GET" >
						<input type="hidden" name="STATE" value="DETALLESLISTA">
						<input type="hidden" name="IDLISTA" value="<%= lista.getId() %>">
						<img class="icon" width="30%" alt="Lista de reproduccion" src="img/playlist.png">
						<br>
						<header>
						<%= lista.getNombre() %>
						</header>
						<br>
					</form>	
				</div>
				<% } %>
				</div>
			</c:if>
		</div>
	</div>
	<jsp:include page="/WEB-INF/extras/script.jsp" />
</body>
</html>
