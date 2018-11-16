package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicios.DtUsuario;
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
	  String nick = null;
	  if (request.getSession().getAttribute("USUARIO_LOGEADO") != null) {
	    nick = ((DtUsuario)request.getSession().getAttribute("USUARIO_LOGEADO")).getNick();
	  }	  
	  switch (tipo) {
      case "nick":
        bool = texto.equals("") || port.existeNick(texto);
        if (bool) {
          out.write("true");
        } else {
          out.write("false");
        }
        break;
        
      case "mail":
        bool = texto.equals("") || port.existeCorreo(texto);
        if (bool) {
          out.write("true");
        } else {
          out.write("false");  
        }
        break;
      
      case "lista":
        bool = texto.equals("") || port.existeLista(texto, nick);
        if (bool) {
          out.write("true");
        } else {
          out.write("false");
        }
        break;
        
      case "Video":
        String textoBase = request.getParameter("textoBase");
        if (textoBase != null && textoBase.equals(texto)) {
          out.write("false");
        } else {
          bool = texto.equals("") || port.existeVideo(texto, nick);
          if (bool) {
            out.write("true");
          } else {
            out.write("false");
          }
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
