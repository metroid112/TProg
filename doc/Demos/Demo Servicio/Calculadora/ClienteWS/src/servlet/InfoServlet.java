package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InfoServlet
 */
@WebServlet("/InfoServlet")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	        response.setContentType("text/html;charset=UTF-8");
    	        PrintWriter out = response.getWriter();
    	        try {

            HttpSession sesion = request.getSession();
            String procedencia = (String)sesion.getAttribute("procedencia");
            String address = "";

            if (procedencia.equals("index")){
                address = "resultado.jsp";
                String sumandoi = request.getParameter("nroi");
                String sumandoj = request.getParameter("nroj");
                int i = Integer.parseInt(sumandoi);
                int j = Integer.parseInt(sumandoj);
                int resultado = 0;

                servidor.PublicadorService service = new servidor.PublicadorService();
                servidor.Publicador port = service.getPublicadorPort();
                resultado = port.suma(i, j);

                sesion.setAttribute("res", resultado);
            }

            RequestDispatcher dis = request.getRequestDispatcher(address);
            dis.forward(request, response);

        } finally {
            out.close();
        }
    } 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
