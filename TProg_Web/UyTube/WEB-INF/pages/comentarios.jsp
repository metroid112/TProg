<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<br>
<ul>
	<c:forEach var="com" items="${comentarios}" >
		<li>
			${com.value.texto}
			<br>
			<c:if test="${com.value.tieneHijos()}">
				<c:set var="comentarios" value="${com.value.hijos}"  scope="request"/>
				<jsp:include page="comentarios.jsp" />
			</c:if>		
		</li>
	</c:forEach>
</ul>