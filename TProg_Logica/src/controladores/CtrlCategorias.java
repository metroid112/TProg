package controladores;

import interfaces.ICategorias;
import clases.Categoria;
import excepciones.DuplicateClassException;

import java.lang.Exception;
import manejadores.ManejadorCategorias;

public class CtrlCategorias implements ICategorias {
	
	private ManejadorCategorias manejadorCategorias = ManejadorCategorias.getManejadorCategorias();
	
	public CtrlCategorias() {
		
	}
	
	public void altaCategoria(String nombreCategoria) throws DuplicateClassException {
		manejadorCategorias.altaCategoria(nombreCategoria);
	}
	
	public String[] listarCategorias(){
		return manejadorCategorias.toArray();
	}
	
	public String[] getInfoVideos(String s){
		Categoria c = manejadorCategorias.get(s);
		return c.getInfoVideos();
	}
	
	public String[] getInfoListas(String s){
		Categoria c = manejadorCategorias.get(s);
		return c.getInfoListas();
	}
}
