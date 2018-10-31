package datatypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtPaquete {
  private Object contenido;
  
  public DtPaquete() {}
  
  public Object getContenido() {
    return this.contenido;
  }
  
  /**
   * prueba
   * @param contenido
   */
  public void setContenido(Object contenido) {
    this.contenido = contenido;
  }
}
