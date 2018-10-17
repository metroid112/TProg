package clases;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import datatypes.DtUsuario;

public class Usuario {

  private String nick;
  private String password = "";
  private String correo;
  private String nombre;
  private String apellido;
  private Date fechaNacimiento;
  private Canal canal;
  private String imgPath = "img/usuarios/null.JPG";
  private BufferedImage img;  
  
  private List<Calificacion> calificaciones = new LinkedList<Calificacion>();
  private Map<Integer, Comentario> comentarios = new HashMap<Integer, Comentario>();
  private Map<String, Usuario> seguidores = new HashMap<String, Usuario>();
  private Map<String, Usuario> seguidos = new HashMap<String, Usuario>();
  
  private int idUsuario;
  private static int idCounter = 0;

  public Usuario(String nickname, String nombre, String apellido, String correo,
      Date fechaNacimiento, String image, String password) {
    this.nick = nickname;
    this.nombre = nombre;
    this.apellido = apellido;
    this.correo = correo;
    this.fechaNacimiento = fechaNacimiento;
    this.imgPath = image;
    this.password = password;
    Usuario.idCounter++;
    this.idUsuario = Usuario.idCounter;
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
    this.comentarios.put(comentario.getId(), comentario);
    vid.addComentarioPadre(comentario);
  }

  public Canal getCanal() {
    return canal;
  }

  public String getCorreo() {
    return correo;
  }

  public DtUsuario getDt() {
    String categoria = this.getCanal().getCategoria() == null ? "Sin Categoria"
        : this.getCanal().getCategoria().getNombre();
    return new DtUsuario(this.nombre, this.apellido, this.canal, this.correo, this.fechaNacimiento,
        this.nick, this.imgPath, categoria);
  }

  public BufferedImage getImagen() {
    return this.img;
  }

  public String getNick() {
    return nick;
  }

  public Map<String, Usuario> getSeguidores() {
    return seguidores;
  }

  public Map<String, Usuario> getSeguidos() {
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

  public void dejarSeguir(Usuario seguido) {
    this.seguidos.remove(seguido.getNick());
    seguido.removeSeguidor(this);
  }

  private void removeSeguidor(Usuario usuario) {
    this.seguidores.remove(usuario.getNick());
  }

  public void setCanal(Canal canal) {
    this.canal = canal;
  }

  public void valorarVideo(boolean like, Video vid) {
    if (!yaCalificado(true, vid) && !yaCalificado(false, vid)) {
      Calificacion cal = new Calificacion(like, this, vid);
      vid.addCalificacion(cal);
      this.addCalificacion(cal);
    }
  }

  public boolean yaCalificado(boolean calificacion, Video vid) {
    boolean calificado = false;
    for (Calificacion cal : this.calificaciones) {
      if (cal.getVideo() == vid && cal.getlike() == calificacion) {
        calificado = true;
      }
    }
    return calificado;
  }

  public Comentario getComentario(int idComentario) {
    return comentarios.get(idComentario);
  }

  public List<Calificacion> getCalificaciones() {
    return this.calificaciones;
  }

  public Date getFecha() {
    return this.fechaNacimiento;
  }

  public boolean checkPass(String pass) {
    return (this.password.equals(pass));
  }

  public Integer getId() {
    return this.idUsuario;
  }

  public String getPath() {
    return this.imgPath;
  }

  public void modificarUsuario(DtUsuario usuarioModificado) {
    
  }
  
  @Override
  public boolean equals(Object object) {
    Usuario user = (Usuario) object;
    return (this.nick.equals(user.nick));
  }

}
