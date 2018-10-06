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
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      IVideos ctrVideos = Fabrica.getIVideos();
      IUsuariosCanales ctrUsuariosCanales = Fabrica.getIUsuariosCanales();
      String videoId = (String) request.getParameter("VIDEO_ID");
      int id = Integer.parseInt(videoId);
      DtVideo vid;
      try {
        vid = ctrVideos.getDtVideo(id);
        request.setAttribute("DT_VIDEO", vid);
      } catch (NotFoundException e) {
        e.printStackTrace();
      }
      DtUsuario d = (DtUsuario)request.getSession().getAttribute("USUARIO_LOGEADO");
      
      if (request.getParameter("VALORAR").equals("POSITIVO")) {
        
        ctrUsuariosCanales.valorarVideo(d.nick,true ,vid.nombre, vid.usuario);
        
        request.getRequestDispatcher("WEB-INF/pages/listar_videos.jsp").forward(request, response);
      }
      if (request.getParameter("VALORAR").equals("NEGATIVO")) {
        
        ctrUsuariosCanales.valorarVideo(d.nick,false ,vid.nombre, vid.usuario);
        
        request.getRequestDispatcher("WEB-INF/pages/listar_videos.jsp").forward(request, response);
      }
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  processRequest(request, response);
	}

}
