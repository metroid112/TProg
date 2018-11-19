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
import interfaces.IUsuariosCanales;
import servicios.DtLista;
import servicios.DtUniversal;
import servicios.DtUsuario;
import servicios.DtVideo;
import servicios.Publicador;
import servicios.PublicadorService;
import utils.EstadoSesion;

@WebServlet("/ListaServlet")
public class ListaServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ListaServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    PublicadorService service = new PublicadorService();
    Publicador port = service.getPublicadorPort();  
    
    if (request.getSession().getAttribute("LOGIN") != null
        && request.getSession().getAttribute("LOGIN").equals(EstadoSesion.LOGIN_CORRECTO) && 
          (request.getParameter("STATE") == null || !request.getParameter("STATE").equals("DETALLESLISTA"))) {
      List<DtUniversal> listaUni = port.getListasPublicas().getListaDt();
      List<DtLista> lista = new LinkedList<DtLista>();
      for(DtUniversal universal :  listaUni){
        lista.add((DtLista)universal);
      }
      request.setAttribute("LISTAS", lista);
      
        String usuario = ((DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO")).getNick();
        
        List<DtUniversal> listaPrivUni = port.getDtListasPrivadasUsuario(usuario).getListaDt();
        List<DtLista> listaPriv = new LinkedList<DtLista>();
        for(DtUniversal universal :  listaPrivUni){
          listaPriv.add((DtLista)universal);
        }
        request.setAttribute("LISTASPRIVADAS", listaPriv);
        
        List<DtUniversal> listaDefeUni = port.getDtListasDefectoUsuario(usuario).getListaDt();
        List<DtLista> listaDefect = new LinkedList<DtLista>();
        for(DtUniversal universal :  listaDefeUni){
          listaDefect.add((DtLista )universal);
        }
        request.setAttribute("LISTASDEFECTO", listaDefect);

      
      request.getRequestDispatcher("WEB-INF/pages/listar_listas.jsp").forward(request, response);
    } else if (request.getParameter("STATE") != null && request.getParameter("STATE").equals("DETALLESLISTA")) {
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
      response.sendRedirect("Inicio");
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

}