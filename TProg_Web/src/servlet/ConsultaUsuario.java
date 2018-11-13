package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatypes.DtUsuario;
import interfaces.Fabrica;
import servicios.Publicador;
import servicios.PublicadorService;

@WebServlet("/ConsultaUsuario")
public class ConsultaUsuario extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ConsultaUsuario() {
    super();
    // TODO Auto-generated constructor stub
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    PublicadorService service = new PublicadorService();
    Publicador port = service.getPublicadorPort();
    
    switch (request.getParameter("STATE")) {
      case "LISTAR":
        request.setAttribute("STATE", "LISTAR");
        request.setAttribute("USUARIOS", port.listarNombresUsuarios());
        request.getRequestDispatcher("/WEB-INF/pages/consulta_usuario.jsp").forward(request,
            response);
        break;
      case "INFO":
        DtUsuario usuarioLogueado =
            (DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO");
        String nombreUsuario = (String) request.getParameter("usuario");
        request.setAttribute("STATE", "INFO");
        request.setAttribute("USUARIO",
            port.getDtUsuario(nombreUsuario));
        request.setAttribute("VIDEOS",
            port.getDtVideosPublicos(nombreUsuario));
        request.setAttribute("LISTAS",
            port.getDtListasParticularesPublicasUsuario(nombreUsuario));
        request.setAttribute("SEGUIDORES",
            port.getSeguidores(nombreUsuario));
        request.setAttribute("SEGUIDOS",
            port.getSeguidos(nombreUsuario));
        if (usuarioLogueado != null) {
          request.setAttribute("SIGUE",
              port.isSeguidor(usuarioLogueado.nick, nombreUsuario));
        }
        request.getRequestDispatcher("/WEB-INF/pages/consulta_usuario.jsp").forward(request,
            response);
        break;
      default:
        request.setAttribute("STATE", null);
        request.getRequestDispatcher("/WEB-INF/error/error500.jsp").forward(request, response);
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

}
