package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatypes.DtLista;
import datatypes.DtUsuario;
import datatypes.DtVideo;
import excepciones.DuplicateClassException;
import excepciones.NotFoundException;
import interfaces.Fabrica;
import interfaces.IListas;
import manejadores.ManejadorVideos;
import utils.EstadoSesion;

/**
 * Servlet implementation class AgregarVideoALista
 */
@WebServlet("/ConsultaLista")
public class ConsultaLista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaLista() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
      IListas ctrlListas = Fabrica.getIListas();
      if (request.getParameter("STATE").equals("START")) {
        //obtener las listas necesarias, todas las listas particulares.
        request.setAttribute("LISTAS", ctrlListas.getListasPublicas());
        if (request.getSession().getAttribute("LOGIN") != null && request.getSession().getAttribute("LOGIN").equals(EstadoSesion.LOGIN_CORRECTO)) { 
          String usuario = ((DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO")).nick;
          request.setAttribute("LISTASPRIVADAS", ctrlListas.getDtListasPrivadasUsuario(usuario));
        }
        request.getRequestDispatcher("WEB-INF/pages/consulta_lista.jsp").forward(request, response);
      } else if (request.getParameter("STATE").equals("DETALLESLISTA")) {
        //Boolean listaDefecto = true;
        request.setAttribute("LISTAPUBLICA", request.getParameter("LISTAPUBLICA"));
        //List<DtVideo> videosDeLista;
        int idLista = Integer.parseInt((String) request.getParameter("IDLISTA"));
        DtLista dtLista = null;
        try {
          dtLista = Fabrica.getIListas().getDt(idLista);
        } catch (NotFoundException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        request.setAttribute("DTLISTA", dtLista);
        request.getRequestDispatcher("/WEB-INF/pages/detalles_lista.jsp").forward(request, response);
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
