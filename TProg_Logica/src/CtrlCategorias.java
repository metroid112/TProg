
public class CtrlCategorias {
	
	private static CtrlCategorias instancia;
	
	private CtrlCategorias(){
		
	}
	
	public static CtrlCategorias getInstancia() {
		if (instancia == null)  {
			instancia = new CtrlCategorias();
		}
		return instancia;
	}
	
}
