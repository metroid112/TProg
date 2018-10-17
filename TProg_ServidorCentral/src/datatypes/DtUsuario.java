package datatypes;

import java.awt.image.BufferedImage;
import java.util.Date;

import clases.Canal;

public class DtUsuario {

  private int idUsuario;
  private String nick;
  private String password;
  private String correo;
  private String nombre;
  private String apellido;
  private Date fechaNacimiento;
  private DtCanal canal;
  private String imgPath = "img/usuarios/null.JPG";
  private BufferedImage imagen;


  public DtUsuario(int idUsuario, String nick, String password, String correo, String nombre, String apellido,
      Date fechaNacimiento, DtCanal canal, String imgPath) {
    this.idUsuario = idUsuario;
    this.nick = nick;
    this.password = password;
    this.correo = correo;
    this.nombre = nombre;
    this.apellido = apellido;
    this.fechaNacimiento = fechaNacimiento;
    this.canal = canal;
    this.imgPath = imgPath;
  }

  public DtUsuario(int idUsuario, String nick, DtCanal canal) {
    this.idUsuario = idUsuario;
    this.nick = nick;
    this.canal = canal;
  }

  public int getIdUsuario() {
    return this.idUsuario;
  }

  public String getNick() {
    return this.nick;
  }

  public String getCorreo() {
    return this.correo;
  }

  public String getNombre() {
    return this.nombre;
  }

  public String getApellido() {
    return this.apellido;
  }

  public Date getFechaNacimiento() {
    return this.fechaNacimiento;
  }

  public DtCanal getCanal() {
    return this.canal;
  }

  public String getImgPath() {
    return this.imgPath;
  }

  public BufferedImage getImagen() {
    return this.imagen;
  }

  public void setIdUsuario(int idUsuario) {
    this.idUsuario = idUsuario;
  }

  public void setNick(String nick) {
    this.nick = nick;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public void setFechaNacimiento(Date fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  public void setCanal(DtCanal canal) {
    this.canal = canal;
  }

  public void setImgPath(String imgPath) {
    this.imgPath = imgPath;
  }

  public void setImagen(BufferedImage imagen) {
    this.imagen = imagen;
  }

  @Override
  public boolean equals(Object object) {
    DtUsuario dtUsuario = (DtUsuario) object;
    return (this.nick.equals(dtUsuario.nick) && this.correo.equals(dtUsuario.correo)); 
  }
}
