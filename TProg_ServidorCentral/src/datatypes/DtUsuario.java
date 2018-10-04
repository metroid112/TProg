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

  @Override
  public boolean equals(Object o) {
    DtUsuario dt = (DtUsuario) o;
    return (this.nombre.equals(dt.nombre) && this.apellido.equals(dt.apellido)
        && this.correo.equals(dt.correo) && this.canal.equals(dt.canal)
        && this.privado == dt.privado);
  }
}
