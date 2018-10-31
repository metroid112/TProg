package servlet;

import java.io.IOException;
import java.util.Comparator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatypes.DtBusqueda;
import datatypes.DtLista;
import datatypes.DtUsuario;
import datatypes.DtVideo;
import interfaces.Fabrica;
import servicios.Publicador;
import servicios.PublicadorService;

@WebServlet("/Busqueda")
public class Busqueda extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public Busqueda() {
    super();
  }

  private void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String tipoBusqueda = request.getParameter("TIPO_BUSQUEDA");
    String txtBusqueda = request.getParameter("txtBusqueda");
    servicios.DtBusqueda resultados = null;
    PublicadorService service = new PublicadorService();
    Publicador port = service.getPublicadorPort();
    if (tipoBusqueda == null || tipoBusqueda.equals("TODOS")) {
      resultados = (servicios.DtBusqueda) port.getPaquete(txtBusqueda).getContenido();
      //resultados = Fabrica.getIDatos().busquedaGeneral(txtBusqueda);
    } else if (tipoBusqueda.equals("VIDEOS")) {
      //resultados = Fabrica.getIDatos().busquedaVideo(txtBusqueda);
    } else if (tipoBusqueda.equals("LISTAS")) {
      //resultados = Fabrica.getIDatos().busquedaLista(txtBusqueda);
    } else if (tipoBusqueda.equals("CANALES")) {
      //resultados = Fabrica.getIDatos().busquedaCanales(txtBusqueda);
    }
    String ordenBusqueda = request.getParameter("ORDEN_BUSQUEDA");
    if (ordenBusqueda != null) {
      if (ordenBusqueda.equals("ALFABETICO")) {
//        resultados.getVideos().sort(Comparator.comparing(DtVideo::getNombre));
//        resultados.getListas().sort(Comparator.comparing(DtLista::getNombre));
//        resultados.getUsuarios().sort(Comparator.comparing(DtUsuario::getCanal));
      } else if (ordenBusqueda.equals("FECHA")) {
//        resultados.getVideos().sort(Comparator.comparing(DtVideo::getFecha).reversed());
//        resultados.getListas().sort(Comparator.comparing(DtLista::getUltimaActividad).reversed());
//        resultados.getUsuarios().sort(Comparator.comparing(DtUsuario::getUltimaActividad).reversed());
      }
    }
    request.setAttribute("RESULTADO_BUSQUEDA", resultados);
    request.getRequestDispatcher("WEB-INF/pages/busqueda.jsp").forward(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
