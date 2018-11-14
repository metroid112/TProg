package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicios.Publicador;
import servicios.PublicadorService;

/**
 * Servlet implementation class AjaxServlet
 */
@WebServlet("/AjaxServlet")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  PublicadorService service = new PublicadorService();
	  Publicador port = service.getPublicadorPort();
	  String tipo = request.getParameter("tipo");
	  String texto = request.getParameter("texto");
	  boolean bool = false;
	  response.setContentType("text/plain");
	  PrintWriter out = response.getWriter();
	  switch (tipo) {
      case "nick":
        bool = port.existeNick(texto);
        if (bool) {
          out.write("Nick no disponible");
        } else {
          out.write("Nick disponible");
        }        
        break;
        
      case "mail":
        bool = port.existeCorreo(texto);
        if (bool) {
          out.write("El correo ya esta en uso");
        } else {
          out.write("");
        }        
        break;

      default:
        break;
    }
	  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("texto"));
	}

}
