
public class CtrlListas {

	private static CtrlListas instancia;
	
	private CtrlListas() {
		
	}
	
	public static CtrlListas getCtrlListas() {
		if (instancia == null) {
			instancia = new CtrlListas();
		}
		return instancia;
	}
	

}
