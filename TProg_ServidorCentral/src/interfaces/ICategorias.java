package interfaces;

import java.util.List;

import datatypes.DtCategoria;

public interface ICategorias {

  public void altaCategoria(String nombreCategoria) throws Exception;

  public String[] getInfoListas(String categoria);

  public String[] getInfoVideos(String categoria);

  public List<DtCategoria> listarCategorias();

  public String[] getInfoVideosPublicos(String categoria);

  public String[] getInfoListasPublicas(String categoria);
  
  public DtCategoria consultaDeCategoria(String categoria);
}
