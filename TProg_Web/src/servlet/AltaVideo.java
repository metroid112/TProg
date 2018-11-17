package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import servicios.DtUsuario;
import servicios.Publicador;
import servicios.PublicadorService;
import excepciones.DuplicateClassException;
import excepciones.NotFoundException;

@WebServlet("/AltaVideo")
public class AltaVideo extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public AltaVideo() {
    super();
    // TODO Auto-generated constructor stub
  }

  private void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    PublicadorService service = new PublicadorService();
    Publicador port = service.getPublicadorPort();
    List<String> listaCategorias = port.listarCategorias().getListaAux();
    request.setAttribute("CATEGORIAS", listaCategorias);
    if (request.getParameter("STATE") == null) {
      response.sendRedirect("/jsp/error500.jsp");
    } else {
      if (request.getParameter("STATE").equals("LOAD")) {
        DtUsuario user = (DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO");
        if (user == null) {
          request.setAttribute("ERROR_3", "USUARIO NO LOGEADO");
        }
        request.getRequestDispatcher("/WEB-INF/pages/alta_video.jsp").forward(request, response);
      } else {
        String nick = "";
        DtUsuario user = (DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO");
        if (user == null) {
          request.setAttribute("ERROR_3", "USUARIO NO LOGEADO");
          request.getRequestDispatcher("/jsp/alta_video.jsp").forward(request, response);
        } else {
          nick = user.getNick();
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
              GregorianCalendar cal = new GregorianCalendar();
              cal.setTime(fecha);
              XMLGregorianCalendar fechaXML = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);

              port.altaVideo(nick, nombre, descripcion, duracion.getSeconds(), url, categoria, fechaXML,  //Categoria temporalmente hardcodeada

                  false);
            } catch (DatatypeConfigurationException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
            }
          // volver a index
          response.sendRedirect("Inicio");
        }
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
