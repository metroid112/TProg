package controladores;

import interfaces.ICategorias;
import manejadores.ManejadorCategorias;

public class CtrlCategorias implements ICategorias {

	private ManejadorCategorias manejadorCategorias = ManejadorCategorias.getManejadorCategorias();
}
