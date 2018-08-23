package controladores;

import interfaces.IListas;
import manejadores.ManejadorListas;
import clases.Lista;
import clases.ListaDefecto;

public class CtrlListas implements IListas {

	private ManejadorListas manejadorListas = ManejadorListas.getManejadorListas();
	private CtrlUsuariosCanales controladorUsuCan = new CtrlUsuariosCanales();
	
	public void ingresarListaParticular(String nombre, String usuario, boolean visibilidad){
		//controladorUsuCan.ingresarListaParticular(nombre, usuario, visibilidad);
	}
	
	public void ingresarListaDefecto(String nombre){
		
		//lo crea el manejador
		//se notifica a todos los usuarios
		//se crea en cada usuario
	}
}
