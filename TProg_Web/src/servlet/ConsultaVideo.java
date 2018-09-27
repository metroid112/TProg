package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatypes.DtVideo;

@WebServlet("/ConsultaVideo")
public class ConsultaVideo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ConsultaVideo() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   // TODO processRequest
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //DtVideo vid = new DtVideo("nombre","esta muy bueno","sdjfsdjfis",null,null,null,true,null,null);
    //<% DtVideo vid = (DtVideo) request.getAttribute("DT_VIDEO"); %> <%= vid.nombre %>
	  String vid = "hola";
    request.setAttribute("DT_VIDEO", vid);
    request.getRequestDispatcher("jsp/consulta_video.jsp").forward(request, response);
    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  processRequest(request, response);
	}

}
