package servlet;

import java.io.IOException;
import java.util.LinkedList;

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

@WebServlet("/VideoServlet")
public class VideoServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public VideoServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try{
    IUsuariosCanales ctrUsuariosCanales = Fabrica.getIUsuariosCanales();

    LinkedList<DtVideo> videosPublicos =
        (LinkedList<DtVideo>) ctrUsuariosCanales.getListaPublicoDtVideo();

    request.setAttribute("VIDEOS_PUBLICOS", videosPublicos);

    DtUsuario d = (DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO");

    if (d != null) {
      LinkedList<DtVideo> videosUsuario =
          (LinkedList<DtVideo>) ctrUsuariosCanales.listarVideosCanal(d.getIdUsuario());
      int largoVideosUsuario = videosUsuario.size();

      request.setAttribute("VIDEOS_USUARIO", videosUsuario);
    }

    request.getRequestDispatcher("WEB-INF/pages/listar_videos.jsp").forward(request, response);
    }
    catch(NotFoundException e){}
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

}
