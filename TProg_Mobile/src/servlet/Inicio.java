package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.EstadoSesion;

@WebServlet("/Inicio")
public class Inicio extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public Inicio() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    if (request.getSession().getAttribute("LOGIN")==null || !request.getSession().getAttribute("LOGIN").equals(EstadoSesion.LOGIN_CORRECTO))
    {
    iniciar(request, response);
    request.getRequestDispatcher("index.jsp").forward(request, response);
  } else {
    request.getRequestDispatcher("WEB-INF/pages/inicio.jsp").forward(request,
        response);
  }
  }

  private void iniciar(HttpServletRequest request, HttpServletResponse response) {
    //if (request.getSession().getAttribute("LOGIN") == null) {
      request.getSession().setAttribute("LOGIN", EstadoSesion.NO_LOGIN);
    //}
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
