package datatypes;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtPaquete {
  private DtUniversal contenido;
  private List<DtUniversal> listaContenido = new LinkedList<DtUniversal>();
  private List<String> listaAux = new LinkedList<String>();
  
  public DtPaquete() {}
  
  public DtUniversal getContenido() {
    return this.contenido;
  }
  
  public List<DtUniversal> getListaContenido() {
    return this.listaContenido;
  }

  public void setContenido(DtUniversal contenido) {
    this.contenido = contenido;
  }
  
  public void setContenido(List<DtUniversal> contenido) {
    this.listaContenido = contenido;
  }

  public List<String> getListaAux() {
    return listaAux;
  }

  public void setListaAux(List<String> listaAux) {
    this.listaAux = listaAux;
  }
}
