<%-- 
    Document   : jugar
    Author     : Igui
--%>
<%@page import="com.gamebook.model.Usuario"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="/WEB-INF/errorPages/500.jsp" %>
<!doctype html>
<html>
   <head>
	   <jsp:include page="/WEB-INF/template/head.jsp"/>
	<title>Usuarios :: gamebook</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/template/header.jsp"/>

		<div class="main">
			<object height="400" width="600">
				<param name="movie" value="/media/games/pacman.swf"/>
				<embed src="/media/games/pacman.swf" type="application/x-shockwave-flash" height="500" width="600"/>
			</object>
			
			<div>
				<h2>Como jugar</h2>
				<p>Usá las flechas</p>
			</div>
		</div>
		    
		<jsp:include page="/WEB-INF/template/footer.jsp"/>
</body>
</html>