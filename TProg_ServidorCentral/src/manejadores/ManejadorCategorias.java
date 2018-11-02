package manejadores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import clases.Categoria;
import datatypes.DtCategoria;
import excepciones.DuplicateClassException;

public class ManejadorCategorias {

  private static ManejadorCategorias manejador = null;

  public static ManejadorCategorias getManejadorCategorias() {
    if (manejador == null) {
      manejador = new ManejadorCategorias();
    }
    return manejador;
  }

  private Map<String, Categoria> categorias = new HashMap<String, Categoria>();

  private ManejadorCategorias() {

  }

  public void add(Categoria categoria) {
    categorias.put(categoria.getNombre(), categoria);
  }

  public void altaCategoria(String nombreCategoria) throws DuplicateClassException {
    if (!categorias.containsKey(nombreCategoria)) {
      add(new Categoria(nombreCategoria));
    } else {
      throw new DuplicateClassException("Categoria", nombreCategoria);
    }
  }

  public Categoria get(String nombreCategoria) {
    return categorias.get(nombreCategoria);
  }

  public void removeAll() {
    this.categorias.clear();
  }

  public String[] toArray() {
    return categorias.keySet().toArray(new String[categorias.size()]);
  }
  
  public DtCategoria toList() {
    List<String> lista = new ArrayList<String>(categorias.keySet());
    return new DtCategoria(lista);
  }

  public boolean existeCategoria(String nombre) {
    return categorias.containsKey(nombre);
  }
}
