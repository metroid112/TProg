
public class CtrlUsuariosCanales {

	private static CtrlUsuariosCanales instancia = null;
	
	private CtrlUsuariosCanales() {
		
	}
	
	public static CtrlUsuariosCanales getCtrlUsuariosCanales() {
		if (instancia == null) {
			instancia = new CtrlUsuariosCanales();
		}
		return instancia;
	}
	
}
