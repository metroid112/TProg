package datatypes;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import clases.Comentario;

public class DtComentario {
  public Map<Integer, DtComentario> hijos = new LinkedHashMap<Integer, DtComentario>();
  public Integer idComentario;
  public String texto;
  public String usuario;
  public Date fecha;
  private boolean tieneHijos = false;

  public DtComentario(Comentario comentario) {
    this.idComentario = comentario.getId();
    this.texto = comentario.getTexto();
    this.usuario = comentario.getUsuario().getNick();
    this.fecha = comentario.getFecha();
    if (comentario.tieneRespuestas()) {
      for (Comentario com : comentario.getRespuestas().values()) {
        this.hijos.put(com.getId(), new DtComentario(com));
      }
      this.tieneHijos = true;
    }
  }

  public String getString() {
    return ("(" + this.usuario + ") " + this.texto);
  }

  public boolean tieneHijos() {
    return this.tieneHijos;
  }

  public Map<Integer, DtComentario> getHijos() {
    return hijos;
  }

  public void setHijos(Map<Integer, DtComentario> hijos) {
    this.hijos = hijos;
  }

  public Integer getId() {
    return idComentario;
  }

  public void setId(Integer idComentario) {
    this.idComentario = idComentario;
  }

  public String getTexto() {
    return texto;
  }

  public void setTexto(String texto) {
    this.texto = texto;
  }

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public Date getFecha() {
    return fecha;
  }

  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }
}
