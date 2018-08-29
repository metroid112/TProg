package interfaces;

public interface IListas {

	public void altaListaParticular(String nombre, String usuario, boolean visibilidad);
	
	public void altaListaDefecto(String nombre);
	
	public  String[] listarListasUsuario(String usuario);
	
	public  String[] listarListasParticularUsuario(String usuario);
	
	public void guardarCambios(String nomLis,String usuario,boolean visible);
}
