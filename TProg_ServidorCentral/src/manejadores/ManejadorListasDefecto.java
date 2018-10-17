package manejadores;

import java.util.HashSet;
import java.util.Set;

import excepciones.DuplicateClassException;

public class ManejadorListasDefecto {

  private static ManejadorListasDefecto manejador = null;
  private Set<String> listasDefecto = new HashSet<String>();
  
  private ManejadorListasDefecto() {

  }

  public static ManejadorListasDefecto getManejadorListasDefecto() {    
    if (manejador == null) {
      manejador = new ManejadorListasDefecto();
    }
    return manejador;
  }

  public void addListaDefecto(String nombreLista) throws DuplicateClassException {
    if (!this.listasDefecto.contains(nombreLista)) {
      listasDefecto.add(nombreLista);
    } else {
      throw new DuplicateClassException("Lista Defecto", nombreLista);
    }
  }

  public boolean existeListaDefecto(String nombreLista) {
    return (listasDefecto.contains(nombreLista));
  }
  
  public Set<String> getListasDefecto() {
    return this.listasDefecto;
  }
}
