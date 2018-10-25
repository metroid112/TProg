package com.gamebook.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gamebook.exceptions.UsuarioNoEncontrado;
import com.gamebook.model.EstadoSesion;
import com.gamebook.model.GestorUsuario;
import com.gamebook.model.Usuario;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        HttpSession objSesion = request.getSession();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        EstadoSesion nuevoEstado;

		// chequea contraseña
		try {
			Usuario usr = GestorUsuario.getInstance().buscarUsuario(login);
			if(!usr.getPassword().equals(password))
				nuevoEstado = EstadoSesion.LOGIN_INCORRECTO;
			else {
				nuevoEstado = EstadoSesion.LOGIN_CORRECTO;
				// setea el usuario logueado
				request.getSession().setAttribute("usuario_logueado", usr.getEmail());
			}
		} catch(UsuarioNoEncontrado ex){
			nuevoEstado = EstadoSesion.LOGIN_INCORRECTO;
		}
		
        objSesion.setAttribute("estado_sesion", nuevoEstado);
		
		// redirige a la página principal para que luego rediriga a la página
		// que corresponde
        RequestDispatcher dispatcher = request.getRequestDispatcher("/home");
        dispatcher.forward(request, response);
    } 
    
	/**
	 * Devuelve el usuario logueado
	 * @param request
	 * @return
	 * @throws UsuarioNoEncontrado 
	 */
	static public Usuario getUsuarioLogueado(HttpServletRequest request)
			throws UsuarioNoEncontrado
	{
		return GestorUsuario.getInstance().buscarUsuario(
				(String) request.getSession().getAttribute("usuario_logueado")
			);
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
	}

}
