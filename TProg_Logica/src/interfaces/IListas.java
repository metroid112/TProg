package interfaces;

import dataTypes.DtLista;

public interface IListas {

	public void agregarVideoLista(String usuario, String video, String usuarioObjetivo, String lista, boolean defecto);

	public void altaListaDefecto(String nombre) throws Exception;

	public void altaListaParticular(String nombre, String usuario, boolean visibilidad) throws Exception;

	public DtLista getDt(String lista, String usuario) throws Exception;

	public String getDueñoVideo(String dueñoLista, String nombreLista, String nombreVid) throws Exception;

	public void guardarCambios(String nomLis, String usuario, boolean visible);

	public String[] listarListasDefectoUsuario(String usuario);

	public String[] listarListasParticularUsuario(String usuario);

	public void quitarVideoLista(String usuario, String video, String ownerVideo, String lista, boolean deefecto);
}
