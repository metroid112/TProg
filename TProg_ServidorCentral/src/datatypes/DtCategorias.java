package datatypes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import clases.ListaParticular;
import clases.Video;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtCategorias extends DtUniversal {

  public Map<String, DtCategoria> categorias = new HashMap<String, DtCategoria>();

  public DtCategorias(Map<String, DtCategoria> categorias) {
    this.categorias = categorias;
  }

  public Map<String, DtCategoria> getCategorias() {
    return this.categorias;
  }

  public void setCategorias(Map<String, DtCategoria> categorias) {
    this.categorias = categorias;
  }
}
