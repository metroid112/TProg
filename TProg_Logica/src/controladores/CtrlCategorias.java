package controladores;

import interfaces.ICategorias;
import java.lang.Exception;
import manejadores.ManejadorCategorias;

public class CtrlCategorias implements ICategorias {
	
	private ManejadorCategorias manejadorCategorias = ManejadorCategorias.getManejadorCategorias();
	
	public CtrlCategorias() {
		
	}
	
	public void altaCategoria(String s) throws Exception{
		manejadorCategorias.altaCategoria(s);
	}
}
