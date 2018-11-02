package controladores;

import clases.Categoria;
import datatypes.DtCategoria;
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
  public String[] getInfoListas(String categoria) {
    Categoria categ = manejadorCategorias.get(categoria);
    return categ.getInfoListas();
  }

  @Override
  public String[] getInfoListasPublicas(String categoria) {
    Categoria categ = manejadorCategorias.get(categoria);
    return categ.getInfoListasPublicas();
  }

  @Override
  public String[] getInfoVideos(String categoria) {
    Categoria categ = manejadorCategorias.get(categoria);
    return categ.getInfoVideos();
  }

  @Override
  public String[] getInfoVideosPublicos(String categoria) {
    Categoria categ = manejadorCategorias.get(categoria);
    return categ.getInfoVideosPublicos();
  }

  @Override
  public DtCategoria listarCategorias() {
    return manejadorCategorias.toList();
  }
}
