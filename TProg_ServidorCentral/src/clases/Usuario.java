package clases;

import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

import datatypes.DtUsuario;

public class Usuario {

  private String apellido;
  private LinkedList<Calificacion> calificaciones = new LinkedList<Calificacion>();
  private Canal canal;
  private LinkedList<Comentario> comentarios = new LinkedList<Comentario>();
  private String correo;
  private Date fechaNacimiento;
  private BufferedImage imagen;
  private String nick;
  private String nombre;
  private HashMap<String, Usuario> seguidores = new HashMap<String, Usuario>();
  private HashMap<String, Usuario> seguidos = new HashMap<String, Usuario>();
  private String password = "";
  private String imgPath = "img/usuarios/null.JPG";

  public Usuario() {

  }

  public Usuario(String nickname, String nombre, String apellido, String correo,
      Date fechaNacimiento, BufferedImage image) {
    this.nick = nickname;
    this.nombre = nombre;
    this.apellido = apellido;
    this.correo = correo;
    this.fechaNacimiento = fechaNacimiento;
    this.imagen = image;
  }

  public Usuario(String nickname, String nombre, String apellido, String correo,
      Date fechaNacimiento, String image, String password) {
    this.nick = nickname;
    this.nombre = nombre;
    this.apellido = apellido;
    this.correo = correo;
    this.fechaNacimiento = fechaNacimiento;
    this.imgPath = image;
    this.password = password;
  }
  
  public String getImg() {
    return this.imgPath;
  }
  
  public void addCalificacion(Calificacion cal) {
    this.calificaciones.add(cal);
  }

  public void addSeguidor(Usuario seguidor) {
    this.seguidores.put(seguidor.getNick(), seguidor);
  }

  public void comentar(String texto, Date fecha, Video vid) {
    Comentario comentario = new Comentario(texto, this, vid, fecha);
    this.comentarios.add(comentario);
    vid.addComentarioPadre(comentario);
  }

  public Canal getCanal() {
    return canal;
  }

  public String getCorreo() {
    return correo;
  }

  public DtUsuario getDt() {
    return new DtUsuario(this.nombre, this.apellido, this.canal.getNombre(), this.correo,
        this.canal.getDescripcion(), this.fechaNacimiento, this.imagen, this.canal.isVisible(), this.nick);
  }

  public BufferedImage getImagen() {
    return imagen;
  }

  public String getNick() {
    return nick;
  }

  public HashMap<String, Usuario> getSeguidores() {
    return seguidores;
  }

  public HashMap<String, Usuario> getSeguidos() {
    return seguidos;
  }

  public void modificarValoracion(boolean like, Video vid) {
    Calificacion calificacion = null;
    for (Calificacion cal : this.calificaciones) {
      if (cal.getVideo().equals(vid)) {
        calificacion = cal;
      }
    }
    calificacion.setLike(like);

  }

  public void responder(String texto, Date fecha, Integer idComentarioPadre, Video vid) {
    Comentario padre = vid.getComentario(idComentarioPadre);
    Comentario comentario = new Comentario(texto, this, vid, padre, fecha);
    this.comentarios.add(comentario);

  }

  public void seguir(Usuario seguido) {
    this.seguidos.put(seguido.getNick(), seguido);
    seguido.addSeguidor(this);
  }

  public void setCanal(Canal canal) {
    this.canal = canal;
  }

  public void valorarVideo(boolean like, Video vid) throws Exception {
    if (!yaCalificado(vid)) {
      Calificacion cal = new Calificacion(like, this, vid);
      vid.addCalificacion(cal);
      this.addCalificacion(cal);
    } else {
      throw new Exception("Video ya calificado");
    }
  }

  private boolean yaCalificado(Video vid) {
    boolean calificado = false;
    for (Calificacion cal : this.calificaciones) {
      if (cal.getVideo() == vid) {
        calificado = true;
      }
    }
    return calificado;
  }

  @Override
  public boolean equals(Object o) {
    Usuario user = (Usuario) o;
    return (this.nombre.equals(user.nombre) && this.nick.equals(user.nick)
        && this.apellido.equals(user.apellido) && this.correo.equals(user.correo)
        && this.fechaNacimiento.equals(user.fechaNacimiento) && this.imagen == user.imagen);
  }

  public Comentario getComentario(int id) {
    return comentarios.get(id);
  }

  public LinkedList<Calificacion> getCalificaciones() {
    return this.calificaciones;
  }

  public Date getFecha() {
    return this.fechaNacimiento;
  }
  
  public boolean checkPass(String pass) {
    return (this.password.equals(pass));
  }

}
