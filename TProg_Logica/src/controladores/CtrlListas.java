package controladores;

import interfaces.IListas;
import manejadores.ManejadorListas;
import manejadores.ManejadorUsuarios;
import clases.Usuario;

public class CtrlListas implements IListas {

	private ManejadorUsuarios manejadorUsuarios = ManejadorUsuarios.getManejadorUsuarios();
	private ManejadorListas manejadorListas = ManejadorListas.getManejadorListas();

	public void ingresarListaParticular(String nombre, String usuario, boolean visibilidad){ //busco el usuario y le pido a su canal que haga el resto
		
		Usuario usuarioObjetivo = manejadorUsuarios.get(usuario);
		usuarioObjetivo.getCanal().ingresarListaParticular(nombre,visibilidad);
		
	}
	
	public void ingresarListaDefecto(String nombreListaDefecto){
		

		manejadorListas.add(nombreListaDefecto); //guarda el nombre de la lista
		//manejadorUsuarios.ingresarListaDefecto(nombreListaDefecto);

		/*	Itera en todos los usuarios y convoca ingresarListaDefecto(String nombre) sobre su canal*/
	}
}
