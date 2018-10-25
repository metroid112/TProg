package interfaces;

import java.util.List;
import java.util.Map;

import clases.ListaParticular;
import datatypes.DtLista;
import excepciones.DuplicateClassException;
import excepciones.InvalidDataException;
import excepciones.NotFoundException;

public interface IListas {

  public void agregarVideoLista(int idVideo, int idUsuario, int idLista,
      boolean defecto) throws DuplicateClassException, InvalidDataException, NotFoundException ;

  public void altaListaDefecto(String nombreListaDefecto) throws DuplicateClassException;

  public void altaListaParticular(String nombreListaDefecto, int idUsuario, boolean visibilidad)
      throws DuplicateClassException, NotFoundException ;

  public DtLista getDt(int idLista) throws NotFoundException;

  public DtLista getDtDefecto(int idUsuario, String nombreListaDefecto)throws NotFoundException ;

  public Map<Integer, DtLista> getDtListas();

  public void guardarCambios(String nomLis, int idUsuario, boolean visible) throws NotFoundException ;

  public String[] listarListasDefectoUsuario(int idUsuario) throws NotFoundException ;

  public String[] listarListasParticularUsuario(int idUsuario) throws NotFoundException ;

  public void quitarVideoLista(int idUsuario, String nombreVideo, int ownerVideo, String lista,
      boolean deefecto) throws NotFoundException ;

  public List<DtLista> getDtListasPublicas();

  public List<DtLista> getDtListasParticularesUsuario(int idUsuario);

  public List<DtLista> getDtListasParticularesPublicasUsuario(int idUsuario)throws NotFoundException ;

  public List<DtLista> getDtListasDefectoUsuario(int idUsuario);

  public List<DtLista> getDtListasPrivadasUsuario(String usuario);

  public Map<Integer, ListaParticular> getListasPublicas();
}
