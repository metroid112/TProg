<%@page import="servicios.*" %>
<%@page import="utils.*" %>
<!doctype html>
<html>
<head>
	 
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="media/bootstrap/css/bootstrap.min.css" media="screen">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- Latest compiled and minified JavaScript -->
	<link rel="stylesheet" href="media/bootstrap/js/bootstrap.min.js" media="screen">
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<title>UyTube - Login</title>
</head>
<body>
<!-- Logica para recordar la sesion -->
<%Cookie[] cookies=request.getCookies();
String name="",pass="";
if (cookies != null) {
     for (Cookie cookie : cookies) {
       if (cookie.getName().equals("cookieLoginUser")) {
           name=cookie.getValue();
       }
       if(cookie.getName().equals("cookieLoginPassword")){
           pass=cookie.getValue();
       }
    }
}
%>
<div class="container-fluid fill-height">
		<div class="h-100 row align-items-center">
			<div class="col-2">
			</div>
				<div class="col-8">
					<p>Iniciar Sesión					</p>
					<form class="login" action="login" method="POST">
					  <div class="form-group">
					    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Correo o nickname" name="nickname" value=<%=name%>>
					  </div>
					  <div class="form-group">
					    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Contraseña" name="pass"value=<%=pass%>>
					  </div>
					  <%
							if (request.getSession().getAttribute("LOGIN").equals(EstadoSesion.LOGIN_INCORRECTO)) { %>
								<p style="color:red">Usuario o password incorrectos</p>
						<%	}
				 		%>	
				 	<div class="checkbox">
      				<label> <input type="checkbox" name="recordarme"> Recordarme </label>
    				</div>
					  <input type="submit" class="btn btn-primary" value=Login>
					</form>
				</div>
			<div class="col-2">
			</div>
		</div>
</div>
    
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
</body>
</html>
