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
import excepciones.NotFoundException;
import interfaces.Fabrica;
import interfaces.ICategorias;
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
        IVideos ctrlVideos = Fabrica.getIVideos();
        if (request.getParameter("videoSeleccionado") != null) {
          String idVideo = (String) request.getParameter("video");
          try {
            DtVideo video = ctrlVideos.getDtVideo(Integer.parseInt(idVideo));
            request.setAttribute("VIDEO", video);
            ICategorias ctrlCategorias = Fabrica.getICategorias();
            String[] listaCategorias = ctrlCategorias.listarCategorias();
            request.setAttribute("CATEGORIAS", listaCategorias);
            request.getRequestDispatcher("/WEB-INF/pages/modificar_video.jsp").forward(request, response);
          } catch (NumberFormatException e) {
            e.printStackTrace();
          } catch (NotFoundException e) {
            e.printStackTrace();
          }
          
        } else if (request.getParameter("modificar") != null) {
          String nick = (String) request.getSession().getAttribute("USUARIO_LOGEADO").
          String oldNombre = (String) request.getParameter("oldnombre");
          String nombreVideo = (String) request.getParameter("nombreVideo");
          String urlVideo = (String) request.getParameter("urlVideo");
          String visibilidad = (String) request.getParameter("visibilidad");
          String categoria = (String) request.getParameter("categoria");
          String descripcionVideo = (String) request.getParameter("descripcionVideo");
          Boolean visible = visibilidad.equals("Publico") ? true : false;
          Fabrica.getIVideos().modificarVideo(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
          
        } else {
          String usuario = ((DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO")).nick;
          List<DtVideo> listaVideos = ctrlVideos.getDtVideosPropietario(usuario);
          request.setAttribute("VIDEOS", listaVideos);
          request.getRequestDispatcher("/WEB-INF/pages/videos_propietario.jsp").forward(request,response);
        }

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
