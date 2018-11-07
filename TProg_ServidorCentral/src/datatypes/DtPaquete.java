package datatypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtPaquete {
  private DtUniversal contenido;
  
  public DtPaquete() {}
  
  public DtUniversal getContenido() {
    return this.contenido;
  }

  public void setContenido(DtUniversal contenido) {
    this.contenido = contenido;
  }
}
