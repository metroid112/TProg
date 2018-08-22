package interfaces;

import controladores.CtrlCategorias;
import controladores.CtrlListas;
import controladores.CtrlUsuariosCanales;
import controladores.CtrlVideos;
import manejadores.ManejadorCategorias;
import manejadores.ManejadorListas;
import manejadores.ManejadorUsuarios;

public class Fabrica {

	private static Fabrica instancia = null;

	private Fabrica() {
	}

	public static Fabrica getFabrica() {
		if (instancia == null) {
			instancia = new Fabrica();
		}
		return instancia;
	}

	public IVideos getIVideos() {
		return new CtrlVideos();
	}

	public IUsuariosCanales getIUsuariosCanales() {
		return new CtrlUsuariosCanales();
	}

	public IListas getIListas() {
		return new CtrlListas();
	}

	public ICategorias getICategorias() {
		return new CtrlCategorias();
	}
	
	public IManejador getIManejadorCategorias() {
		return ManejadorCategorias.getManejadorCategorias();
	}
	
	public IManejador getIManejadorListas() {
		return ManejadorListas.getManejadorListas();
	}
	
	public IManejador getIManejadorUsuarios() {
		return ManejadorUsuarios.getManejadorUsuarios();
	}
}
