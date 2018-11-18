package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicios.DtUsuario;
import servicios.Publicador;
import servicios.PublicadorService;
import utils.EstadoSesion;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public LoginServlet() {
    super();
  }

  public EstadoSesion getEstado(HttpServletRequest request) {
    if (request.getSession().getAttribute("LOGIN") != null) {
      return (EstadoSesion) request.getSession().getAttribute("LOGIN");
    } else {
      return EstadoSesion.NO_LOGIN;
    }
  }

  private void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    if (!getEstado(request).equals(EstadoSesion.LOGIN_CORRECTO)) {
      if (request.getParameter("PANTALLALOGIN") != null
          && request.getParameter("PANTALLALOGIN").equals("TRUE")) {
        request.getRequestDispatcher("/WEB-INF/pages/inicio_sesion.jsp").forward(request, response);
      } else {
        String nick = (String) request.getParameter("nickname");
        String pass = (String) request.getParameter("pass");
        
        //logica para remember me.
        String value = request.getParameter("recordarme");
        boolean rememberMe = false;
        if(value != null && value.equalsIgnoreCase("on")){
            rememberMe = true;
        }
        if (rememberMe) {           //If your checkbox value is true
        Cookie[] cookies=request.getCookies();
        if (cookies != null) {
           for (Cookie cookie : cookies) {
               if (cookie.getName().equals("cookieLoginUser") || cookie.getName().equals("cookieLoginPassword")) {
                 cookie.setMaxAge(0);
               }
           }
        }
        Cookie cookieUsername = new Cookie("cookieLoginUser", nick);
        Cookie cookiePassword = new Cookie("cookieLoginPassword",
                            pass);
        // Make the cookie one day last
        cookieUsername.setMaxAge(60 * 60 * 24);
        cookiePassword.setMaxAge(60 * 60 * 24);
        response.addCookie(cookieUsername);
        response.addCookie(cookiePassword);
        }
        //fin logica remember me.
        PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();
        if (port.checkLogin(nick, pass)) {
          request.getSession().setAttribute("LOGIN", EstadoSesion.LOGIN_CORRECTO);
          servicios.DtUsuario dtUsuario = (DtUsuario) port.getDtUsuario(nick).getContenido();
          request.getSession().setAttribute("USUARIO_LOGEADO", dtUsuario);
          request.getRequestDispatcher("WEB-INF/pages/inicio.jsp").forward(request,
              response);
        } else {
          request.getSession().setAttribute("LOGIN", EstadoSesion.LOGIN_INCORRECTO);
          request.getRequestDispatcher("index.jsp").forward(request,
              response);
        }
      }
    } else {
      if (request.getParameter("CERRAR_SESION") == null) {
        response.sendRedirect("WEB-INF/pages/inicio.jsp");
      } else if (request.getParameter("CERRAR_SESION").equals("CONFIRM")) {
        request.getSession().setAttribute("LOGIN", EstadoSesion.NO_LOGIN);
        request.getSession().setAttribute("USUARIO_LOGEADO", null);
        response.sendRedirect("Inicio");
      }
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    if (request.getSession().getAttribute("LOGIN")==null || !request.getSession().getAttribute("LOGIN").equals(EstadoSesion.LOGIN_CORRECTO))
    {    processRequest(request, response); }
    else {
      request.getRequestDispatcher("WEB-INF/pages/inicio.jsp").forward(request,
          response);
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    if (request.getSession().getAttribute("LOGIN")==null || !request.getSession().getAttribute("LOGIN").equals(EstadoSesion.LOGIN_CORRECTO))
    {    processRequest(request, response); }
    else {
      request.getRequestDispatcher("WEB-INF/pages/inicio.jsp").forward(request,
          response);
    }
  }

}