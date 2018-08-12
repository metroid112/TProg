
public class CtrlUsuariosCanales {

	private static CtrlUsuariosCanales instancia;
	
	private CtrlUsuariosCanales() {
		
	}
	
	public static CtrlUsuariosCanales getCtrlVideos() {
		if (instancia == null) {
			instancia = new CtrlUsuariosCanales();
		}
		return instancia;
	}
	
}
