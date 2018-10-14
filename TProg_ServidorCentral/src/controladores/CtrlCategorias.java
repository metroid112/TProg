package controladores;

import clases.Categoria;
import excepciones.DuplicateClassException;
import interfaces.ICategorias;
import manejadores.ManejadorCategorias;

public class CtrlCategorias implements ICategorias {

  private ManejadorCategorias manejadorCategorias = ManejadorCategorias.getManejadorCategorias();

  public CtrlCategorias() {

  }

  @Override
  public void altaCategoria(String nombreCategoria) throws DuplicateClassException {
    manejadorCategorias.altaCategoria(nombreCategoria);
  }

  @Override
  public String[] getInfoListas(String s) {
    Categoria c = manejadorCategorias.get(s);
    return c.getInfoListas();
  }

  @Override
  public String[] getInfoListasPublicas(String s) {
    Categoria c = manejadorCategorias.get(s);
    return c.getInfoListasPublicas();
  }

  @Override
  public String[] getInfoVideos(String s) {
    Categoria c = manejadorCategorias.get(s);
    return c.getInfoVideos();
  }

  @Override
  public String[] getInfoVideosPublicos(String s) {
    Categoria c = manejadorCategorias.get(s);
    return c.getInfoVideosPublicos();
  }

  @Override
  public String[] listarCategorias() {
    return manejadorCategorias.toArray();
  }
}
