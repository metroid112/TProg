package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaces.Fabrica;

/**
 * Servlet implementation class Seguidores
 */
@WebServlet("/Seguidores")
public class Seguidores extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public Seguidores() {
    super();
    // TODO Auto-generated constructor stub
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
    if (request.getParameter("ACCION").equals("SEGUIR")) {
      String seguidor = request.getParameter("USUARIO_LOGEADO");
      String seguido = request.getParameter("USUARIO_SEGUIDO"); // TODO chequear el usuario al que
                                                                // se va a seguir
      Fabrica.getIUsuariosCanales().seguir(seguidor, seguido);
      // TODO forward
    } else if (request.getParameter("ACCION").equals("DEJAR_SEGUIR")) {
      String seguidor = request.getParameter("USUARIO_LOGEADO");
      String seguido = request.getParameter("USUARIO_SEGUIDO"); // TODO chequear el usuario al que
                                                                // se va a seguir
      Fabrica.getIUsuariosCanales().dejarSeguir(seguidor, seguido);
      // TODO forward
    } // TODO else excepccion

  }

}
