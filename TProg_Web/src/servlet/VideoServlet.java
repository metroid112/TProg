package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicios.DtUniversal;
import servicios.DtUsuario;
import servicios.Publicador;
import servicios.PublicadorService;

@WebServlet("/VideoServlet")
public class VideoServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public VideoServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    PublicadorService service = new PublicadorService();
    Publicador port = service.getPublicadorPort();

    List<DtUniversal> videosPublicos = port.getListaPublicoDtVideo().getListaDt();

    request.setAttribute("VIDEOS_PUBLICOS", videosPublicos);

    DtUsuario d = (DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO");

    if (d != null) {
      List<DtUniversal> videosUsuario =
          (List<DtUniversal>) port.getListaDtVideo(d.getNick()).getListaDt();
      int largoVideosUsuario = videosUsuario.size();

      request.setAttribute("VIDEOS_USUARIO", videosUsuario);
    }

    request.getRequestDispatcher("WEB-INF/pages/listar_videos.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

}
