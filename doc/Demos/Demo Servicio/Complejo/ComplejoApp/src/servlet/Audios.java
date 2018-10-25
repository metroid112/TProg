package servlet;

import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Audios
 */
@WebServlet("/Audios")
public class Audios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Audios() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
                String id = (String) request.getParameter("id");
        System.out.println(id);
        
        byte[] img = null;
        
        complejoservidor.publicar.WebServicesService service = new complejoservidor.publicar.WebServicesService();
        complejoservidor.publicar.WebServices port = service.getWebServicesPort();
        
        try {

            img = port.getFile("audio.mp3");
            System.out.println(img.length);
            
            response.setContentType("audio/mpeg");
            response.setContentLength((int) img.length);

            OutputStream out = response.getOutputStream();
            out.write(img);
            out.close();
            
        } catch (Exception ex) {            

        }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
