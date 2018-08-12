
public class CtrlVideos {

	private static CtrlVideos instancia;
	
	private CtrlVideos() {
		
	}
	
	public static CtrlVideos getCtrlVideos() {
		if (instancia == null) {
			instancia = new CtrlVideos();
		}
		return instancia;
	}
	


}
