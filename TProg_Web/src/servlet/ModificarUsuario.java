package servlet;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicios.DtCategoria;
import servicios.DtUniversal;
import servicios.DtUsuario;
import servicios.Publicador;
import servicios.PublicadorService;

@WebServlet("/ModificarUsuario")
public class ModificarUsuario extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ModificarUsuario() {
    super();
  }

  @SuppressWarnings("unchecked")
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    PublicadorService service = new PublicadorService();
    Publicador port = service.getPublicadorPort();
    switch((String) request.getParameter("STATE")) {
      case "LOAD":
        List<DtCategoria> categorias = (List<DtCategoria>) (List<?>) port.listarCategorias().getListaDt();
        request.setAttribute("CATEGORIAS", categorias);
        request.getRequestDispatcher("WEB-INF/pages/consulta_usurio.jsp").forward(request, response);
        break;
      case "MODIFICAR":
        break;
      default:
        response.sendRedirect("WEB-INF/error/error500.jsp");
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

}
