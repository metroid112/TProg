
public class CtrlCategorias {
	
	private static CtrlCategorias instancia;
	
	private CtrlCategorias(){
		
	}
	
	public static CtrlCategorias getCtrlCategorias() {
		if (instancia == null)  {
			instancia = new CtrlCategorias();
		}
		return instancia;
	}
	
}
