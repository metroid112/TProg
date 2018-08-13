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
	/////////////// Pato: Mas tarde se sustituye Ctrl por interfaz?
	public CtrlVideos getCtrlVideos() {
		return CtrlVideos.getCtrlVideos();
	}
	
	public CtrlUsuariosCanales getCtrlUsuariosCanales() {
		return CtrlUsuariosCanales.getCtrlUsuariosCanales();
	}
	
	public CtrlListas getCtrlListas() {
		return CtrlListas.getCtrlListas();
	}
	
	public CtrlCategorias getCtrlCategorias() {
		return CtrlCategorias.getCtrlCategorias();
	}
}
