package datatypes;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtPaquete {
  private DtUniversal contenido;
  private List<String> listaAux;
  private List<DtUniversal> listaDt;
  
  public DtPaquete() {}
  
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

  public List<DtUniversal> getListaDt() {
    return listaDt;
  }

  public void setListaDt(List<DtUniversal> listaDt) {
    this.listaDt = listaDt;
  }
  
}
