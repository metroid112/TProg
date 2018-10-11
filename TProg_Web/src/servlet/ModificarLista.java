package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatypes.DtLista;
import datatypes.DtUsuario;
import excepciones.NotFoundException;
import interfaces.Fabrica;
import interfaces.IListas;
import utils.EstadoSesion;

/**
 * Servlet implementation class ModificarLista
 */
@WebServlet("/ModificarLista")
public class ModificarLista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarLista() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
      IListas ctrlListas = Fabrica.getIListas();
      if ((request.getSession().getAttribute("USUARIO_LOGEADO") != null) && 
          (request.getSession().getAttribute("LOGIN").equals(EstadoSesion.LOGIN_CORRECTO)) &&
          (request.getParameter("modificarLista") != null)) {
            String usuario = ((DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO")).nick;
            String idLista = (String) request.getParameter("lista");
            try {
              DtLista lista = ctrlListas.getDt(Integer.parseInt(idLista));
              Boolean visibilidad = !(lista.isVisible());
              ctrlListas.guardarCambios(lista.getNombre(), usuario, visibilidad);
              request.setAttribute("EXITO", "¡Se ha modificado la visibilidad de la lista seleccionada con éxito!");
              request.getRequestDispatcher("/WEB-INF/extras/exito.jsp").forward(request, response);
            } catch (NumberFormatException e) {
              e.printStackTrace();
            } catch (NotFoundException e) {
              e.printStackTrace();
            }
          }
      else if ((request.getSession().getAttribute("USUARIO_LOGEADO") != null) && 
          (request.getSession().getAttribute("LOGIN").equals(EstadoSesion.LOGIN_CORRECTO))) {
        String usuario = ((DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO")).nick;
        request.setAttribute("LISTAS", ctrlListas.getDtListasParticularesUsuario(usuario));
        request.setAttribute("USUARIO", usuario);
        request.getRequestDispatcher("/WEB-INF/pages/modificar_lista.jsp").forward(request, response);
      }
      else {
        response.sendRedirect("/Inicio");
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
