package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatypes.DtVideo;



/**
 * Servlet implementation class ConsultaVideo
 */
@WebServlet("/ConsultaVideo")
public class ConsultaVideo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaVideo() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
      
      DtVideo vid = new DtVideo("nombre","esta muy bueno","sdjfsdjfis",null,null,null,true,null,null);
      request.setAttribute("videoo", vid);
      request.getRequestDispatcher("/jsp/consulta_video.jsp").forward(request, response);
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//response.getWriter().append("Served at: ").append(request.getContextPath());
	  processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//doGet(request, response);
	  processRequest(request, response);
	}
	
	/*
	static public DtVideo getVideoSeleccionado(HttpServletRequest request){ 
	  //esto es temporal (Nombre,Descripcion,url,Categoria,Fecha,Duracion,Visible,Comentarios,Calificaciones)
	  return new DtVideo("nombre","esta muy bueno","sdjfsdjfis",null,null,null,true,null,null);
	}
*/
}
