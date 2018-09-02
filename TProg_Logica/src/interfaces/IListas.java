package interfaces;

import dataTypes.DtLista;

public interface IListas {

	public void altaListaParticular(String nombre, String usuario, boolean visibilidad) throws Exception;
	
	public void altaListaDefecto(String nombre) throws Exception;
	
	public  String[] listarListasDefectoUsuario(String usuario);
	
	public  String[] listarListasParticularUsuario(String usuario);
	
	public void guardarCambios(String nomLis,String usuario,boolean visible);
	
	public void agregarVideoLista(String usuario, String video, String usuarioObjetivo, String lista, boolean defecto);

	public DtLista getDt(String lista, String usuario) throws Exception;
	
	public void quitarVideoLista(String usuario, String video, String lista,boolean deefecto);
}
