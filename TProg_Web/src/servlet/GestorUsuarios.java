package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaces.Fabrica;
import interfaces.IUsuariosCanales;

@WebServlet("/GestorUsuarios")
public class GestorUsuarios extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public GestorUsuarios() {
    super();
    // TODO Auto-generated constructor stub
  }

  private void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO processRequest
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // processRequest(request,response);
    response.getWriter().println("hola");
    IUsuariosCanales ctrlUsuarios = Fabrica.getIUsuariosCanales();
    int largo = ctrlUsuarios.listarUsuarios().length;
    String[] usuarios = ctrlUsuarios.listarUsuarios();
    request.setAttribute("USUARIOS_REGISTRADOS", usuarios);
    request.getRequestDispatcher("jsp/listar_usuarios.jsp").forward(request, response);

  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
  }

}
