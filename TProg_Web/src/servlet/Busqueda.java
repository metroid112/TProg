package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatypes.DtBusqueda;
import interfaces.Fabrica;

@WebServlet("/Busqueda")
public class Busqueda extends HttpServlet {
	private static final long serialVersionUID = 1L;

  public Busqueda() {
      super();
  }

  private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String txtBusqueda = request.getParameter("txtBusqueda");
    DtBusqueda resultados = Fabrica.getIDatos().busqueda(txtBusqueda);
    request.setAttribute("RESULTADO_BUSQUEDA", resultados);
    request.getRequestDispatcher("WEB-INF/pages/busqueda.jsp").forward(request, response);
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
