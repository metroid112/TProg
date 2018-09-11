package interfaces;

public interface ICategorias {

  public void altaCategoria(String nombreCategoria) throws Exception;

  public String[] getInfoListas(String s);

  public String[] getInfoVideos(String s);

  public String[] listarCategorias();
}
