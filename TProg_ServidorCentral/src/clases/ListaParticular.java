package clases;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import datatypes.DtLista;
import excepciones.DuplicateClassException;
import manejadores.ManejadorListasParticulares;

public class ListaParticular extends Lista {

  private Map<String, Categoria> categorias = new HashMap<String, Categoria>();
  private boolean visible;

  public ListaParticular(String nombre, Canal canal,
      boolean visible) throws DuplicateClassException {
    super(nombre, canal);
    this.visible = visible;
    ManejadorListasParticulares.getManejadorListasParticulares().add(this);
  }

  public boolean esUnicaCategoria(Categoria categoria) {
    if (categoria != null) {
      for (Video v : super.getVideos()) {
        if (v.getCategoria() == categoria) {
          return false;
        }
      }
      return true;
    }
    return false;
  }

  public boolean existeCategoria(Categoria categoria) {
    if (categoria != null) {
      return categorias.containsKey(categoria.getNombre());
    }
    return true;
  }

  public Map<String, Categoria> getCategorias() {
    return categorias;
  }

  @Override
  public DtLista getDtLista() {
    LinkedList<String> videos = new LinkedList<String>();
    for (Video vid : this.getVideos()) {
      videos.add(vid.getCanal().getUsuario().getNick() + "-" + vid.getNombre());
    }
    LinkedList<String> categorias = new LinkedList<String>();
    for (Categoria cat : this.getCategorias().values()) {
      categorias.add(cat.getNombre());
    }
    return new DtLista(this.getNombre(), "Particular", this.visible, videos, categorias);
  }

  public void insertarCategoria(Categoria categoria) {
    if (!categorias.containsKey(categoria.getNombre())) {
      categorias.put(categoria.getNombre(), categoria);
      categoria.addLista(this);
    }
  }

  public void quitarCategoria(Categoria categoria) {
    categorias.remove(categoria.getNombre());
  }

  public void setVisible(boolean visible) {
    this.visible = visible;
  }

  @Override
  public boolean equals(Object o) {
    ListaParticular lis = (ListaParticular) o;
    return (this.visible == lis.visible && this.getCanal().equals(lis.getCanal())
        && this.getNombre().equals(lis.getNombre()));
  }
}
