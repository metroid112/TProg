package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicios.DtUsuario;
import servicios.Publicador;
import servicios.PublicadorService;

@WebServlet("/VideoServlet")
public class VideoServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public VideoServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    //IUsuariosCanales ctrUsuariosCanales = Fabrica.getIUsuariosCanales();
    DtUsuario d = (DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO");
    String tipoBusqueda = "VIDEOS";
    String ordenBusquedaString = request.getParameter("ORDEN_BUSQUEDA");
    int ordenBusqueda = ordenBusquedaString == null ? 0 : Integer.parseInt(ordenBusquedaString);
    String txtBusquedaString = request.getParameter("txtBusqueda");
    String txtBusqueda = txtBusquedaString == null ? "" : txtBusquedaString;
    servicios.DtBusqueda resultados = null;
    request.setAttribute("TIPO_BUSQUEDA","VIDEOS");
    PublicadorService service = new PublicadorService();
    Publicador port = service.getPublicadorPort();
    if (tipoBusqueda == null || tipoBusqueda.equals("TODOS")) {
      resultados = (servicios.DtBusqueda) port.busquedaGeneral(txtBusqueda, ordenBusqueda).getContenido();
    } else if (tipoBusqueda.equals("VIDEOS")) {
      resultados = (servicios.DtBusqueda) port.busquedaVideo(txtBusqueda, ordenBusqueda).getContenido();
    }
    request.setAttribute("txtBusqueda", request.getParameter("txtBusqueda"));
    request.setAttribute("RESULTADO_BUSQUEDA", resultados);
    request.getRequestDispatcher("WEB-INF/pages/listar_videos.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

}
