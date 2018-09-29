package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatypes.DtUsuario;
import interfaces.Fabrica;
import interfaces.IVideos;

@WebServlet("/VideoServlet")
public class VideoServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public VideoServlet() {
    super();
    // TODO Auto-generated constructor stub
  }
  private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO processRequest
  }
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    IVideos ctrVideos = Fabrica.getIVideos();
    
    DtUsuario d = (DtUsuario)request.getSession().getAttribute("USUARIO_LOGEADO");
    
    String[] videosUsuario = ctrVideos.listarVideos(d.nombre);
    int largoVideosUsuario = videosUsuario.length;
    
    request.setAttribute("VIDEOS_USUARIO", videosUsuario);
    request.getRequestDispatcher("jsp/listar_videos.jsp").forward(request, response);

  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    processRequest(request,response);
  }

}
