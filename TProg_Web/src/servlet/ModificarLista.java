package servlet;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicios.DtLista;
import servicios.DtUniversal;
import servicios.DtUsuario;
import servicios.Publicador;
import servicios.PublicadorService;
import utils.EstadoSesion;

@WebServlet("/ModificarLista")
public class ModificarLista extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ModificarLista() {
    super();
  }

  private void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    PublicadorService service = new PublicadorService();
    Publicador port = service.getPublicadorPort();  
    if ((request.getSession().getAttribute("USUARIO_LOGEADO") != null) 
        && (request.getSession().getAttribute("LOGIN").equals(EstadoSesion.LOGIN_CORRECTO)) 
        && (request.getParameter("modificarLista") != null)) {
      String usuario = ((DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO")).getNick();
      String idLista = (String) request.getParameter("lista");
      try {
        DtUniversal listaUniversal = port.getDt(Integer.parseInt(idLista)).getContenido();
        DtLista lista = (DtLista) listaUniversal;
        Boolean visibilidad = !(lista.isVisible());
        port.guardarCambios(lista.getNombre(), usuario, visibilidad);
        request.setAttribute("EXITO",
            "Se ha modificado la visibilidad de la lista seleccionada con exito.");
        request.getRequestDispatcher("/WEB-INF/extras/exito.jsp").forward(request, response);
      } catch (NumberFormatException e) {
        e.printStackTrace();
      }
    } else if ((request.getSession().getAttribute("USUARIO_LOGEADO") != null) 
        && (request.getSession().getAttribute("LOGIN").equals(EstadoSesion.LOGIN_CORRECTO))) {
      String usuario = ((DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO")).getNick();
      List<DtUniversal> listaUniversal = port.getDtListasParticularesUsuario(usuario).getListaDt();
      List<DtLista> listaDtListas = new LinkedList<DtLista>();
      for (DtUniversal dtUniversal : listaUniversal) {
        DtLista dtLista = (DtLista) dtUniversal;
        listaDtListas.add(dtLista);
      }
      request.setAttribute("LISTAS", listaDtListas);
      request.setAttribute("USUARIO", usuario);
      request.getRequestDispatcher("/WEB-INF/pages/modificar_lista.jsp").forward(request, response);
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
