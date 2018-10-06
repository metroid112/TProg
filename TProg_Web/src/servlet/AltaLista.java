package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.EstadoSesion;

/**
 * Servlet implementation class AltaLista
 */
@WebServlet("/AltaLista")
public class AltaLista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaLista() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
      if ((request.getSession().getAttribute("USUARIO_LOGEADO") != null) && 
          (request.getSession().getAttribute("LOGIN").equals(EstadoSesion.LOGIN_CORRECTO))) {
        request.getRequestDispatcher("/WEB-INF/pages/alta_lista.jsp").forward(request, response);
      }
      else {
        response.sendRedirect("/Inicio");
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
