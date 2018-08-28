package interfaces;

import controladores.CtrlCategorias;
import controladores.CtrlListas;
import controladores.CtrlUsuariosCanales;
import controladores.CtrlVideos;

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

	public IUsuarios getIUsuariosCanales() {
		return new CtrlUsuariosCanales();
	}

	public IListas getIListas() {
		return new CtrlListas();
	}

	public ICategorias getICategorias() {
		return new CtrlCategorias();
	}
}
