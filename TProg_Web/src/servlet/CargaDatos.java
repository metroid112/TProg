package servlet;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaces.Fabrica;

@WebServlet("/CargaDatos")
public class CargaDatos extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public CargaDatos() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
  }

  private void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      Fabrica.getIDatos().cargaDatos();
    } catch (ParseException exception) {
      exception.printStackTrace();
    }
    request.getRequestDispatcher("index.jsp").forward(request, response);
  }
}
