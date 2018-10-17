package datatypes;

import java.awt.image.BufferedImage;
import java.util.Date;

public class DtUsuario {

  private String nick;
  private String correo;
  private String nombre;
  private String apellido;
  private Date fechaNacimiento;
  private String canal;
  private String descripcionCanal;
  private String categoria;
  private boolean privado;
  private Date ultimaActividad;
  private String imgPath;
  private BufferedImage imagen;

  public DtUsuario(String nombre, String apellido, String canal, String correo,
      String descripcionCanal, Date fechaNacimiento, boolean privado,
      String nick, String imgPath, String categoria) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.canal = canal;
    this.correo = correo;
    this.descripcionCanal = descripcionCanal;
    this.fechaNacimiento = fechaNacimiento;
    this.privado = privado;
    this.nick = nick;
    this.imgPath = imgPath;
    this.categoria = categoria;
  }

  public DtUsuario(String nick, String canal, String path, Date ultimaActividad) {
    this.nick = nick;
    this.canal = canal;
    this.imgPath = path;
    this.ultimaActividad = ultimaActividad;
  }

  @Override
  public boolean equals(Object object) {
    DtUsuario dtUsuario = (DtUsuario) object;
    return (this.nick.equals(dtUsuario.nick) && this.correo.equals(dtUsuario.correo); 
  }
