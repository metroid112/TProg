package controladores;

import interfaces.ICategorias;
import java.lang.Exception;
import manejadores.ManejadorCategorias;
import java.util.*;

public class CtrlCategorias implements ICategorias {
	
	private ManejadorCategorias manejadorCategorias = ManejadorCategorias.getManejadorCategorias();
	
	public CtrlCategorias() { // constructor
		
	}
	
	public void altaCategoria(String s) throws Exception{	// metodo
		manejadorCategorias.altaCategoria(s);
	}
	
	public Set<String> listarCategorias(){
		return manejadorCategorias.getCategorias();
	}
}
