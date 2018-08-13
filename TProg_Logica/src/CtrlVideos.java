
public class CtrlVideos implements IVideos {

	private static CtrlVideos instancia = null;
	
	private CtrlVideos() {
		
	}
	
	public static CtrlVideos getCtrlVideos() {
		if (instancia == null) {
			instancia = new CtrlVideos();
		}
		return instancia;
	}
	


}
