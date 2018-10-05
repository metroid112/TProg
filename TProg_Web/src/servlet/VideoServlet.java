package servlet;

import java.awt.List;
import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatypes.DtUsuario;
import datatypes.DtVideo;
import interfaces.Fabrica;
import interfaces.IUsuariosCanales;

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
    
    IUsuariosCanales ctrUsuariosCanales = Fabrica.getIUsuariosCanales();
    
    List<DtVideo> videosPublicos = ctrUsuariosCanales.getListaPublicoDtVideo();

    request.setAttribute("VIDEOS_PUBLICOS", videosPublicos);
    
    DtUsuario d = (DtUsuario)request.getSession().getAttribute("USUARIO_LOGEADO");
    
    if(d != null){
      List<DtVideo> videosUsuario = ctrUsuariosCanales.getListaDtVideo(d.nick);
      int largoVideosUsuario = videosUsuario.size();
    
    request.setAttribute("VIDEOS_USUARIO", videosUsuario);
    }
    
    request.getRequestDispatcher("WEB-INF/pages/listar_videos.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    processRequest(request,response);
  }

}
