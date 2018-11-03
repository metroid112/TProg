package interfaces;

import java.util.List;

import datatypes.DtCategoria;
import excepciones.NotFoundException;

public interface ICategorias {

  public void altaCategoria(String nombreCategoria) throws Exception;

  public String[] getInfoListas(String categoria) throws NotFoundException ;

  public String[] getInfoVideos(String categoria) throws NotFoundException ;

  public List<DtCategoria> listarCategorias();

  public String[] getInfoVideosPublicos(String categoria) throws NotFoundException ;

  public String[] getInfoListasPublicas(String categoria) throws NotFoundException ;
}
