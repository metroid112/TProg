package servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatypes.DtUsuario;
import datatypes.DtVideo;
import excepciones.NotFoundException;
import interfaces.Fabrica;
import interfaces.IUsuariosCanales;
import interfaces.IVideos;

@WebServlet("/ConsultaVideo")
public class ConsultaVideo extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ConsultaVideo() {
    super();

  }

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    IVideos ctrVideos = Fabrica.getIVideos();
    IUsuariosCanales ctrUsuariosCanales = Fabrica.getIUsuariosCanales();
    String videoId = (String) request.getParameter("VIDEO_ID");
    int idVideo = Integer.parseInt(videoId);
    DtVideo vid;

    try {
      vid = ctrVideos.getDtVideo(idVideo);
      request.setAttribute("DT_VIDEO", vid);

      DtUsuario d = (DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO");

      if (request.getParameter("ACCION").equals("VALORAR_POSITIVO")) {
        if (!ctrUsuariosCanales.yaCalificacdo(d.nick, false, vid.nombre, vid.usuario)) {

          ctrUsuariosCanales.valorarVideo(d.nick, true, vid.nombre, vid.usuario);
        } else {
          ctrUsuariosCanales.modificarValoracion(true, d.nick, vid.nombre, vid.usuario);
        }
      }
      if (request.getParameter("ACCION").equals("VALORAR_NEGATIVO")) {
        if (!ctrUsuariosCanales.yaCalificacdo(d.nick, true, vid.nombre, vid.usuario)) {
          ctrUsuariosCanales.valorarVideo(d.nick, false, vid.nombre, vid.usuario);
        } else {
          ctrUsuariosCanales.modificarValoracion(false, d.nick, vid.nombre, vid.usuario);
        }
      }
      if (request.getParameter("ACCION").equals("COMENTAR")) {
        if (request.getParameter("COMENTARIO") != "") {
          if (request.getParameter("COMENTARIO_ID") == null) {
            ctrUsuariosCanales.comentarVideo(request.getParameter("COMENTARIO"), new Date(), d.nick,
                vid.nombre, vid.usuario);
          } else {
            String idReq = request.getParameter("COMENTARIO_ID");
            int idComentario = Integer.parseInt(idReq);
            ctrUsuariosCanales.responderComentario(request.getParameter("COMENTARIO"), new Date(),
                d.nick, vid.nombre, vid.usuario, idComentario);
          }
        }
      }
    } catch (NotFoundException e) {
      e.printStackTrace();
    }

    request.getRequestDispatcher("WEB-INF/pages/consulta_video.jsp").forward(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    IVideos ctrVideos = Fabrica.getIVideos();

    String videoId = (String) request.getParameter("VIDEO_ID");
    int id = Integer.parseInt(videoId);
    DtVideo vid;
    try {
      vid = ctrVideos.getDtVideo(id);
      request.setAttribute("DT_VIDEO", vid);
    } catch (NotFoundException e) {
      e.printStackTrace();
    }

    request.getRequestDispatcher("WEB-INF/pages/consulta_video.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    processRequest(request, response);
  }

}
