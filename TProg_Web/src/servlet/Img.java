package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicios.Publicador;
import servicios.PublicadorService;

@WebServlet("/Img")
public class Img extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Img() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String imgId = request.getParameter("id");
		PublicadorService service = new PublicadorService();
		Publicador port = service.getPublicadorPort();
		byte[] imgByte = port.getImagen(imgId);
		response.getOutputStream().write(imgByte);
		response.getOutputStream().close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
