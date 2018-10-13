package datatypes;

import java.awt.image.BufferedImage;
import java.util.Date;

public class DtUsuario {

  public Date fechaNacimiento;
  public BufferedImage imagen;
  public String nombre;
  public String apellido;
  public String canal;
  public String correo;
  public String descripcionCanal;
  public boolean privado;
  public String nick;
  public String imgPath;
  private Date ultimaActividad;

  public DtUsuario(String nombre, String apellido, String canal, String correo,
      String descripcionCanal, Date fechaNacimiento, BufferedImage imagen, boolean privado,
      String nick) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.canal = canal;
    this.correo = correo;
    this.descripcionCanal = descripcionCanal;
    this.fechaNacimiento = fechaNacimiento;
    this.imagen = imagen;
    this.privado = privado;
    this.nick = nick;
  }
  
  public DtUsuario(String nick, String canal, String path, Date ultimaActividad) {
    this.nick = nick;
    this.canal = canal;
    this.imgPath = path;
    this.setUltimaActividad(ultimaActividad);
  }

  @Override
  public boolean equals(Object o) {
    DtUsuario dt = (DtUsuario) o;
    return (this.nombre.equals(dt.nombre) && this.apellido.equals(dt.apellido)
        && this.correo.equals(dt.correo) && this.canal.equals(dt.canal)
        && this.privado == dt.privado);
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getCanal() {
    return canal;
  }

  public void setCanal(String canal) {
    this.canal = canal;
  }

  public Date getUltimaActividad() {
    return ultimaActividad;
  }

  public void setUltimaActividad(Date ultimaActividad) {
    this.ultimaActividad = ultimaActividad;
  }
  
  
}
