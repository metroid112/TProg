package servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatypes.*;
import interfaces.Fabrica;
import interfaces.IListas;
import interfaces.IVideos;
import utils.EstadoSesion;

/**
 * Servlet implementation class ListarListaServlet
 */
@WebServlet("/ListarListaServlet")
public class ListarListaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarListaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
      if (request.getSession().getAttribute("LOGIN") == null || request.getSession().getAttribute("LOGIN").equals(EstadoSesion.NO_LOGIN)){
        response.sendRedirect("/Inicio");
      }
      else{
        IListas ctrlListas = Fabrica.getIListas();
        IVideos ctrlVideos = Fabrica.getIVideos();
        String nickUsuario = ((DtUsuario) request.getSession().getAttribute("USUARIO_LOGEADO")).nick;
        String[] listasParticulares = ctrlListas.listarListasParticularUsuario(nickUsuario);
        request.setAttribute("LISTAS_PARTICULARES", listasParticulares);
        String[] listasPorDefecto = ctrlListas.listarListasDefectoUsuario(nickUsuario);
        request.setAttribute("LISTAS_POR_DEFECTO", listasPorDefecto);
        DtVideo[] listaDeVideos = ctrlVideos.listarTodosLosVideos(nickUsuario);
        request.setAttribute("LISTA_DE_VIDEOS", listaDeVideos);
        request.getRequestDispatcher("/WEB-INF/pages/agregar_video_a_lista_de_reproduccion.jsp").forward(request, response);  
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


