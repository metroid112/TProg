package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicios.Publicador;
import servicios.PublicadorService;

@WebServlet("/Seguidores")
public class Seguidores extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public Seguidores() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
  }

  private void processRequest(HttpServletRequest request, HttpServletResponse response) {
    PublicadorService service = new PublicadorService();
    Publicador port = service.getPublicadorPort();
    if (request.getParameter("ACCION").equals("SEGUIR")) {
      String seguidor = request.getParameter("USUARIO_SEGUIDOR");
      String seguido = request.getParameter("USUARIO_SEGUIDO");
      port.seguir(seguidor, seguido);
      try {
        response.sendRedirect("Inicio");
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else if (request.getParameter("ACCION").equals("DEJAR_SEGUIR")) {
      String seguidor = request.getParameter("USUARIO_SEGUIDOR");
      String seguido = request.getParameter("USUARIO_SEGUIDO");
      port.dejarSeguir(seguidor, seguido);
      try {
        response.sendRedirect("Inicio");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

  }

}
