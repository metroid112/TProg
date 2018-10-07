package servlet;

import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Calificacion;
import clases.Categoria;
import clases.Comentario;
import datatypes.DtVideo;
import excepciones.NotFoundException;
import interfaces.Fabrica;
import interfaces.IVideos;

@WebServlet("/ConsultaVideo")
public class ConsultaVideo extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ConsultaVideo() {
    super();
    // TODO Auto-generated constructor stub
  }

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO processRequest
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // DtVideo vid = new DtVideo("lala","esta muy bueno","AlhJsZ1EBIU",null,null,null,null,true,new
    // LinkedHashMap<Integer, Comentario>(),new LinkedList<Calificacion>());

    IVideos ctrVideos = Fabrica.getIVideos();
    // String usuarioNick = (String) request.getParameter("VIDEO_CANAL"); //ESTAN LLEGANDO LOS DOS
    // NULL
    // String nombreVideo = (String) request.getParameter("VIDEO_NOMBRE");
    // DtVideo vid = ctrVideos.getDtVideo(nombreVideo, usuarioNick);
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
