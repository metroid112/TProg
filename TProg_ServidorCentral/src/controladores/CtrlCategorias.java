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
  public List<DtCategoria> listarCategorias() {
    List<DtCategoria> dtCat = new LinkedList<DtCategoria>();
    for (Categoria cats : manejadorCategorias.getCategorias().values()) {
      dtCat.add(cats.getDt());
    }
    return dtCat;
  }
  
  @Override
  public DtCategoria consultaDeCategoria(String categoria) {
    Categoria categ = manejadorCategorias.get(categoria);
    List<Video> videos = categ.getVideos();
    List<Video> dtVideos = new LinkedList<Video>();
    for (Video vid : videos) {
      if (vid.isVisible()) {
        dtVideos.add(vid);
      }
    }
    List<ListaParticular> listas = categ.getListas();
    List<ListaParticular> dtListas = new LinkedList<ListaParticular>();
    for (ListaParticular lista : listas) {
      if (lista.isVisible()) {
        dtListas.add(lista);
      }    
    }
    return new DtCategoria(categoria, categ.getIdCategoria(), dtVideos, dtListas);
  }
}
