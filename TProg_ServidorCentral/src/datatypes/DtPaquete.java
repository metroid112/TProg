package datatypes;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtPaquete {
  private DtUniversal contenido;
  private List<String> listaAux;
  private List<? extends DtUniversal> listaDt;

  
  public DtPaquete() {}
  
  public List<? extends DtUniversal> getListaDt() {
    return listaDt;
  }

  public void setListaDt(List<? extends DtUniversal> listaDt) {
    this.listaDt = listaDt;
  }

  public DtUniversal getContenido() {
    return this.contenido;
  }

  public void setContenido(DtUniversal contenido) {
    this.contenido = contenido;
  }

  public List<String> getListaAux() {
    return listaAux;
  }

  public void setListaAux(List<String> listaAux) {
    this.listaAux = listaAux;
  }
}
