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

@WebServlet("/ConsultaDeCategoria")
public class ConsultaDeCategoria extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ConsultaDeCategoria() {
    super();
  }

  private void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    if (request.getParameter("CATEGORIA") == null) {
      PublicadorService service = new PublicadorService();
      Publicador port = service.getPublicadorPort();
      servicios.DtCategoria dtCat = (servicios.DtCategoria) port.listarCategorias().getContenido();
      request.setAttribute("CATEGORIAS", dtCat);
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
