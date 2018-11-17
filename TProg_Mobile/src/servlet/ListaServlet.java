package servlet;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaces.Fabrica;
import interfaces.IUsuariosCanales;
import servicios.DtUniversal;
import servicios.DtUsuario;
import servicios.DtVideo;
import servicios.Publicador;
import servicios.PublicadorService;

@WebServlet("/ListaServlet")
public class ListaServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ListaServlet() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    //IUsuariosCanales ctrUsuariosCanales = Fabrica.getIUsuariosCanales();
    DtUsuario d = (DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO");
    String tipoBusqueda = "LISTAS";
    String ordenBusquedaString = request.getParameter("ORDEN_BUSQUEDA");
    int ordenBusqueda = ordenBusquedaString == null ? 0 : Integer.parseInt(ordenBusquedaString);
    String txtBusquedaString = request.getParameter("txtBusqueda");
    String txtBusqueda = txtBusquedaString == null ? "" : txtBusquedaString;
    servicios.DtBusqueda resultados = null;
    request.setAttribute("TIPO_BUSQUEDA","LISTAS");
    PublicadorService service = new PublicadorService();
    Publicador port = service.getPublicadorPort();
    if (tipoBusqueda == null || tipoBusqueda.equals("TODOS")) {
      resultados = (servicios.DtBusqueda) port.busquedaGeneral(txtBusqueda, ordenBusqueda).getContenido();
    } else if (tipoBusqueda.equals("LISTAS")) {
      resultados = (servicios.DtBusqueda) port.busquedaLista(txtBusqueda, ordenBusqueda).getContenido();
    }
    request.setAttribute("txtBusqueda", request.getParameter("txtBusqueda"));
    request.setAttribute("RESULTADO_BUSQUEDA", resultados);
    request.getRequestDispatcher("WEB-INF/pages/listar_listas.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

}
