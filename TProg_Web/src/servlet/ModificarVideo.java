package servlet;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatypes.DtUsuario;
import datatypes.DtVideo;
import interfaces.Fabrica;
import interfaces.IVideos;
import utils.EstadoSesion;

/**
 * Servlet implementation class ModificarVideo
 */
@WebServlet("/ModificarVideo")
public class ModificarVideo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarVideo() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
      if ((request.getSession().getAttribute("USUARIO_LOGEADO") != null) && 
          (request.getSession().getAttribute("LOGIN").equals(EstadoSesion.LOGIN_CORRECTO))) {
        String usuario = ((DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO")).nick;
        IVideos ctrlVideos = Fabrica.getIVideos();
        List<DtVideo> listaVideos = ctrlVideos.getDtVideosPropietario(usuario);
        request.setAttribute("VIDEOS", listaVideos);
        request.getRequestDispatcher("/WEB-INF/pages/videos_propietario.jsp").forward(request,response);
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
