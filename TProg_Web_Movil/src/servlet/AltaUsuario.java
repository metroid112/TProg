package servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import interfaces.Fabrica;
import interfaces.ICategorias;
import interfaces.IUsuariosCanales;

@WebServlet("/AltaUsuario")
@MultipartConfig
public class AltaUsuario extends HttpServlet {
  private static final long serialVersionUID = 1L;

  private ICategorias ctrlCategorias = Fabrica.getICategorias();
  private IUsuariosCanales ctrlUsuarios = Fabrica.getIUsuariosCanales();
  
  public AltaUsuario() {
    super();
  }

  private void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    switch ((String) request.getParameter("STATE")) {
      case "LOAD":
        volver(request, response);
        break;
      case "ALTA":
        boolean error = false;
        String pass = request.getParameter("pass");
        String passConfirm = request.getParameter("passConfirm");
        String nickname = request.getParameter("nick");
        String correo = request.getParameter("mail");
        Part imgFile = request.getPart("img");
        String imagenPath = null;
        if (imgFile.getSize() != 0) {
          String imgFileName = imgFile.getSubmittedFileName();
          InputStream imgFileContent = imgFile.getInputStream();
          File pathImgUsuario = new File(getServletContext().getRealPath("/"), "img/usuarios");
          if (!pathImgUsuario.isDirectory()) {
            pathImgUsuario.mkdirs();
          }        
          File imgUsuario = new File(pathImgUsuario, imgFileName);
          try (InputStream input = imgFileContent) {
            Files.copy(input, imgUsuario.toPath(), StandardCopyOption.REPLACE_EXISTING);          
          }
          imagenPath = "img/usuarios/" + imgFile.getSubmittedFileName();
        } else {
          imagenPath = "img/usuarios/null.JPG"; 
        }
        if (!pass.equals(passConfirm)) {
          request.setAttribute("ERROR_PASS", true);
          error = true;
        }
        if (ctrlUsuarios.existeUsuario(nickname)) {
          request.setAttribute("ERROR_NICK", true);
          error = true;
        }
        if (ctrlUsuarios.existeUsuarioMail(correo)) {
          request.setAttribute("ERROR_MAIL", true);
          error = true;
        }
        if (error) {
          volver(request, response);
        } else {
          String nombre = request.getParameter("nombre");
          String apellido = request.getParameter("apellido");
          DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
          Date fechaNacimiento = null;
          try {
            fechaNacimiento = formatoFecha.parse(request.getParameter("fecha"));
          } catch (ParseException e) {
            // TODO excepcion
          }
          String nombreCanal;
          if (request.getParameter("nombreCanal").equals("")) {
            nombreCanal = nickname;
          } else {
            nombreCanal = request.getParameter("nombreCanal");
          }
          String descripcionCanal = request.getParameter("descripcion");
          String categoria = request.getParameter("categoria");
          Boolean visible;
          if (request.getParameter("visibilidad").equals("Privado")) {
            visible = false;
          } else {
            visible = true;
          }
          Fabrica.getIUsuariosCanales().altaUsuario(nickname, nombre, apellido, correo,
              fechaNacimiento,
              imagenPath,
              nombreCanal, descripcionCanal, categoria, visible, passConfirm);
          response.sendRedirect("Inicio");
        }
        break;
      default:
        response.sendRedirect("WEB-INF/error/error500.jsp");
    }
  }

  private void volver(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String[] listaCategorias = ctrlCategorias.listarCategorias();
    request.setAttribute("CATEGORIAS", listaCategorias);
    request.getRequestDispatcher("WEB-INF/pages/alta_usuario.jsp").forward(request, response);
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
