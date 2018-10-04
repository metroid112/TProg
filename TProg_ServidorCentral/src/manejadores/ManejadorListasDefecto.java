package manejadores;

import java.util.HashSet;

public class ManejadorListasDefecto {

  private static ManejadorListasDefecto manejador = null;

  public static ManejadorListasDefecto getManejadorListas() {
    if (manejador == null) {
      manejador = new ManejadorListasDefecto();
    }
    return manejador;
  }

  private HashSet<String> listasDefecto = new HashSet<String>();

  private ManejadorListasDefecto() {

  }

  public void add(String lista) {
    listasDefecto.add(lista);
  }

  public boolean existeLista(String nombre) {
    if (!listasDefecto.contains(nombre)) {
      return false;
    }
    return true;
  }

  public String[] toArray() {
    return listasDefecto.toArray(new String[listasDefecto.size()]);
  }
}
