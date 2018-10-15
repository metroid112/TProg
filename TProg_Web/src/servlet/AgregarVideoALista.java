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
import excepciones.InvalidDataException;
import excepciones.NotFoundException;
import interfaces.Fabrica;
import interfaces.IListas;
import interfaces.IVideos;
import utils.EstadoSesion;

@WebServlet("/AgregarVideoALista")
public class AgregarVideoALista extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public AgregarVideoALista() {
    super();
    // TODO Auto-generated constructor stub
  }

  private void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    if (request.getParameter("agregarVideo") != null) {
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
      } catch (Exception e) {
        e.printStackTrace();
      }
      String nombreVideo = video.nombre;
      String nombreOwnerVideo = video.usuario;
      String usuario = ((DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO")).nick;
      try {
        ctrlListas.agregarVideoLista(nombreOwnerVideo, nombreVideo, usuario, nombreLista, defecto);
        request.setAttribute("EXITO",
            "¡Se ha agregado el video a la lista seleccionada con éxito!");
        request.getRequestDispatcher("/WEB-INF/extras/exito.jsp").forward(request, response);
      } catch (Exception e) {
        request.setAttribute("ERROR", "El video " + "'" + nombreVideo + "'"
            + " ya estaba en la lista " + "'" + nombreLista + "'.");
        IListas ctrlListas2 = Fabrica.getIListas();
        IVideos ctrlVideos2 = Fabrica.getIVideos();
        String nickUsuario =
            ((DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO")).nick;
        String[] listasParticulares = ctrlListas2.listarListasParticularUsuario(nickUsuario);
        request.setAttribute("LISTAS_PARTICULARES", listasParticulares);
        String[] listasPorDefecto = ctrlListas2.listarListasDefectoUsuario(nickUsuario);
        request.setAttribute("LISTAS_POR_DEFECTO", listasPorDefecto);
        DtVideo[] listaDeVideos = ctrlVideos2.listarTodosLosVideos(nickUsuario);
        request.setAttribute("LISTA_DE_VIDEOS", listaDeVideos);
        request.getRequestDispatcher("/WEB-INF/pages/agregar_video_a_lista_de_reproduccion.jsp")
            .forward(request, response);

      }
    } else {
      if (request.getSession().getAttribute("LOGIN") == null
          || request.getSession().getAttribute("LOGIN").equals(EstadoSesion.NO_LOGIN)) {
        response.sendRedirect("/Inicio");
      } else {
        IListas ctrlListas = Fabrica.getIListas();
        IVideos ctrlVideos = Fabrica.getIVideos();
        String nickUsuario =
            ((DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO")).nick;
        String[] listasParticulares = ctrlListas.listarListasParticularUsuario(nickUsuario);
        request.setAttribute("LISTAS_PARTICULARES", listasParticulares);
        String[] listasPorDefecto = ctrlListas.listarListasDefectoUsuario(nickUsuario);
        request.setAttribute("LISTAS_POR_DEFECTO", listasPorDefecto);
        DtVideo[] listaDeVideos = ctrlVideos.listarTodosLosVideos(nickUsuario);
        request.setAttribute("LISTA_DE_VIDEOS", listaDeVideos);
        request.getRequestDispatcher("/WEB-INF/pages/agregar_video_a_lista_de_reproduccion.jsp")
            .forward(request, response);
      }
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
