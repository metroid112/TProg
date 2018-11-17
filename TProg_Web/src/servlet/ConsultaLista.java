package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicios.DtLista;
import servicios.DtUsuario;
import excepciones.NotFoundException;
//import interfaces.Fabrica;
//import interfaces.IListas;
import servicios.Publicador;
import servicios.PublicadorService;
import utils.EstadoSesion;

@WebServlet("/ConsultaLista")
public class ConsultaLista extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ConsultaLista() {
    super();
  }

  private void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    PublicadorService service = new PublicadorService();
    Publicador port = service.getPublicadorPort();  
    
    if (request.getParameter("STATE").equals("START")) {    
      
      request.setAttribute("LISTAS", port.getListasPublicas().getListaDt());
      /**
       * getListaAux() devuelve un List<String> pero el tema es que en el publicador seteaste la listaDt del 
       * paquete con una List<DtUniversal>.
       * Deberias usar el getListaDt(). 
       * Eso te va a devolver algo del tipo List<DtUniversal>, luego tenes que crear una List<DtLista> y meter todos los elementos
       * de la lista universal. Esa List<DtLista> es la que vas a pasarle al jsp.
       * 
       * 
       */
      
      if (request.getSession().getAttribute("LOGIN") != null
          && request.getSession().getAttribute("LOGIN").equals(EstadoSesion.LOGIN_CORRECTO)) {
        String usuario = ((DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO")).getNick();
        request.setAttribute("LISTASPRIVADAS", port.getDtListasPrivadasUsuario(usuario).getListaDt());
        request.setAttribute("LISTASDEFECTO", port.getDtListasDefectoUsuario(usuario).getListaDt());
        /**
         * Aca te pasa lo mismo que antes: usas el get equivocado y te esta devolviendo null.
         */
      }
      request.getRequestDispatcher("WEB-INF/pages/consulta_lista.jsp").forward(request, response);
    } else if (request.getParameter("STATE").equals("DETALLESLISTA")) {
      request.setAttribute("LISTAPUBLICA", request.getParameter("LISTAPUBLICA"));  // No entiendo, donde se setea el parametro "LISTAPUBLICA"?
      int idLista = Integer.parseInt((String) request.getParameter("IDLISTA"));
      servicios.DtLista dtLista = null;
      if (request.getParameter("NOMBRELISTADEFECTO") != null) { // LISTA DEFECTO
        dtLista = (DtLista) port.getDtDefecto(((DtUsuario)request.getSession().getAttribute("USUARIO_LOGEADO")).getNick(),
            request.getParameter("NOMBRELISTADEFECTO")).getContenido();
      } else {
          dtLista = (DtLista) port.getDtLista(idLista).getContenido();
      }
      request.setAttribute("DTLISTA", dtLista);
      request.getRequestDispatcher("WEB-INF/pages/detalles_lista.jsp").forward(request, response);
    } else {
      request.getRequestDispatcher("/index.jsp").forward(request, response);
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
