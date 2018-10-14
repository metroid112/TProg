package manejadores;

import java.util.HashSet;
import java.util.Set;

import excepciones.DuplicateClassException;

public class ManejadorListasDefecto {

  private static ManejadorListasDefecto manejador = null;

  public static ManejadorListasDefecto getManejadorListas() {
    if (manejador == null) {
      manejador = new ManejadorListasDefecto();
    }
    return manejador;
  }

  private Set<String> listasDefecto = new HashSet<String>();

  private ManejadorListasDefecto() {

  }

  public void addListaDefecto(String nombreLista) throws DuplicateClassException {
    if (!this.listasDefecto.contains(nombreLista)) {
      listasDefecto.add(nombreLista);
    } else {
      throw new DuplicateClassException("Lista Defecto", nombreLista);
    }
  }

  public boolean existeListaDefecto(String nombre) {
    if (!listasDefecto.contains(nombre)) {
      return false;
    }
    return true;
  }

  public String[] toArray() {
    return listasDefecto.toArray(new String[listasDefecto.size()]);
  }
}
