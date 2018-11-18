package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.io.IOUtils;

import servicios.Publicador;
import servicios.PublicadorService;

@WebServlet("/AltaUsuario")
@MultipartConfig
public class AltaUsuario extends HttpServlet {
  private static final long serialVersionUID = 1L;

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
        byte[] bytearray = null;
        if (imgFile.getSize() != 0) {
          String imgFileName = imgFile.getSubmittedFileName();
          InputStream imgFileContent = imgFile.getInputStream();
          bytearray = IOUtils.toByteArray(imgFileContent);
        }
        if (!pass.equals(passConfirm)) {
          request.setAttribute("ERROR_PASS", true);
          error = true;
        }
        if (false) { // TODO ajax nick
          request.setAttribute("ERROR_NICK", true);
          error = true;
        }
        if (false) { // TODO ajax correo
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
          String categoria;
          if (request.getParameter("categoria") == "Sin categoría") {
            categoria = null;
          } else {
            categoria = request.getParameter("categoria");
          }
          Boolean visible;
          if (request.getParameter("visibilidad").equals("privado")) {
            visible = false;
          } else {
            visible = true;
          }
          GregorianCalendar fechaNacimientoCal = new GregorianCalendar();
          fechaNacimientoCal.setTime(fechaNacimiento);
          XMLGregorianCalendar fechaNacimientoXML = null;
          try {
            fechaNacimientoXML =
                DatatypeFactory.newInstance().newXMLGregorianCalendar(fechaNacimientoCal);
          } catch (DatatypeConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
          PublicadorService service = new PublicadorService();
          Publicador port = service.getPublicadorPort();
          port.altaUsuario(nickname, nombre, apellido, correo,
              fechaNacimientoXML, bytearray,
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
    PublicadorService service = new PublicadorService();
    Publicador port = service.getPublicadorPort();
    List<String> listaCategorias = port.listarCategorias().getListaAux();
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
