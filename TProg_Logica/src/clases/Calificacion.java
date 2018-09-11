package clases;

import dataTypes.DtCalificacion;

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

  public Video getVideo() {
    return video;
  }

  public void setLike(boolean like) {
    this.like = like;
  }

  @Override
  public boolean equals(Object o) {
    Calificacion cal = (Calificacion) o;
    return (this.like == cal.like && this.usuario.equals(cal.usuario)
        && this.video.equals(cal.video));
  }
}
