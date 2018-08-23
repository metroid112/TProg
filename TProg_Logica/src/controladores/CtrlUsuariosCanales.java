package controladores;

import interfaces.IUsuariosCanales;
import manejadores.ManejadorUsuarios;

public class CtrlUsuariosCanales implements IUsuariosCanales {

	private ManejadorUsuarios manejadorUsuario = ManejadorUsuarios.getManejadorUsuarios();
}
