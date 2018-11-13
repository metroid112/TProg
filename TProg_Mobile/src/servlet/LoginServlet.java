package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
        response.getWriter().println(nick);
        String pass = (String) request.getParameter("pass");
        response.getWriter().println(pass);
        PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();
        if (port.checkLogin(nick, pass)) {
          request.getSession().setAttribute("LOGIN", EstadoSesion.LOGIN_CORRECTO);
          servicios.DtUsuario dtUsuario = (DtUsuario) port.getDtUsuario(nick).getContenido();
          request.getSession().setAttribute("USUARIO_LOGEADO", dtUsuario);
          request.getRequestDispatcher("WEB-INF/pages/listar_videos.jsp").forward(request,
              response);
        } else {
          request.getSession().setAttribute("LOGIN", EstadoSesion.LOGIN_INCORRECTO);
          request.getRequestDispatcher("index.jsp").forward(request,
              response);
        }
      }
    } else {
      if (request.getParameter("CERRAR_SESION") == null) {
        response.sendRedirect("WEB-INF/pages/listar_videos.jsp");
      } else if (request.getParameter("CERRAR_SESION").equals("CONFIRM")) {
        request.getSession().setAttribute("LOGIN", EstadoSesion.NO_LOGIN);
        request.getSession().setAttribute("USUARIO_LOGEADO", null);
        response.sendRedirect("Inicio");
      }
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