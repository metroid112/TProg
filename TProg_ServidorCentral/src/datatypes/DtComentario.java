package datatypes;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import clases.Comentario;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtComentario {
  public List<DtComentario> hijos = new LinkedList<DtComentario>();
  public int idComentario;
  public String texto;
  public String usuario;
  public Date fecha;
  private boolean tieneHijos = false;

  public DtComentario(Comentario comentario) {
    this.idComentario = comentario.getId().intValue();
    this.texto = comentario.getTexto();
    this.usuario = comentario.getUsuario().getNick();
    this.fecha = comentario.getFecha();
    if (comentario.tieneRespuestas()) {
      for (Comentario com : comentario.getRespuestas().values()) {
        this.hijos.add(new DtComentario(com));
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

  public List<DtComentario> getHijos() {
    return hijos;
  }

  public void setHijos(List<DtComentario> hijos) {
    this.hijos = hijos;
  }

  public int getId() {
    return idComentario;
  }

  public void setId(int idComentario) {
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
