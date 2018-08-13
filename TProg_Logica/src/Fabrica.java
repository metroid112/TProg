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
		return CtrlVideos.getCtrlVideos();
	}
	
	public IUsuariosCanales getIUsuariosCanales() {
		return CtrlUsuariosCanales.getCtrlUsuariosCanales();
	}
	
	public IListas getIListas() {
		return CtrlListas.getCtrlListas();
	}
	
	public ICategorias getICategorias() {
		return CtrlCategorias.getCtrlCategorias();
	}
}
