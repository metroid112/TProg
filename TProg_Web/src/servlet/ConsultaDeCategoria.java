package servlet;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

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
    PublicadorService service = new PublicadorService();
    Publicador port = service.getPublicadorPort();    
    if (request.getParameter("CATEGORIA") == null) {    
      List<String> listaCat = port.listarCategorias().getListaAux();
      request.setAttribute("CATEGORIAS", listaCat);
      request.getRequestDispatcher("/WEB-INF/pages/lista_categorias.jsp").forward(request,
          response);
    } else {
      String categoria = (String) request.getParameter("CATEGORIA");
      servicios.DtCategoria dtCat = (servicios.DtCategoria) port.consultaDeCategoria(categoria).getContenido();
      request.setAttribute("CATEGORIA", dtCat);
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
