<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="datatypes.DtUsuario"%>
<br>
<ul>
	<%DtUsuario d = (DtUsuario)request.getSession().getAttribute("USUARIO_LOGEADO");%>
	<c:forEach var="com" items="${comentarios}" >
		<li>
			<div>
				${com.value.usuario}: ${com.value.texto} ${com.value.fecha}

				<%if(d!=null){ %>
					<form action="/ConsultaVideo" method="POST">
						<input type="text" name="COMENTAR">
						<input type="hidden" id="1" name="COMENTARIO_ID" value= ${ com.value.id} >
					<button type="submit">Comentar</button>
					</form>
				<% } %>
				<br>
				<c:if test="${com.value.tieneHijos()}">
					<c:set var="comentarios" value="${com.value.hijos}"  scope="request"/>
					<jsp:include page="comentarios.jsp" />
				</c:if>
			</div>
		</li>
	</c:forEach>
</ul>