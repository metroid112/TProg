package controladores;

import interfaces.IListas;
import manejadores.ManejadorListas;

public class CtrlListas implements IListas {

	private ManejadorListas manejadorListas = ManejadorListas.getManejadorListas();
}
