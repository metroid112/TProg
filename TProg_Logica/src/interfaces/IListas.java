package interfaces;

public interface IListas {

	public void altaListaParticular(String nombre, String usuario, boolean visibilidad);
	
	public void altaListaDefecto(String nombre);
	
	public void  listarListas(String usuario);
}
