package datatypes;

import java.util.LinkedList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtPaquete {
  private DtUniversal contenido;
  private LinkedList<String> listaAux;
  private LinkedList<DtUniversal> listaDt;
  
  public DtPaquete() {}
  
  public DtUniversal getContenido() {
    return this.contenido;
  }

  public void setContenido(DtUniversal contenido) {
    this.contenido = contenido;
  }

  public LinkedList<String> getListaAux() {
    return listaAux;
  }

  public void setListaAux(LinkedList<String> listaAux) {
    this.listaAux = listaAux;
  }

  public LinkedList<DtUniversal> getListaDt() {
    return listaDt;
  }

  public void setListaDt(LinkedList<DtUniversal> listaDt) {
    this.listaDt = listaDt;
  }
  
}
