<%@page import="servicios.*" %>
<%@page import="utils.*" %>
<div class="row">
    <nav class="navbar navbar-expand-lg navbar-light bg-light" style="width:100%;">
    <% DtUsuario logueado = (DtUsuario) session.getAttribute("USUARIO_LOGEADO"); %>
	<a class="navbar-brand" href="Inicio" style="width:70%; float:left;"> <img class="logo" src="img/logo.png" height="30px" style="float:left;"> Hola <%= logueado.getNick() %></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar1" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbar1">
    <ul class="navbar-nav ml-auto"> 
<li class="nav-item">
<a class="nav-link" href="VideoServlet">Ver Videos <span class="sr-only">(current)</span></a>
</li>
<li class="nav-item"><a class="nav-link" href="ListaServlet"> Ver Listas </a></li>
<li class="nav-item">
<a class="btn ml-2 btn-warning" href="CerrarSesion">Cerrar Sesion</a></li>
    </ul>
  </div>
</nav>	
</div>