
public class CtrlUsuariosCanales {

	private static CtrlUsuariosCanales instancia;
	
	private CtrlUsuariosCanales() {
		
	}
	
	public static CtrlUsuariosCanales getCtrlUsuariosCanales() {
		if (instancia == null) {
			instancia = new CtrlUsuariosCanales();
		}
		return instancia;
	}
	
}
