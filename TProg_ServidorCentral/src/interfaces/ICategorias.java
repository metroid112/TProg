package interfaces;

import datatypes.DtCategoria;

public interface ICategorias {

  public void altaCategoria(String nombreCategoria) throws Exception;

  public String[] getInfoListas(String categoria);

  public String[] getInfoVideos(String categoria);

  public DtCategoria listarCategorias();

  public String[] getInfoVideosPublicos(String categoria);

  public String[] getInfoListasPublicas(String categoria);
  
  public DtCategoria consultaDeCategoria(String categoria);
}
