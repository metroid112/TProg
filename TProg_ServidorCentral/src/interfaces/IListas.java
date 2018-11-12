package interfaces;

import java.util.List;
import java.util.Map;

import clases.ListaParticular;
import datatypes.DtLista;
import excepciones.DuplicateClassException;
import excepciones.InvalidDataException;
import excepciones.NotFoundException;

public interface IListas {

  public void agregarVideoLista(String usuario, String video, String usuarioObjetivo, String lista,
      boolean defecto) throws DuplicateClassException, InvalidDataException;

  public void altaListaDefecto(String nombre) throws DuplicateClassException;

  public void altaListaParticular(String nombre, String usuario, boolean visibilidad)
      throws DuplicateClassException;

  public DtLista getDt(int idLista) throws NotFoundException;

  public DtLista getDtDefecto(String usuario, String nombreListaDefecto);

  public Map<Integer, DtLista> getDtListas();

  // public String getDue�oVideo(String due�oLista, String nombreLista, String
  // nombreVid, String algo) throws Exception;

  public void guardarCambios(String nomLis, String usuario, boolean visible);

  public List<String> listarListasDefectoUsuario(String usuario);

  public List<String> listarListasParticularUsuario(String usuario);

  public void quitarVideoLista(String usuario, String video, String ownerVideo, String lista,
      boolean deefecto);

  public List<DtLista> getDtListasPublicas();

  public List<DtLista> getDtListasParticularesUsuario(String usuario);

  public List<DtLista> getDtListasParticularesPublicasUsuario(String usuario);

  public List<DtLista> getDtListasDefectoUsuario(String usuario);

  public List<DtLista> getDtListasPrivadasUsuario(String usuario);

  public Map<Integer, ListaParticular> getListasPublicas();
}
