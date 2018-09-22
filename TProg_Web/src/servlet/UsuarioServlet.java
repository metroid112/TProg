package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public UsuarioServlet() {
    super();
    // TODO Auto-generated constructor stub
  }
  
  private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO processRequest
  }
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request,response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request,response);
  }

}
