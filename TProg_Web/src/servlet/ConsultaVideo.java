package servlet;

import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import servicios.DtUsuario;
import servicios.DtVideo;
import servicios.NotFoundException_Exception;
import servicios.Publicador;
import servicios.PublicadorService;

@WebServlet("/ConsultaVideo")
public class ConsultaVideo extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ConsultaVideo() {
    super();

  }

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException, DatatypeConfigurationException {

    PublicadorService service = new PublicadorService();
    Publicador port = service.getPublicadorPort();
    String videoId = (String) request.getParameter("VIDEO_ID");
    int idVideo = Integer.parseInt(videoId);
    DtVideo vid;

    //try {     TODO excepcion video no encontrado y eso
      vid = (DtVideo) port.getDtVideo(idVideo).getContenido();
      
      DtUsuario d = (DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO");

      if (request.getParameter("ACCION").equals("VALORAR_POSITIVO")) {
        if (!port.yaCalificado(d.getNick(), false, vid.getNombre(), vid.getUsuario())) {
          // Para estas funciones se podria usar la id de los videos
          port.valorarVideo(d.getNick(), true, vid.getNombre(), vid.getUsuario());
        } else {
          port.modificarValoracion(true, d.getNick(), vid.getNombre(), vid.getUsuario());
        }
      }
      if (request.getParameter("ACCION").equals("VALORAR_NEGATIVO")) {
        if (!port.yaCalificado(d.getNick(), true, vid.getNombre(), vid.getUsuario())) {
          port.valorarVideo(d.getNick(), false, vid.getNombre(), vid.getUsuario());
        } else {
          port.modificarValoracion(false, d.getNick(), vid.getNombre(), vid.getUsuario());
        }
      }
      if (request.getParameter("ACCION").equals("COMENTAR")) {
        if (request.getParameter("COMENTARIO") != "") {
          GregorianCalendar cal = new GregorianCalendar();
          cal.setTime(new Date());
          XMLGregorianCalendar calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
          if (request.getParameter("COMENTARIO_ID") == null) {
            port.comentarVideo(request.getParameter("COMENTARIO"), calendar, d.getNick(),
                vid.getNombre(), vid.getUsuario());
          } else {
            String idReq = request.getParameter("COMENTARIO_ID");
            int idComentario = Integer.parseInt(idReq);
            port.responderComentario(request.getParameter("COMENTARIO"), calendar,
                d.getNick(), vid.getNombre(), vid.getUsuario(), idComentario);
          }
        }
      }
      vid = (DtVideo) port.getDtVideo(idVideo).getContenido();
      request.setAttribute("DT_VIDEO", vid);
    //} catch (NotFoundException e) {
    //  e.printStackTrace();
   // }

    request.getRequestDispatcher("WEB-INF/pages/consulta_video.jsp").forward(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    PublicadorService service = new PublicadorService();
    Publicador port = service.getPublicadorPort();
    String videoId = (String) request.getParameter("VIDEO_ID");
    String ShareURL = request.getServerName() + ":" + request.getServerPort() + "/v=" + videoId;
    request.setAttribute("ShareURL", ShareURL);
    int id = Integer.parseInt(videoId);
    DtVideo vid;
    //try { TODO excepcion video no encontrado
      vid = (DtVideo) port.getDtVideo(id).getContenido();
      request.setAttribute("DT_VIDEO", vid);
    //} catch (NotFoundException e) {
    //  e.printStackTrace();
    //}
      DtUsuario user = (DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO");
      try {
        port.consultaVideo(user.getNick(), vid.getIdVideo());
      } catch (NotFoundException_Exception exception) {
        // TODO Auto-generated catch block
        exception.printStackTrace();
      }
    request.getRequestDispatcher("WEB-INF/pages/consulta_video.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      processRequest(request, response);
    } catch (DatatypeConfigurationException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
