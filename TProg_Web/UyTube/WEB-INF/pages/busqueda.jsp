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
		<div class="contenido" align="center">
			<div>
				<form action="/Busqueda" method="get">
					<select name="TIPO_BUSQUEDA">
						<option value="TODOS">Todos</option>
						<option <c:if test="${param.TIPO_BUSQUEDA.equals('VIDEOS')}">selected</c:if> value="VIDEOS">Videos</option>
						<option <c:if test="${param.TIPO_BUSQUEDA.equals('LISTAS')}">selected</c:if> value="LISTAS">Listas</option>
						<option <c:if test="${param.TIPO_BUSQUEDA.equals('CANALES')}">selected</c:if> value="CANALES">Canales</option>
					</select>
					<select name="ORDEN_BUSQUEDA">
						<option selected hidden value="NORMAL">Orden de busqueda</option>
						<option <c:if test="${param.ORDEN_BUSQUEDA.equals('FECHA')}">selected</c:if> value="FECHA">Fecha: Descendente</option>
						<option <c:if test="${param.ORDEN_BUSQUEDA.equals('ALFABETICO')}">selected</c:if> value="ALFABETICO">Alfabeticamente: Descendente</option>
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
				<%for (DtVideo vid : videos) {%>
					<div><%= vid.nombre %></div>
					<br>
				<% } %>
			</c:if>
			
			<c:if test="${param.TIPO_BUSQUEDA.equals('TODOS') || param.TIPO_BUSQUEDA.equals('CANALES')}">
				<br>
				<h1>Canales</h1>
				<br>
				<%for (DtUsuario usuario : usuarios) {%>
					<div> <%= usuario.canal %></div>
					<br>
				<% } %>
			</c:if>
			<c:if test="${param.TIPO_BUSQUEDA.equals('TODOS') || param.TIPO_BUSQUEDA.equals('LISTAS')}">
				<br>
				<h1>Listas</h1>
				<br>
				<%for (DtLista lista : listas) {%>
					<div><%= lista.getNombre() %></div>
					<br>
				<% } %>
			</c:if>
		</div>
	</div>
</body>
</html>
