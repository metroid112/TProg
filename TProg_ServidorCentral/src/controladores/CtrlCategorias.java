package controladores;

import java.util.List;
import java.util.Map;

import clases.Categoria;
import datatypes.DtCategoria;
import java.util.LinkedList;
import java.util.List;

import clases.Categoria;
import clases.ListaParticular;
import clases.Video;
import datatypes.DtCategoria;
import datatypes.DtLista;
import datatypes.DtVideo;
import excepciones.DuplicateClassException;
import excepciones.NotFoundException;
import interfaces.ICategorias;
import manejadores.ManejadorCategorias;

public class CtrlCategorias implements ICategorias {

  private ManejadorCategorias manejadorCategorias = ManejadorCategorias.getManejadorCategorias();

  public CtrlCategorias() {
  }

  @Override
  public void altaCategoria(String nombreCategoria) throws DuplicateClassException {
    Categoria nuevaCategoria = new Categoria(nombreCategoria);
    manejadorCategorias.addCategoria(nuevaCategoria);
  }
  
  @Override
  public List<DtCategoria> listarCategorias(){
    return manejadorCategorias.listaCategorias();
  }

  @Override

  public DtCategoria consultaDeCategoria(String categoria) {
    try{
    Categoria categ = manejadorCategorias.getCategoria(categoria);
    Map<Integer,Video> videos = categ.getVideos();
    List<DtVideo> dtVideos = new LinkedList<DtVideo>();
    for (Video vid : videos.values()) {
      if (vid.isVisible()) {
        dtVideos.add(vid.getDt());
      }
    }
    Map<Integer,ListaParticular> listas = categ.getListas();
    List<DtLista> dtListas = new LinkedList<DtLista>();
    for (ListaParticular lista : listas.values()) {
      if (lista.isVisible()) {
        dtListas.add(lista.getDtLista());
      }    
    }
    return new DtCategoria(categoria, dtVideos, dtListas);
  }
  catch(NotFoundException e){}
    return null;
  }
  
}
