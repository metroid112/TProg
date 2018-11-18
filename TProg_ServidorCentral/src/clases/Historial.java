package clases;

import java.util.Date;

public class Historial {
  int reproducciones = 0;
  Date fechaUltimaReproduccion;
  
  public Historial(int reproducciones, Date fechaUltimaReproduccion) {
    this.reproducciones = reproducciones;
    this.fechaUltimaReproduccion = fechaUltimaReproduccion;
  }
  
  public int getReproducciones() {
    return reproducciones;
  }
  
  public void setReproducciones(int reproducciones) {
    this.reproducciones = reproducciones;
  }
  
  public void aumentarReproduccion() {
    this.reproducciones++;
  }
  
  public Date getFechaUltimaReproduccion() {
    return fechaUltimaReproduccion;
  }
  
  public void setFechaUltimaReproduccion(Date fechaUltimaReproduccion) {
    this.fechaUltimaReproduccion = fechaUltimaReproduccion;
  }  
}
