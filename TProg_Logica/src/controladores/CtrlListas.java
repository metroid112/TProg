package controladores;

import interfaces.IListas;
import manejadores.ManejadorListas;
import clases.Lista;
import clases.ListaDefecto;
import clases.ListaParticular;

public class CtrlListas implements IListas {

	private ManejadorListas manejadorListas = ManejadorListas.getManejadorListas();
	private CtrlUsuariosCanales controladorUsuariosCanales = new CtrlUsuariosCanales();
	
	public void ingresarListaParticular(String nombre, String usuario, boolean visibilidad){
		
		//controladorUsuCan.ingresarListaParticular(nombre, usuario, visibilidad);
		/*	Buscar al usuario y convoca la funcion ingresarListaParticular(nombre, visibilidad) sobre su canal*/
	}
	
	public void altaListaDefecto(String nombreListaDefecto){
		
		manejadorListas.add(nombreListaDefecto); //guarda el nombre de la lista
		
		//controladorUsuCan.ingresarListaDefecto(nombre);
		/*	Itera en todos los usuarios y convoca ingresarListaDefecto(String nombre) sobre su canal*/
	}
}
