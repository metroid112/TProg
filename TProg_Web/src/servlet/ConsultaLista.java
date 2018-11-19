package servlet;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
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
import servicios.DtVideo;
import servicios.Historial;
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
      List<DtUniversal> listaUni = port.getListasPublicas().getListaDt();
      List<DtLista> lista = new LinkedList<DtLista>();
      for(DtUniversal universal :  listaUni){
        lista.add((DtLista )universal);
      }
      request.setAttribute("LISTAS", lista);
      
      if (request.getSession().getAttribute("LOGIN") != null
          && request.getSession().getAttribute("LOGIN").equals(EstadoSesion.LOGIN_CORRECTO)) {
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
      List<DtVideo> videos = dtLista.getDtVideos();
      request.setAttribute("DTLISTA", dtLista);
      boolean esHistorial = dtLista.getNombre().equals("Historial") && dtLista.getTipo().equals("Defecto");
      if (esHistorial) {
        class compareReproducciones implements Comparator<DtVideo> {
          private PublicadorService service1 = new PublicadorService();
            private Publicador port1 = service1.getPublicadorPort();
            
          @Override
          public int compare(DtVideo video1, DtVideo video2) {
              Historial historico1 = null;
              Historial historico2 = null;
              DtUsuario owner = (DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO");
              try {
                historico1 = (Historial) this.port1.historialVideo(video1.getIdVideo(), owner.getNick()).getContenido();
                historico2 = (Historial) this.port1.historialVideo(video2.getIdVideo(), owner.getNick()).getContenido();
              } catch (Exception e) {
                // TODO:
              }
              int repr1 = historico1.getReproducciones();
              int repr2 = historico2.getReproducciones();
              return repr1 > repr2 ? -1 : repr1 == repr2 ? 0 : 1;
          }
        }
        Collections.sort(videos, new compareReproducciones());
      }
      request.setAttribute("HISTORIAL", esHistorial);
      request.setAttribute("VIDEOS", videos);
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
