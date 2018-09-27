package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaces.Fabrica;
import interfaces.IUsuariosCanales;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public LoginServlet() {
    super();
    // TODO Auto-generated constructor stub
  }
  
  private void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    response.getWriter().print("logeando");
    String nick = (String) request.getAttribute("nickname");
    String pass = (String) request.getAttribute("pass");
    IUsuariosCanales IUC = Fabrica.getIUsuariosCanales();
    if (IUC.existeUsuario(nick) || IUC.existeUsuarioMail(nick)) {
        if (Fabrica.getIUsuariosCanales().checkLogin(nick, pass)) {
          request.getSession().setAttribute("LOGIN", arg1); // TODO enum de login como en el gamebook
        } else {
          // si no es correcto
        }
    } else {    
      // Usuario no encontrado
      // TODO excepcion?
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
