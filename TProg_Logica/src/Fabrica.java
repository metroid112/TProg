
public class Fabrica {
	
	private static Fabrica instancia;
	
	private Fabrica() {
		
	}
	
	public static Fabrica getFabrica() {
		if (instancia == null) {
			instancia = new Fabrica();
		}
		return instancia;
	}
	

}
