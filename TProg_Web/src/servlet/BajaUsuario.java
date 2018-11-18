package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicios.NotFoundException_Exception;
import servicios.Publicador;
import servicios.PublicadorService;

/**
 * Servlet implementation class BajaUsuario
 */
@WebServlet("/BajaUsuario")
public class BajaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BajaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nick = request.getParameter("nickUsuario");
    PublicadorService service = new PublicadorService();
    Publicador port = service.getPublicadorPort();
    try {
      port.borrarUsuario(nick);
    } catch (NotFoundException_Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    response.sendRedirect("login?CERRAR_SESION=CONFIRM");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
