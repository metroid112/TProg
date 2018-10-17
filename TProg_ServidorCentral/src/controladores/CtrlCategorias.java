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
    manejadorCategorias.addCategoria(nombreCategoria);
  }

  @Override
  public String[] getInfoListas(String categoria) {
    Categoria categ = manejadorCategorias.getCategoria(categoria);
    return categ.getInfoListas();
  }

  @Override
  public String[] getInfoListasPublicas(String categoria) {
    Categoria categ = manejadorCategorias.getCategoria(categoria);
    return categ.getInfoListasPublicas();
  }

  @Override
  public String[] getInfoVideos(String categoria) {
    Categoria categ = manejadorCategorias.getCategoria(categoria);
    return categ.getInfoVideos();
  }

  @Override
  public String[] getInfoVideosPublicos(String categoria) {
    Categoria categ = manejadorCategorias.getCategoria(categoria);
    return categ.getInfoVideosPublicos();
  }

  @Override
  public String[] listarCategorias() {
    return manejadorCategorias.toArray();
  }
}
