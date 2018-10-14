<!doctype html>
<html lang="en">
<head>
	<jsp:include page="/WEB-INF/extras/head.jsp" />
	<title>UyTube - Alta Lista</title>
</head>
<body>
	<div class="page">
		<jsp:include page="/WEB-INF/extras/header.jsp" />
		<jsp:include page="/WEB-INF/extras/sidebar.jsp" />
		<div class="contenido">
			<div class="wrap-contact3">
				<form class="contact3-form validate-form" action="/ListaServlet" method="POST" id="formListaServlet">
					<span class="contact3-form-title">
					Alta lista particular
					</span>
					<div class="wrap-contact3-form-radio">
						<div class="contact3-form-radio m-r-42">
							<input class="input-radio3" id="radio1" type="radio" name="visibilidad" value="Privado" checked="checked">
							<label class="label-radio3" for="radio1">
							Privado
							</label>
						</div>
						<div class="contact3-form-radio">
							<input class="input-radio3" id="radio2" type="radio" name="visibilidad" value="Público">
							<label class="label-radio3" for="radio2">
							Público
							</label>
						</div>
					</div>
					<div class="wrap-input3 validate-input" data-validate="El nombre es obligatorio">
						<input class="input3" type="text" name="nombreLista" placeholder="Nombre de la lista" required>
						<span class="focus-input3"></span>
					</div>
					<div class="container-contact3-form-btn">
						<button class="contact3-form-btn">
							Aceptar
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
<jsp:include page="/WEB-INF/extras/script.jsp" />
</body>
</html>