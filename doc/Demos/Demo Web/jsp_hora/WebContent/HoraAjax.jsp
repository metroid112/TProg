<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Hora Ajax!</title>
	<script src="js/jquery-1.6.2.min.js" type="text/javascript"></script>	
</head>
<body>
    <script>
        function getHora(){
			$.ajax({
			   type: "GET",
			   url: "index.jsp",
			   success: function(msg){
				 $('#elemento_hora').html(msg);
				}
			 });
        }            
    </script>

    <p id="elemento_hora">Hacé click abajo</p>
    <input type="button" value="Obtener hora" onclick="getHora();">
</body>
</html>