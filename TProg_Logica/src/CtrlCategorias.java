
public class CtrlCategorias implements ICategorias {
	
	private static CtrlCategorias instancia = null;
	
	private CtrlCategorias(){
		
	}
	
	public static CtrlCategorias getCtrlCategorias() {
		if (instancia == null)  {
			instancia = new CtrlCategorias();
		}
		return instancia;
	}
	
}
