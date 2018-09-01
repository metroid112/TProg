package controladores;

import interfaces.IListas;
import manejadores.ManejadorListas;
import manejadores.ManejadorUsuarios;

import java.lang.Exception;
import java.util.HashMap;
import java.util.Map;

import clases.ListaDefecto;
import clases.ListaParticular;
import clases.Canal;
import clases.Categoria;
import clases.Usuario;
import clases.Video;

public class CtrlListas implements IListas {

	private ManejadorUsuarios manejadorUsuarios = ManejadorUsuarios.getManejadorUsuarios();
	private ManejadorListas manejadorListas = ManejadorListas.getManejadorListas();

	public void altaListaParticular(String nombre, String usuario, boolean visibilidad) throws Exception{ //busco el usuario y le pido a su canal que haga el resto
		
		Usuario usuarioObjetivo = manejadorUsuarios.get(usuario);
		if(!usuarioObjetivo.getCanal().getListaParticulares().containsKey(nombre)){
		
		usuarioObjetivo.getCanal().ingresarListaParticular(nombre,visibilidad);
		}
		else{
			throw new Exception("El usuario " + usuario + " ya posee una lista por defecto con nombre: " + nombre);
		}
		
	}
	
	public void altaListaDefecto(String nombreListaDefecto) throws Exception{ //	Itera en todos los usuarios y convoca ingresarListaDefecto(String nombre) sobre su canal
		
		if(!manejadorListas.existeLista(nombreListaDefecto)){
		manejadorListas.add(nombreListaDefecto);
		//manejadorListas.notifyAll();
		manejadorUsuarios.agregarListaDefecto(nombreListaDefecto);
		}
		else{
			throw new Exception("Ya existe una lista por defecto con nombre " + nombreListaDefecto);		
		}		
	}
	
	public  String[] listarListasDefectoUsuario(String usuario){
		
		Usuario usuarioObjetivo = manejadorUsuarios.get(usuario);
		Canal canalObjetivo = usuarioObjetivo.getCanal();
		
		return canalObjetivo.getListaDefectoUsuario();

	}
	
	public  String[] listarListasParticularUsuario(String usuario){
		
		Usuario usuarioObjetivo = manejadorUsuarios.get(usuario);
		Canal canalObjetivo = usuarioObjetivo.getCanal();
		
		return canalObjetivo.getListaParticularUsuario();

		}
	
	public void guardarCambios(String nomLis, String usuario, boolean visible){
		Usuario usuarioObjetivo = manejadorUsuarios.get(usuario);
		usuarioObjetivo.getCanal().guardarCambios(nomLis,visible);
	}
	
	public void agregarVideoLista(String usuario, String video, String usuarioObjetivo, String lista, boolean defecto){
		Usuario uInicial = manejadorUsuarios.get(usuario);
		Usuario uObjetivo = manejadorUsuarios.get(usuarioObjetivo);
		
		Video videoObj = uInicial.getCanal().getVideoCanal(video);
		Categoria categoriasVideo = videoObj.getCategoria();
		
		
		if(){
		//pregunto si el video ya xiste en esa lista
		//busco la lista y chequeo sus categorias
		// inserto el video
		}
		
	}
	
	}

