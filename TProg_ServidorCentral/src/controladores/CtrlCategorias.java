package controladores;

import java.util.LinkedList;
import java.util.List;

import clases.Categoria;
import clases.ListaParticular;
import clases.Video;
import datatypes.DtCategoria;
import datatypes.DtLista;
import datatypes.DtVideo;
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
  
  @Override
  public DtCategoria consultaDeCategoria(String categoria) {
    Categoria categ = manejadorCategorias.get(categoria);
    List<Video> videos = categ.getVideos();
    List<DtVideo> dtVideos = new LinkedList<DtVideo>();
    for (Video vid : videos) {
     dtVideos.add(vid.getDt());
    }
    List<ListaParticular> listas = categ.getListas();
    List<DtLista> dtListas = new LinkedList<DtLista>();
    for (ListaParticular lista : listas) {
      dtListas.add(lista.getDtLista());
    }
    return new DtCategoria(categoria, dtVideos, dtListas);
  }
}
