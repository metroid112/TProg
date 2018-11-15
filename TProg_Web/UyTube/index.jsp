<!doctype html>
<html>
<head>
	<jsp:include page="WEB-INF/extras/head.jsp" />
	<title>UyTube - Index</title>
</head>
<body>
	<div class="page">
		<jsp:include page="WEB-INF/extras/header.jsp" />
		<div class="contenedor">
			<jsp:include page="WEB-INF/extras/sidebar.jsp" />
			<div class="contenido">
				<input type="text" id="texto">
				<button id="boton1">test</button>
				<div id="texto1">hola</div>
				
			</div>
			
				
		</div>
		<jsp:include page="WEB-INF/extras/script.jsp" />
		
		<script type="text/javascript">
		$(document).ready(function() {
			$("#texto").keyup(function() {
				var txt = $("#texto").val();
				$.get("AjaxServlet", {
					texto : txt
				}, function (respuesta) {
					$("#texto1").text(respuesta);
				});
			});
		});
		</script>
		
	</div>	
</body>
</html>
