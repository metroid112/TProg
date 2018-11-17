package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicios.DtUsuario;
import servicios.Publicador;
import servicios.PublicadorService;
import utils.EstadoSesion;

@WebServlet("/CerrarSesion")
public class CerrarSesion extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public CerrarSesion() {
    super();
  }

  private void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {        
    request.getSession().setAttribute("LOGIN", EstadoSesion.NO_LOGIN);
      request.getSession().setAttribute("USUARIO_LOGEADO", null);
      response.sendRedirect("Inicio");
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response); 
    }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
        processRequest(request, response); 
  }

}