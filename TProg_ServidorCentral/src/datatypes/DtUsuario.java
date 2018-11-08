package datatypes;

import java.awt.image.BufferedImage;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtUsuario extends DtUniversal{

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
  public Date ultimaActividad;
  public String categoria;

  public DtUsuario(String nombre, String apellido, String canal, String correo,
      String descripcionCanal, Date fechaNacimiento, BufferedImage imagen, boolean privado,
      String nick, String imgPath, String categoria) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.canal = canal;
    this.correo = correo;
    this.descripcionCanal = descripcionCanal;
    this.fechaNacimiento = fechaNacimiento;
    this.imagen = imagen;
    this.privado = privado;
    this.nick = nick;
    this.imgPath = imgPath;
    this.categoria = categoria;
  }

  public DtUsuario(String nick, String canal, String path, Date ultimaActividad) {
    this.nick = nick;
    this.canal = canal;
    this.imgPath = path;
    this.setUltimaActividad(ultimaActividad);
  }

  @Override
  public boolean equals(Object object) {
    DtUsuario dtUsuario = (DtUsuario) object;
    return (this.nombre.equals(dtUsuario.nombre) && this.apellido.equals(dtUsuario.apellido)
        && this.correo.equals(dtUsuario.correo) && this.canal.equals(dtUsuario.canal)
        && this.privado == dtUsuario.privado);
  }

  public String getNombre() {
    return nombre;
  }

  public Date getFechaNacimiento() {
    return fechaNacimiento;
  }

  public void setFechaNacimiento(Date fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  public BufferedImage getImagen() {
    return imagen;
  }

  public void setImagen(BufferedImage imagen) {
    this.imagen = imagen;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public String getDescripcionCanal() {
    return descripcionCanal;
  }

  public void setDescripcionCanal(String descripcionCanal) {
    this.descripcionCanal = descripcionCanal;
  }

  public boolean isPrivado() {
    return privado;
  }

  public void setPrivado(boolean privado) {
    this.privado = privado;
  }

  public String getNick() {
    return nick;
  }

  public void setNick(String nick) {
    this.nick = nick;
  }

  public String getImgPath() {
    return imgPath;
  }

  public void setImgPath(String imgPath) {
    this.imgPath = imgPath;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
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
