package servlet;

import java.io.IOException;
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
    Boolean visibilidad; //= (Boolean) request.getParameter("visibilidad");
    if (request.getParameter("visibilidad").equals("Público")) {
      visibilidad = true;
    }
    else{
      visibilidad = false;
    }
      
    //String nickUsuario = ((DtUsuario) request.getSession().getAttribute("USUARIO_LOGUEADO")).;
    try{
      Fabrica.getIListas().altaListaParticular(nombreLista,nickUsuario,visibilidad);
    }
    catch (Exception e){
      request.setAttribute("ERROR", e.getMessage());
      
    }
    //si se creó la lista quiero hacer forward al index
      request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
    //si hubo un error al crear la lista, quiero hacer forward al alta lista, mostrando mensaje de error
      request.getRequestDispatcher("/jsp/alta_lista.jsp").forward(request, response);
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
