package manejadores;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import clases.Categoria;
import datatypes.DtCategoria;
import excepciones.DuplicateClassException;
import excepciones.NotFoundException;

public class ManejadorCategorias {

  private static ManejadorCategorias manejador = null;
  private Map<String, Categoria> categorias = new HashMap<String, Categoria>();

  private ManejadorCategorias() {

  }

  public static ManejadorCategorias getManejadorCategorias() {
    if (manejador == null) {
      manejador = new ManejadorCategorias();
    }
    return manejador;
  }

  public void addCategoria(Categoria categoria) throws DuplicateClassException {
    if (!categorias.containsKey(categoria.getNombre())) {
      this.categorias.put(categoria.getNombre(), categoria);
    } else {
      throw new DuplicateClassException("Categoria", categoria.getNombre());
    }
  }

  public Categoria getCategoria(String nombreCategoria) throws NotFoundException {
    if (this.categorias.get(nombreCategoria) != null) {
      return this.categorias.get(nombreCategoria);
    } else {
      throw new NotFoundException("Categoria nombre: " + nombreCategoria);
    }
  }

  public String[] toArray() {
    return categorias.keySet().toArray(new String[categorias.size()]);
  }
  
  public LinkedList<String> toList() {
    LinkedList<String> lista = new LinkedList<String>(categorias.keySet());
    return lista;

  }
  public List<DtCategoria> listaCategorias(){ //este se usa, tolist y toarray me parece que no
    List<DtCategoria> lista = new LinkedList<DtCategoria>();
    for(Categoria categoria: categorias.values()){
      lista.add(categoria.getDt());
    }
    return lista;
  }

  public Map<String, Categoria> getCategorias() {
    return this.categorias;
  }
}
