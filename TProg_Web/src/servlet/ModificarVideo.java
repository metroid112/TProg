package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import servicios.DtUniversal;
import servicios.DtUsuario;
import servicios.DtVideo;
import servicios.Publicador;
import servicios.PublicadorService;
import excepciones.DuplicateClassException;
import excepciones.InvalidDataException;
import excepciones.NotFoundException;
import utils.EstadoSesion;

@WebServlet("/ModificarVideo")
public class ModificarVideo extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ModificarVideo() {
    super();
  }

  private void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    if ((request.getSession().getAttribute("USUARIO_LOGEADO") != null) 
        && (request.getSession().getAttribute("LOGIN").equals(EstadoSesion.LOGIN_CORRECTO))) {
      //IVideos ctrlVideos = Fabrica.getIVideos();
      PublicadorService service = new PublicadorService();
      Publicador port = service.getPublicadorPort();
      if (request.getParameter("videoSeleccionado") != null) {
        String idVideo = (String) request.getParameter("video");
        try {
          DtVideo video = (DtVideo) port.getDtVideo(Integer.parseInt(idVideo)).getContenido();
          request.setAttribute("VIDEO", video);
          List<String> listaCategorias = port.listarCategorias().getListaAux();
          request.setAttribute("CATEGORIAS", listaCategorias);
          request.getRequestDispatcher("/WEB-INF/pages/modificar_video.jsp").forward(request,
              response);
        } catch (NumberFormatException e) {
          e.printStackTrace();
        }

      } else if (request.getParameter("modificar") != null) {
        DtUsuario user = (DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO");
        String nick = user.getNick();
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
          /**
           * AJAX
           */
            response.sendRedirect("Inicio");
//          request.setAttribute("DURACION", "La duracion debe ser positiva.");
//          Categoria cat = ManejadorCategorias.getManejadorCategorias().get(categoria);
//          Map<Integer, Comentario> comentarios = new LinkedHashMap<Integer, Comentario>();
//          List<Calificacion> calificacion = new LinkedList<Calificacion>();
//          DtVideo videoTemp = new DtVideo(oldNombre, descripcionVideo, urlVideo, cat, fecha,
//              duracion, visible, comentarios, calificacion, -1, nick);
//          request.setAttribute("VIDEO", videoTemp);
//          ICategorias ctrlCategorias = Fabrica.getICategorias();
//          String[] listaCategorias = ctrlCategorias.listarCategorias();
//          request.setAttribute("CATEGORIAS", listaCategorias);
//          request.getRequestDispatcher("/WEB-INF/pages/modificar_video.jsp").forward(request,
//              response);
        } else {
          GregorianCalendar calendario = new GregorianCalendar();
          calendario.setTime(fecha);
          XMLGregorianCalendar XMLcalendario = null;
          try {
            XMLcalendario = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendario);
          } catch (DatatypeConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
          port.modificarVideo(nick, oldNombre, nombreVideo, descripcionVideo,
              urlVideo, categoria, duracion.getSeconds(), visible, XMLcalendario);
          response.sendRedirect("Inicio");
        }
      } else {
        String usuario = ((DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO")).getNick();
        List<DtUniversal> listaUni = port.getDtVideosPropietario(usuario).getListaDt();
        List<DtVideo> listaVideos = new LinkedList<DtVideo>();
        for (DtUniversal dtUni : listaUni) {
          listaVideos.add((DtVideo) dtUni);
        }
        request.setAttribute("VIDEOS", listaVideos);
        request.getRequestDispatcher("/WEB-INF/pages/videos_propietario.jsp").forward(request,
            response);
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
