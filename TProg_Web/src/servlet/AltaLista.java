package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicios.DtUniversal;
import servicios.DtUsuario;
import servicios.Publicador;
import servicios.PublicadorService;
import utils.EstadoSesion;

@WebServlet("/AltaLista")
public class AltaLista extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public AltaLista() {
    super();
    // TODO Auto-generated constructor stub
  }

  private void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    PublicadorService service = new PublicadorService();
    Publicador port = service.getPublicadorPort(); 
    if ((request.getSession().getAttribute("USUARIO_LOGEADO") != null)
        && (request.getSession().getAttribute("LOGIN").equals(EstadoSesion.LOGIN_CORRECTO))) {
      String user = ((DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO")).getNick();
      DtUniversal dtUsu = port.getDtUsuario(user).getContenido();
      request.setAttribute("USUARIO", dtUsu);
      request.getRequestDispatcher("/WEB-INF/pages/alta_lista.jsp").forward(request, response);
    } else {
      response.sendRedirect("/Inicio");
    }
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
