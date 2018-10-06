package interfaces;

import java.util.List;
import java.util.Map;

import datatypes.DtLista;
import excepciones.DuplicateClassException;
import excepciones.NotFoundException;

public interface IListas {

  public void agregarVideoLista(String usuario, String video, String usuarioObjetivo, String lista,
      boolean defecto) throws DuplicateClassException;

  public void altaListaDefecto(String nombre) throws DuplicateClassException;

  public void altaListaParticular(String nombre, String usuario, boolean visibilidad)
      throws DuplicateClassException;

  public DtLista getDt(int id) throws NotFoundException;

  public Map<Integer, DtLista> getDtListas();
  
  // public String getDueñoVideo(String dueñoLista, String nombreLista, String
  // nombreVid, String algo) throws Exception;

  public void guardarCambios(String nomLis, String usuario, boolean visible);

  public String[] listarListasDefectoUsuario(String usuario);

  public String[] listarListasParticularUsuario(String usuario);

  public void quitarVideoLista(String usuario, String video, String ownerVideo, String lista,
      boolean defecto);
}
