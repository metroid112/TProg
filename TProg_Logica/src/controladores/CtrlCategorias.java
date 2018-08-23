package controladores;

import interfaces.ICategorias;
import manejadores.ManejadorCategorias;

public class CtrlCategorias implements ICategorias {

	ManejadorCategorias manejadorCategorias = ManejadorCategorias.getManejadorCategorias();
}
