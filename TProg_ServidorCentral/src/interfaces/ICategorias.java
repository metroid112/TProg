package interfaces;

public interface ICategorias {

  public void altaCategoria(String nombreCategoria) throws Exception;

  public String[] getInfoListas(String s);

  public String[] getInfoVideos(String s);

  public String[] listarCategorias();

  public String[] getInfoVideosPublicos(String s);

  public String[] getInfoListasPublicas(String s);
}
