package controladores;

import interfaces.IListas;
import manejadores.ManejadorListas;
import manejadores.ManejadorUsuarios;
import clases.Lista;
import clases.ListaDefecto;

public class CtrlListas implements IListas {

	private ManejadorUsuarios manejadorUsuarios = ManejadorUsuarios.getManejadorUsuarios();
	private ManejadorListas manejadorListas = ManejadorListas.getManejadorListas();
	
	
	public void ingresarListaParticular(String nombre, String usuario, boolean visibilidad){
		
		//controladorUsuCan.ingresarListaParticular(nombre, usuario, visibilidad);
		/*	Buscar al usuario y convoca la funcion ingresarListaParticular(nombre, visibilidad) sobre su canal*/
	}
	
	public void ingresarListaDefecto(String nombre){
		
		manejadorListas.add(nombre); //guarda el nombre de la lista
		//pendiente agregarle notify
		//controladorUsuCan.ingresarListaDefecto(nombre);
		/*	Itera en todos los usuarios y convoca ingresarListaDefecto(String nombre) sobre su canal*/
	}
}
