package clases;

import datatypes.DtCalificacion;

public class Calificacion {

  private boolean like;
  private Usuario usuario;
  private Video video;

  public Calificacion(boolean like, Usuario user, Video video) {
    this.like = like;
    this.usuario = user;
    this.video = video;
  }

  public DtCalificacion getDt() {
    return new DtCalificacion(this.like, this.usuario.getNick(), this.video.getNombre());
  }

  public boolean getlike() {
    return this.like;
  }

  public Usuario getUsuario() {
    return this.usuario;
  }

  public Video getVideo() {
    return this.video;
  }

  public void setLike(boolean like) {
    this.like = like;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  public void setVideo(Video video) {
    this.video = video;
  }

  @Override
  public boolean equals(Object object) {
    Calificacion cal = (Calificacion) object;
    return (this.like == cal.like && this.usuario.equals(cal.usuario)
        && this.video.equals(cal.video));
  }
}
