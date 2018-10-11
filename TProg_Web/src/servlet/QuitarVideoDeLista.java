package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatypes.DtUsuario;
import datatypes.DtVideo;
import excepciones.DuplicateClassException;
import excepciones.NotFoundException;
import interfaces.Fabrica;
import interfaces.IListas;
import manejadores.ManejadorVideos;

/**
 * Servlet implementation class AgregarVideoALista
 */
@WebServlet("/QuitarVideoDeLista")
public class QuitarVideoDeLista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuitarVideoDeLista() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
      IListas ctrlListas = Fabrica.getIListas();
      String lista = (String) request.getParameter("lista");
      String idVideo = (String) request.getParameter("video");
      Boolean defecto = false;
      if (request.getParameter("listapublica").equals("S")) {
        defecto = true;
      }
      DtVideo video = null;
      try {
        video = Fabrica.getIVideos().getDtVideo(Integer.parseInt(idVideo));
      } catch (NumberFormatException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (NotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }   
      String nombreVideo = video.nombre;
      String nombreOwnerVideo = video.usuario;
      String usuario = ((DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO")).nick;
      try {
        ctrlListas.quitarVideoLista(usuario, nombreVideo, nombreOwnerVideo, lista,
            defecto);
      }
      catch (Exception e) {
        e.printStackTrace();
      }
      request.getRequestDispatcher("/index.jsp").forward(request, response);
      
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