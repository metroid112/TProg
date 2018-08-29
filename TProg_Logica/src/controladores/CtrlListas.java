package controladores;

import interfaces.IListas;
import manejadores.ManejadorListas;
import manejadores.ManejadorUsuarios;

import java.util.HashMap;
import java.util.Map;

import clases.ListaDefecto;
import clases.ListaParticular;
import clases.Canal;
import clases.Usuario;
import clases.Video;

public class CtrlListas implements IListas {

	private ManejadorUsuarios manejadorUsuarios = ManejadorUsuarios.getManejadorUsuarios();
	private ManejadorListas manejadorListas = ManejadorListas.getManejadorListas();

	public void altaListaParticular(String nombre, String usuario, boolean visibilidad){ //busco el usuario y le pido a su canal que haga el resto
		
		Usuario usuarioObjetivo = manejadorUsuarios.get(usuario);
		usuarioObjetivo.getCanal().ingresarListaParticular(nombre,visibilidad);
		
	}
	
	public void altaListaDefecto(String nombreListaDefecto){
		
		manejadorListas.add(nombreListaDefecto);
		//manejadorListas.notifyAll();
		manejadorUsuarios.agregarListaDefecto(nombreListaDefecto);
		

		//manejadorUsuarios.ingresarListaDefecto(nombreListaDefecto);

		/*	Itera en todos los usuarios y convoca ingresarListaDefecto(String nombre) sobre su canal*/
	}
	
	public  String[] listarListasUsuario(String usuario){
		
		Usuario usuarioObjetivo = manejadorUsuarios.get(usuario);
		Canal canalObjetivo = usuarioObjetivo.getCanal();
		
		return canalObjetivo.getListaUsuario();

		}
		
	}

