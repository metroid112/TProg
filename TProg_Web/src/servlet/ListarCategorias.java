package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaces.Fabrica;
import interfaces.ICategorias;
import servicios.Publicador;
import servicios.PublicadorService;

@WebServlet("/ListarCategorias")
public class ListarCategorias extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ListarCategorias() {
    super();
    // TODO Auto-generated constructor stub
  }

  private void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    servicios.DtCategoria resultados = null;
    PublicadorService service = new PublicadorService();
    Publicador port = service.getPublicadorPort();
    ICategorias ctrlCategorias = Fabrica.getICategorias();
    String[] listaCategorias = ctrlCategorias.listarCategorias();
    request.setAttribute("CATEGORIAS", listaCategorias);
    request.getRequestDispatcher("/WEB-INF/pages/lista_categorias.jsp").forward(request, response);
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
