
public class CtrlListas implements IListas {

	private static CtrlListas instancia = null;
	
	private CtrlListas() {
		
	}
	
	public static CtrlListas getCtrlListas() {
		if (instancia == null) {
			instancia = new CtrlListas();
		}
		return instancia;
	}
	

}
