package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
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

import servicios.DtCategoria;
import servicios.DtUniversal;
import servicios.DtUsuario;
import servicios.DuplicateClassException_Exception;
import servicios.Publicador;
import servicios.PublicadorService;

@WebServlet("/ModificarUsuario")
@MultipartConfig
public class ModificarUsuario extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ModificarUsuario() {
    super();
  }

  @SuppressWarnings("unchecked")
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    PublicadorService service = new PublicadorService();
    Publicador port = service.getPublicadorPort();
    List<DtCategoria> categorias = (List<DtCategoria>) (List<?>) port.listarCategorias().getListaDt();
    request.setAttribute("CATEGORIAS", categorias);
    switch((String) request.getParameter("STATE")) {
      case "LOAD":
        request.getRequestDispatcher("WEB-INF/pages/modificar_usuario.jsp").forward(request, response);
        break;
      case "MODIFICAR":
        String password = request.getParameter("pass");
        String passwordConfirm = request.getParameter("passConfirm");
        if (!password.equals(passwordConfirm)) {
          request.getRequestDispatcher("WEB-INF/pages/modificar_usuario.jsp").forward(request, response);
        } else {
          DtUsuario usuario = (DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO");
          DtUsuario usuarioModificado = new DtUsuario();
          Part imgFile = request.getPart("img");
          byte[] img = null;
          if (imgFile.getSize() != 0) {
            InputStream imgFileContent = imgFile.getInputStream();
            img = IOUtils.toByteArray(imgFileContent);
          }
          String nick = request.getParameter("nick");
          String nombre = request.getParameter("nombre");
          String apellido = request.getParameter("apellido");
          String mail = request.getParameter("mail");
          DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
          Date fechaNacimiento = null;
          try {
            fechaNacimiento = formatoFecha.parse(request.getParameter("fecha"));
          } catch (ParseException e) {
            // TODO excepcion
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
          String nombreCanal = request.getParameter("nombreCanal");
          String descripcionCanal = request.getParameter("descripcion");
          boolean visibilidad = request.getParameter("visibilidad").equals("privado") ? true : false;
          String categoria = request.getParameter("categoria");
          usuarioModificado.setIdImagen(img == null ? usuario.getIdImagen() : "0.JPG");
          usuarioModificado.setNick(nick);
          usuarioModificado.setNombre(nombre);
          usuarioModificado.setApellido(apellido);
          usuarioModificado.setCorreo(mail);
          usuarioModificado.setFechaNacimiento(fechaNacimientoXML);
          usuarioModificado.setCanal(nombreCanal);
          usuarioModificado.setDescripcionCanal(descripcionCanal);
          usuarioModificado.setPrivado(visibilidad);
          usuarioModificado.setCategoria(categoria);
          try {
            port.modificarUsuario(usuario.getNick(), (DtUniversal) usuarioModificado, img);
            request.getSession().setAttribute("USUARIO_LOGEADO", usuarioModificado);
            response.sendRedirect("Inicio");
          } catch (DuplicateClassException_Exception exception) {
            // TODO Auto-generated catch block
            exception.printStackTrace();
          }
        }
        break;
      default:
        response.sendRedirect("WEB-INF/error/error500.jsp");
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

}
