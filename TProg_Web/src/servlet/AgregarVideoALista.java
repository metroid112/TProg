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
import servicios.DtVideo;
import servicios.Publicador;
import servicios.PublicadorService;
import utils.EstadoSesion;

@WebServlet("/AgregarVideoALista")
public class AgregarVideoALista extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public AgregarVideoALista() {
    super();
  }

  private void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    PublicadorService service = new PublicadorService();
    Publicador port = service.getPublicadorPort();   
    if (request.getParameter("agregarVideo") != null) {
      String idVideo = (String) request.getParameter("video");
      String lista = (String) request.getParameter("lista");
      String tipoLista = String.valueOf(lista.charAt(0));
      String nombreLista = lista.substring(1, lista.length());
      Boolean defecto = tipoLista.equals("D");
      DtVideo video = null;
      try {
        video = (DtVideo) port.getDtVideo(Integer.parseInt(idVideo)).getContenido();
      } catch (Exception e) {
        e.printStackTrace();
      }
      String nombreVideo = video.getNombre();
      String nombreOwnerVideo = video.getUsuario();
      String usuario = ((DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO")).getNick();
      try {
        port.agregarVideoLista(nombreOwnerVideo, nombreVideo, usuario, nombreLista, defecto);
        request.setAttribute("EXITO",
            "¡Se ha agregado el video a la lista seleccionada con éxito!");
        request.getRequestDispatcher("/WEB-INF/extras/exito.jsp").forward(request, response);
      } catch (Exception e) {
        request.setAttribute("ERROR", "El video " + "'" + nombreVideo + "'"
            + " ya estaba en la lista " + "'" + nombreLista + "'.");
        String nickUsuario =
            ((DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO")).getNick();
        List<DtUniversal> listaDeVideos = port.listarTodosLosVideos(nickUsuario).getListaDt();
        request.setAttribute("LISTA_DE_VIDEOS", listaDeVideos);
        List<String> listasPorDefecto = port.listarListasDefectoUsuario(nickUsuario).getListaAux();
        request.setAttribute("LISTAS_POR_DEFECTO", listasPorDefecto);
        List<String> listasParticulares = port.listarListasParticularUsuario(nickUsuario).getListaAux();
        request.setAttribute("LISTAS_PARTICULARES", listasParticulares);
        request.getRequestDispatcher("/WEB-INF/pages/agregar_video_a_lista_de_reproduccion.jsp")
            .forward(request, response);

      }
    } else {
      if (request.getSession().getAttribute("LOGIN") == null
          || request.getSession().getAttribute("LOGIN").equals(EstadoSesion.NO_LOGIN)) {
        response.sendRedirect("/Inicio");
      } else {
        String nickUsuario =
            ((DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO")).getNick();
        List<DtUniversal> listaDeVideos = port.listarTodosLosVideos(nickUsuario).getListaDt();
        request.setAttribute("LISTA_DE_VIDEOS", listaDeVideos);
        List<String> listasPorDefecto = port.listarListasDefectoUsuario(nickUsuario).getListaAux();
        request.setAttribute("LISTAS_POR_DEFECTO", listasPorDefecto);
        List<String> listasParticulares = port.listarListasParticularUsuario(nickUsuario).getListaAux();
        request.setAttribute("LISTAS_PARTICULARES", listasParticulares);
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
