package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatypes.DtLista;
import datatypes.DtUsuario;
import excepciones.NotFoundException;
import interfaces.Fabrica;
import interfaces.IListas;
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
   // IListas ctrlListas = Fabrica.getIListas();
    PublicadorService service = new PublicadorService();
    Publicador port = service.getPublicadorPort();  
    
    if (request.getParameter("STATE").equals("START")) {    
      
      request.setAttribute("LISTAS", port.getListasPublicas());
      if (request.getSession().getAttribute("LOGIN") != null
          && request.getSession().getAttribute("LOGIN").equals(EstadoSesion.LOGIN_CORRECTO)) {
        String usuario = ((DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO")).nick;
        request.setAttribute("LISTASPRIVADAS", port.getDtListasPrivadasUsuario(usuario));
        request.setAttribute("LISTASDEFECTO", port.getDtListasDefectoUsuario(usuario));
      }
      request.getRequestDispatcher("WEB-INF/pages/consulta_lista.jsp").forward(request, response);
    } else if (request.getParameter("STATE").equals("DETALLESLISTA")) {
      request.setAttribute("LISTAPUBLICA", request.getParameter("LISTAPUBLICA"));
      int idLista = Integer.parseInt((String) request.getParameter("IDLISTA"));
      DtLista dtLista = null;
      if (request.getParameter("NOMBRELISTADEFECTO") != null) { // LISTA DEFECTO
        dtLista = Fabrica.getIListas().getDtDefecto(((DtUsuario)request.getSession().getAttribute("USUARIO_LOGEADO")).nick,
            request.getParameter("NOMBRELISTADEFECTO"));
      } else {
        try {
          dtLista = Fabrica.getIListas().getDt(idLista);
        } catch (NotFoundException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
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
