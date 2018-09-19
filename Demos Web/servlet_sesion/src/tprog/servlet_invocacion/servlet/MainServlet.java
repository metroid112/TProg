package tprog.servlet_invocacion.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        PrintWriter writer = response.getWriter();
        HttpSession sesionObj = request.getSession();
        Integer paginasNavegadas;

        paginasNavegadas = (Integer) sesionObj.getAttribute("paginas_navegadas");
        if(paginasNavegadas == null)
            paginasNavegadas = 0;
        writer.println("Has entrado " + paginasNavegadas.toString() + " veces");
        
        sesionObj.setAttribute("paginas_navegadas", paginasNavegadas+1);
	}

}
