package servlet;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatypes.DtUsuario;
import interfaces.Fabrica;

@WebServlet("/ListaServlet")
public class ListaServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ListaServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  private void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String nombreLista = (String) request.getParameter("nombreLista");
    Boolean visibilidad;
    if (request.getParameter("visibilidad").equals("Público")) {
      visibilidad = true;
    } else {
      visibilidad = false;
    }
    String nickUsuario = ((DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO")).nick;
    try {
      Fabrica.getIListas().altaListaParticular(nombreLista, nickUsuario, visibilidad);
      // response.setHeader("Refresh", "10; URL=http://www.google.com/%22)
      request.getRequestDispatcher("/jsp/alta_lista_exito.jsp").forward(request, response);
    } catch (Exception e) {
      request.setAttribute("ERROR", e.getMessage());
      request.getRequestDispatcher("/jsp/alta_lista.jsp").forward(request, response);
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
