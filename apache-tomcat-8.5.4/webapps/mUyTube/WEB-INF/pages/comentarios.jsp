<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="servicios.DtUsuario"%>
<%@ page import="servicios.DtVideo"%>
<br>
<ul>
	<% DtUsuario d = (DtUsuario)request.getSession().getAttribute("USUARIO_LOGEADO"); %>
	<% DtVideo vid = (DtVideo) request.getAttribute("DT_VIDEO"); %>
	<c:forEach var="com" items="${comentarios}" >
		<li>
			<div>
				<b>${com.usuario}</b>: ${com.texto} (<f:formatDate value="${com.fecha.toGregorianCalendar().getTime()}" pattern="dd-MM-yyyy HH:mm"/>)
				<%if(d!=null){ %>
					<form action="ConsultaVideo" method="POST">
						<input type="hidden" name="ACCION" value="COMENTAR">
						<input type="text" class="form-control" name="COMENTARIO">
						<input type="hidden" id="1" name="VIDEO_ID" value= "<%= vid.getIdVideo() %>" >
						<input type="hidden" id="2" name="COMENTARIO_ID" value= "${com.getIdComentario()}" >
					<button type="submit" class="btn btn-default btn-round-sm btn-sm" style="border-radius: 15px;">Comentar</button>
					</form>
				<% } %>
				<c:if test="${com.isTieneHijos()}">
					<c:set var="comentarios" value="${com.getHijos()}"  scope="request"/>
					<jsp:include page="comentarios.jsp" />
				</c:if>
			</div>
		</li>
	</c:forEach>
</ul>