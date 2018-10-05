package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AgregarVideoALista
 */
@WebServlet("/AgregarVideoALista")
public class AgregarVideoALista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarVideoALista() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
      String idVideo = (String) request.getParameter("video");
      String lista = (String) request.getParameter("lista");
      int largo = lista.length();
      String tipoLista = lista.valueOf(lista.charAt(0));
      String nombreLista = lista.substring(1, lista.length() - 1);
      if tipoLista.equals("D") {
        
      }
      else {
        
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
