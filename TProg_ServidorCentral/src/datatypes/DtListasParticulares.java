package datatypes;

import java.util.HashMap;
import java.util.Map;

import clases.Lista;
import clases.ListaParticular;

public class DtListasParticulares {

  private Map<Integer, DtLista> listas = new HashMap<Integer, DtLista>();

  public DtListasParticulares(Map<Integer, ListaParticular> listas) {
    for(Lista lista : listas.values()) {
      this.listas.put(lista.getId(), lista.getDtLista());
    }
  }

  public Map<Integer, DtLista> getListas() {
    return this.listas;
  }

  public void setListas(Map<Integer, DtLista> listas) {
    this.listas = listas;
  }
}
