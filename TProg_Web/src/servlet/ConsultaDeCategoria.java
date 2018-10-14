package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaces.Fabrica;
import interfaces.ICategorias;

/**
 * Servlet implementation class ListarCategorias
 */
@WebServlet("/ConsultaDeCategoria")
public class ConsultaDeCategoria extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public ConsultaDeCategoria() {
    super();
    // TODO Auto-generated constructor stub
  }

  private void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    if (request.getParameter("CATEGORIA") == null) {
      ICategorias ctrlCategorias = Fabrica.getICategorias();
      String[] listaCategorias = ctrlCategorias.listarCategorias();
      request.setAttribute("CATEGORIAS", listaCategorias);
      request.getRequestDispatcher("/WEB-INF/pages/lista_categorias.jsp").forward(request,
          response);
    } else {
      ICategorias ctrlCategorias = Fabrica.getICategorias();
      String categoria = request.getParameter("CATEGORIA");
      request.setAttribute("CATEGORIA", categoria);
      String[] informacionVideos = ctrlCategorias.getInfoVideos(categoria);
      request.setAttribute("INFO_VIDEOS", informacionVideos);
      String[] informacionListas = ctrlCategorias.getInfoListas(categoria);
      request.setAttribute("INFO_LISTAS", informacionListas);
      request.getRequestDispatcher("/WEB-INF/pages/consulta_categoria.jsp").forward(request,
          response);
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
