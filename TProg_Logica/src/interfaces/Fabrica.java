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

	public static IVideos getIVideos() {
		return new CtrlVideos();
	}

	public static IUsuariosCanales getIUsuariosCanales() {
		return new CtrlUsuariosCanales();
	}

	public static IListas getIListas() {
		return new CtrlListas();
	}

	public static ICategorias getICategorias() {
		return new CtrlCategorias();
	}
}
