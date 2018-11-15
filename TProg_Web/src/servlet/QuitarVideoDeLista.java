package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicios.*;
import excepciones.NotFoundException;
import interfaces.Fabrica;
import interfaces.IListas;

@WebServlet("/QuitarVideoDeLista")
public class QuitarVideoDeLista extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public QuitarVideoDeLista() {
    super();
    // TODO Auto-generated constructor stub
  }

  private void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    PublicadorService service = new PublicadorService();
    Publicador port = service.getPublicadorPort(); 
    String lista = (String) request.getParameter("lista");
    String idVideo = (String) request.getParameter("video");
    Boolean defecto = false;
    if (request.getParameter("listapublica").equals("S")) {
      defecto = true;
    }
    DtUniversal video = null;
    try {
      video = port.getDtVideo(Integer.parseInt(idVideo)).getContenido();
    } catch (NumberFormatException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    String nombreVideo = ((DtVideo) video).getNombre();
    String nombreOwnerVideo = ((DtVideo) video).getUsuario();
    String usuario = ((DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO")).getNick();
    port.quitarVideoLista(usuario, nombreVideo, nombreOwnerVideo, lista, defecto);
    request.getRequestDispatcher("/index.jsp").forward(request, response);

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
