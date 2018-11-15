package servlet;

import java.io.IOException;
import java.lang.reflect.Array;
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

@WebServlet("/ListaServlet")
public class ListaServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ListaServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  private void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    PublicadorService service = new PublicadorService();
    Publicador port = service.getPublicadorPort();   
    String nombreLista = (String) request.getParameter("nombreLista");
    Boolean visibilidad;
    String nickUsuario = ((DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO")).getNick();
    List<String> listasPublicas = port.listarListasDefectoUsuario(nickUsuario).getListaAux();
    List<String> listasParticulares = port.listarListasParticularUsuario(nickUsuario).getListaAux();
    if (request.getParameter("STATE") != null
        && request.getParameter("STATE").equals("DETALLESLISTA")) {
      String listaSeleccionada = (String) request.getParameter("LISTA");
      request.setAttribute("LISTA", listaSeleccionada);
      Boolean listaDefecto = false;
      request.setAttribute("LISTAPUBLICA", request.getParameter("LISTAPUBLICA"));
      if (request.getParameter("LISTAPUBLICA").equals("S")) {
        listaDefecto = true;
      }
      List<DtUniversal> videosDeLista = port.listarDtVideosDuenosLista(nickUsuario, listaSeleccionada, listaDefecto).getListaDt();
      request.setAttribute("VIDEOSLISTA", videosDeLista);
      request.getRequestDispatcher("/WEB-INF/pages/seleccionar_video.jsp").forward(request,
          response);
    } else if (request.getParameter("STATE") != null
        && request.getParameter("STATE").equals("LOADLISTAS")) {
      // obtener las listas para el usuario
      request.setAttribute("LISTASPRIVADAS", listasParticulares);
      request.setAttribute("LISTASPUBLICAS", listasPublicas);
      request.getRequestDispatcher("/WEB-INF/pages/quitar_video_lista.jsp").forward(request,
          response);
    } else {
      if (request.getParameter("visibilidad").equals("Público")) {
        visibilidad = true;
      } else {
        visibilidad = false;
      }
      // String nickUsuario = ((DtUsuario)
      // request.getSession().getAttribute("USUARIO_LOGEADO")).nick;
      try {
        port.altaListaParticular(nombreLista, nickUsuario, visibilidad);
        request.setAttribute("EXITO", "¡Se ha creado la lista con éxito!");
        request.getRequestDispatcher("Inicio").forward(request, response);
      } catch (Exception e) {
        request.setAttribute("ERROR", e.getMessage());
        request.getRequestDispatcher("/WEB-INF/pages/alta_lista.jsp").forward(request, response);
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

  public String[] concatenate(String[] a, String[] b) {
    int lengthA = a.length;
    int lengthB = b.length;

    @SuppressWarnings("unchecked")
    String[] c = (String[]) Array.newInstance(a.getClass().getComponentType(), lengthA + lengthB);
    System.arraycopy(a, 0, c, 0, lengthA);
    System.arraycopy(b, 0, c, lengthA, lengthB);

    return c;
  }
}
