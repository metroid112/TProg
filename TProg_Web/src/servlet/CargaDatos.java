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
    // TODO Auto-generated constructor stub
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
    
    if (request.getSession().getAttribute("CARGA_DATOS") == null) {
      request.getSession().setAttribute("CARGA_DATOS", false);
    }
    
    if (!(boolean) request.getSession().getAttribute("CARGA_DATOS")) {
      try {
        request.getSession().setAttribute("CARGA_DATOS", true);
        Fabrica.getIDatos().cargaDatos();
      } catch (ParseException exception) {
        // TODO Auto-generated catch block
        exception.printStackTrace();
      }
    }
    request.getRequestDispatcher("/index.jsp").forward(request, response);
  }
}
