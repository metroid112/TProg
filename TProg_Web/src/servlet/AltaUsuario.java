package servlet;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map.Entry;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaces.Fabrica;

/**
 * Servlet implementation class AltaUsuario
 */
@WebServlet("/AltaUsuario")
public class AltaUsuario extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public AltaUsuario() {
    super();
    // TODO Auto-generated constructor stub
  }

  private void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String pass = (String) request.getParameter("pass");
    String passConfirm = (String) request.getParameter("passConfirm");
    if (!pass.equals(passConfirm)) {
      // response.getWriter().println(request.getParameter("categoria"));
      request.getSession().setAttribute("ERROR_REGISTRO", "Contraseñas no coinciden"); // TODO
                                                                                       // terminar
      // Faltan otros checks
      request.getRequestDispatcher("/WEB-INF/pages/alta_usuario.jsp").forward(request, response);
    } else {

      // https://stackoverflow.com/questions/2422468/how-to-upload-files-to-server-using-jsp-servlet
      // para la imagen ^^
      String nickname = request.getParameter("nick");
      String nombre = request.getParameter("nombre");
      String apellido = request.getParameter("apellido");
      String correo = request.getParameter("mail");
      DateFormat formatoFecha = new SimpleDateFormat("yyyy-mm-dd");
      Date fechaNacimiento = null;
      try {
        fechaNacimiento = formatoFecha.parse(request.getParameter("fecha"));
      } catch (ParseException e) {
        // TODO excepcion
      }
      String imagenPath = "img/usuarios/null.JPG";
      String nombreCanal = request.getParameter("nombreCanal");
      String descripcionCanal = request.getParameter("descripcion");
      String categoria = request.getParameter("categoria");
      Boolean visible;
      if (request.getParameter("visibilidad").equals("Privado")) {
        visible = false;
      } else {
        visible = true;
      }
      Fabrica.getIUsuariosCanales().altaUsuario(nickname, nombre, apellido, correo, fechaNacimiento,
          imagenPath,
          nombreCanal, descripcionCanal, categoria, visible, passConfirm);
      response.sendRedirect("/index.jsp");
    }
    /**
     * TODO: chequear usuarios existentes imagen embellecer chequeo de errores con sesion
     * 
     * 
     */
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.getRequestDispatcher("WEB-INF/pages/alta_usuario.jsp").forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
  }

}
