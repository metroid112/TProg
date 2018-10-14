package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Calificacion;
import clases.Categoria;
import clases.Comentario;
import datatypes.DtCalificacion;
import datatypes.DtComentario;
import datatypes.DtUsuario;
import datatypes.DtVideo;
import excepciones.DuplicateClassException;
import excepciones.InvalidDataException;
import excepciones.NotFoundException;
import interfaces.Fabrica;
import interfaces.ICategorias;
import interfaces.IVideos;
import manejadores.ManejadorCategorias;
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
          DtUsuario user = (DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO");
          String nick = user.nick;
          String oldNombre = (String) request.getParameter("oldNombre");
          String nombreVideo = (String) request.getParameter("nombreVideo");
          String urlVideo = (String) request.getParameter("urlVideo");
          String visibilidad = (String) request.getParameter("visibilidad");
          String categoria = (String) request.getParameter("categoria");
          String descripcionVideo = (String) request.getParameter("descripcionVideo");
          Boolean visible = visibilidad.equals("Publico") ? true : false;
          String duracionH = request.getParameter("duracionH");
          String duracionM = request.getParameter("duracionM");
          String duracionS = request.getParameter("duracionS");
          Date fecha = new Date();
          try {
            fecha = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha"));
          } catch (ParseException exception) {
            exception.printStackTrace();
          }
          Duration duracion =
              Duration.parse("PT" + duracionH + "H" + duracionM + "M" + duracionS + "S");
          if (duracionH.equals("0") && duracionM.equals("0") && duracionS.equals("0")) {
            request.setAttribute("DURACION", "La duracion debe ser positiva.");  
            Categoria cat = ManejadorCategorias.getManejadorCategorias().get(categoria);
            Map<Integer, Comentario> comentarios = new LinkedHashMap<Integer, Comentario>();
            List<Calificacion> calificacion = new LinkedList<Calificacion>();     
            DtVideo videoTemp = new DtVideo(oldNombre, descripcionVideo, urlVideo, cat, fecha,
                duracion, visible, comentarios, calificacion, -1, nick);
            request.setAttribute("VIDEO", videoTemp);
            ICategorias ctrlCategorias = Fabrica.getICategorias();
            String[] listaCategorias = ctrlCategorias.listarCategorias();
            request.setAttribute("CATEGORIAS", listaCategorias);
            request.getRequestDispatcher("/WEB-INF/pages/modificar_video.jsp").forward(request, response);
          } else {
            try {
              Fabrica.getIVideos().modificarVideo(nick, oldNombre, nombreVideo, descripcionVideo, urlVideo, categoria, duracion, visible, fecha);
              request.setAttribute("EXITO", "�Se han modificados los datos del video con exito!");
              request.getRequestDispatcher("/WEB-INF/extras/exito.jsp").forward(request,response);
            } catch (InvalidDataException e) {
              request.setAttribute("PRIVACIDAD", "No se puede cambiar la visibilidad del video porque el canal es privado.");  
              Categoria cat = ManejadorCategorias.getManejadorCategorias().get(categoria);
              Map<Integer, Comentario> comentarios = new LinkedHashMap<Integer, Comentario>();
              List<Calificacion> calificacion = new LinkedList<Calificacion>();     
              DtVideo videoTemp = new DtVideo(oldNombre, descripcionVideo, urlVideo, cat, fecha,
                  duracion, visible, comentarios, calificacion, -1, nick);
              request.setAttribute("VIDEO", videoTemp);
              ICategorias ctrlCategorias = Fabrica.getICategorias();
              String[] listaCategorias = ctrlCategorias.listarCategorias();
              request.setAttribute("CATEGORIAS", listaCategorias);
              request.getRequestDispatcher("/WEB-INF/pages/modificar_video.jsp").forward(request, response);
              e.printStackTrace();
            } catch (DuplicateClassException f) {
              request.setAttribute("DUPLICADO", "El nombre " + nombreVideo + " ya existe, por favor elegir otro.");  
              Categoria cat = ManejadorCategorias.getManejadorCategorias().get(categoria);
              Map<Integer, Comentario> comentarios = new LinkedHashMap<Integer, Comentario>();
              List<Calificacion> calificacion = new LinkedList<Calificacion>();     
              DtVideo videoTemp = new DtVideo(oldNombre, descripcionVideo, urlVideo, cat, fecha,
                  duracion, visible, comentarios, calificacion, -1, nick);
              request.setAttribute("VIDEO", videoTemp);
              ICategorias ctrlCategorias = Fabrica.getICategorias();
              String[] listaCategorias = ctrlCategorias.listarCategorias();
              request.setAttribute("CATEGORIAS", listaCategorias);
              request.getRequestDispatcher("/WEB-INF/pages/modificar_video.jsp").forward(request, response);
            }
          }
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
