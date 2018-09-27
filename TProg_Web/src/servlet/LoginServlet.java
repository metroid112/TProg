package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaces.Fabrica;
import interfaces.IUsuariosCanales;
import utils.EstadoSesion;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public LoginServlet() {
    super();
    // TODO Auto-generated constructor stub
  }
  
  public EstadoSesion getEstado(HttpServletRequest request) {
    return (EstadoSesion) request.getSession().getAttribute("LOGIN");
  }
  
  private void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    if (getEstado(request).equals(EstadoSesion.NO_LOGIN) || getEstado(request) == null) {
      String nick = (String) request.getParameter("nickname");
      response.getWriter().println(nick); //asddfasdf
      String pass = (String) request.getParameter("pass");
      response.getWriter().println(pass); //asdfasdfadsf
      IUsuariosCanales IUC = Fabrica.getIUsuariosCanales();
      if ((IUC.existeUsuario(nick) || IUC.existeUsuarioMail(nick)) && IUC.checkLogin(nick, pass)) {
        request.getSession().setAttribute("LOGIN", EstadoSesion.LOGIN_CORRECTO);
        response.sendRedirect("index.jsp");
      } else {
        request.getSession().setAttribute("LOGIN", EstadoSesion.LOGIN_INCORRECTO);
        request.getRequestDispatcher("jsp/inicio_sesion_error.jsp").forward(request, response);
      } 
    } else {
      response.sendRedirect("index.jsp");
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
