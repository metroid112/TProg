package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatypes.DtUsuario;
import datatypes.DtVideo;
import excepciones.DuplicateClassException;
import excepciones.NotFoundException;
import interfaces.Fabrica;
import interfaces.IListas;
import manejadores.ManejadorVideos;

/**
 * Servlet implementation class AgregarVideoALista
 */
@WebServlet("/AgregarVideoALista")
public class AgregarVideoALista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarVideoALista() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
      IListas ctrlListas = Fabrica.getIListas();
      String idVideo = (String) request.getParameter("video");
      String lista = (String) request.getParameter("lista");
      int largo = lista.length();
      String tipoLista = String.valueOf(lista.charAt(0));
      String nombreLista = lista.substring(1, lista.length());
      Boolean defecto = tipoLista.equals("D");
      DtVideo video = null;
      try {
        video = Fabrica.getIVideos().getDtVideo(Integer.parseInt(idVideo));
      } catch (NumberFormatException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (NotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }   
      String nombreVideo = video.nombre;
      String nombreOwnerVideo = video.usuario;
      String usuario = ((DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO")).nick;
      try {
      ctrlListas.agregarVideoLista(nombreOwnerVideo, nombreVideo, usuario, nombreLista, defecto);
      request.setAttribute("EXITO", "¡Se ha agregado el video a la lista seleccionada con éxito!");
      request.getRequestDispatcher("index.jsp").forward(request, response);
      }
      catch (DuplicateClassException e) {
        request.setAttribute("ERROR", e.getMessage());
        response.sendRedirect("/ListarListaServlet");
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
