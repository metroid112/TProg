package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatypes.DtUsuario;
import excepciones.DuplicateClassException;
import excepciones.NotFoundException;
import interfaces.Fabrica;

@WebServlet("/AltaVideo")
public class AltaVideo extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public AltaVideo() {
    super();
    // TODO Auto-generated constructor stub
  }

  private void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    if (request.getParameter("STATE") == null) {
      response.sendRedirect("/jsp/error500.jsp");
    } else {
      if (request.getParameter("STATE").equals("LOAD")) {
        DtUsuario user = (DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO");
        if (user == null) {
          request.setAttribute("ERROR_3", "USUARIO NO LOGEADO");
          request.getRequestDispatcher("/jsp/alta_video.jsp").forward(request, response);
        }
        // TODO: cargar categorias
        request.getRequestDispatcher("/jsp/alta_video.jsp").forward(request, response);
      } else {
        String nick = "";
        DtUsuario user = (DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO");
        if (user == null) {
          request.setAttribute("ERROR_3", "USUARIO NO LOGEADO");
          request.getRequestDispatcher("/jsp/alta_video.jsp").forward(request, response);
        }
        nick = user.nick;
        Date fecha = new Date();
        String nombre = request.getParameter("nombre");
        String url = request.getParameter("url");
        String descripcion = request.getParameter("descripcion");
        String categoria = request.getParameter("categoria");
        String duracionH = request.getParameter("duracionH");
        String duracionM = request.getParameter("duracionM");
        String duracionS = request.getParameter("duracionS");
        Duration duracion =
            Duration.parse("PT" + duracionH + "H" + duracionM + "M" + duracionS + "S");
        try {
          fecha = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fecha"));
        } catch (ParseException exception) {
          exception.printStackTrace();
        }
        try {
          Fabrica.getIVideos().altaVideo(nick, nombre, descripcion, duracion, url, categoria, fecha,
              false);
        } catch (DuplicateClassException exception) {
          request.setAttribute("ERROR_1", exception.getMessage());
          request.getRequestDispatcher("/jsp/alta_video.jsp").forward(request, response);
        } catch (NotFoundException exception) {
          request.setAttribute("ERROR_2", exception.getMessage());
          request.getRequestDispatcher("/jsp/alta_video.jsp").forward(request, response);
        }
        response.sendRedirect("/index.jsp");
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
