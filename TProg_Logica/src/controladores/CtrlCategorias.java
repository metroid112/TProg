package controladores;

import interfaces.ICategorias;
import java.lang.Exception;
import manejadores.ManejadorCategorias;

public class CtrlCategorias implements ICategorias {
	
	private ManejadorCategorias manejadorCategorias = ManejadorCategorias.getManejadorCategorias();
	
	public CtrlCategorias() {
		
	}
	
	public void altaCategoria(String nombreCategoria) throws Exception{
		manejadorCategorias.altaCategoria(nombreCategoria);
	}
	
	public String[] listarCategorias(){
		return manejadorCategorias.toArray();
	}
}
