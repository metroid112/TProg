package servlet;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatypes.DtUsuario;
import datatypes.DtVideo;
import interfaces.Fabrica;

@WebServlet("/ListaServlet")
public class ListaServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ListaServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  private void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String nombreLista = (String) request.getParameter("nombreLista");
    Boolean visibilidad;
    String nickUsuario = ((DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO")).nick;
    String[] ListasPublicas = Fabrica.getIListas().listarListasDefectoUsuario(nickUsuario);
    String[] ListasParticulares = Fabrica.getIListas().listarListasParticularUsuario(nickUsuario);
   if (request.getParameter("STATE").equals("DETALLESLISTA")) {
     String listaSeleccionada = (String) request.getParameter("LISTA");
     Boolean listaDefecto = false;
     if (request.getParameter("LISTAPUBLICA").equals("S")) {
       listaDefecto = true;
     }
     List<DtVideo> videosDeLista = Fabrica.getIUsuariosCanales().listarDtVideosDuenosLista(nickUsuario, listaSeleccionada, listaDefecto);
     request.setAttribute("VIDEOSLISTA", videosDeLista);
     request.getRequestDispatcher("/WEB-INF/pages/seleccionar_video.jsp").forward(request, response);
   }
   else if (request.getParameter("STATE").equals("LOADLISTAS")) {
     //obtener las listas para el usuario
     request.setAttribute("LISTASPRIVADAS", ListasParticulares);
     request.setAttribute("LISTASPUBLICAS", ListasPublicas);
     request.getRequestDispatcher("/WEB-INF/pages/quitar_video_lista.jsp").forward(request, response);
   } else {
       if (request.getParameter("visibilidad").equals("Público")) {
        visibilidad = true;
      } else {
        visibilidad = false;
      }
      //String nickUsuario = ((DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO")).nick;
      try {
        Fabrica.getIListas().altaListaParticular(nombreLista, nickUsuario, visibilidad);
        request.setAttribute("EXITO", "¡Se ha creado la lista con éxito!");
        request.getRequestDispatcher("/WEB-INF/extras/exito.jsp").forward(request, response);
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
  int aLen = a.length;
  int bLen = b.length;

  @SuppressWarnings("unchecked")
  String[] c = (String[]) Array.newInstance(a.getClass().getComponentType(), aLen + bLen);
  System.arraycopy(a, 0, c, 0, aLen);
  System.arraycopy(b, 0, c, aLen, bLen);

  return c;
}
}

