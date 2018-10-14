package clases;

import java.util.Date;
import java.util.LinkedHashMap;

import datatypes.DtComentario;

public class Comentario {

  private static int idCounter = 0;
  private Date fecha;
  private int id; // id de comentario para uso interno
  private Comentario padre;
  private LinkedHashMap<Integer, Comentario> respuestas = new LinkedHashMap<Integer, Comentario>();
  private String texto;
  private Usuario usuario;
  private Video video;

  public Comentario() {

  }

  /**
   * comentario respuesta con fecha.
   */
  public Comentario(String texto, Usuario usuario, Video video, Comentario padre, Date fecha) {

    this.texto = texto;
    this.usuario = usuario;
    this.video = video;
    this.padre = padre;
    this.fecha = fecha;
    this.id = Comentario.idCounter;
    Comentario.idCounter++;
    padre.addHijo(this);
  }

  public Comentario(String texto, Usuario usuario, Video video, Date fecha) {
    this.texto = texto;
    this.usuario = usuario;
    this.video = video;
    this.fecha = fecha;
    this.padre = null;
    this.id = Comentario.idCounter;
    Comentario.idCounter++;
  }

  public void addHijo(Comentario hijo) {
    this.respuestas.put(hijo.getId(), hijo);
  }

  public Comentario getCom(Integer idComentario) {
    if (this.id == idComentario) {
      return this;
    } else if (!this.respuestas.isEmpty()) {
      Comentario encontrado = null;
      for (Comentario hijo : this.respuestas.values()) {
        Comentario retornado = hijo.getCom(idComentario);
        if (retornado != null) {
          encontrado = retornado;
        }
      }
      return encontrado;
    } else {
      return null;
    }
  }

  public DtComentario getDt() {
    return new DtComentario(this);
  }

  public Integer getId() {
    return this.id;
  }

  public LinkedHashMap<Integer, Comentario> getRespuestas() {
    return respuestas;
  }

  public String getTexto() {
    return texto;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public boolean tieneRespuestas() {
    return !(this.respuestas.isEmpty());
  }

  public Date getFecha() {
    return fecha;
  }

  public static int getContador() {
    return idCounter;
  }

  @Override
  public boolean equals(Object o) {
    Comentario comment = (Comentario) o;
    return (this.texto.equals(comment.texto) && this.usuario.equals(comment.usuario)
        && this.video.equals(comment.video));
  }
}
