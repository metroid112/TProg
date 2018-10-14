package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import clases.Video;
import excepciones.DuplicateClassException;
import interfaces.Fabrica;
import interfaces.ICategorias;
import interfaces.IListas;
import interfaces.IUsuariosCanales;
import interfaces.IVideos;
import manejadores.ManejadorUsuarios;

public class CtrlListasTest {
  public IUsuariosCanales iUsuarios = Fabrica.getIUsuariosCanales();
  public IListas iListas = Fabrica.getIListas();
  public IVideos iVideos = Fabrica.getIVideos();
  public ICategorias iCategorias = Fabrica.getICategorias();

  @Test
  public void testAgregarVideoLista() {
    try {
      iListas.agregarVideoLista("hectorg", "100 años de FING", "kairoh", "Nostalgia", false);
      List<Video> listaVideos = ManejadorUsuarios.getManejadorUsuarios().get("kairoh").getCanal().getLista("Nostalgia").getVideos();
      boolean pertenece = false;
      for (Video vid : listaVideos) {
        if (vid.getNombre().equals("100 años de FING")) {
          pertenece = true;
        }
      }
      assertTrue(pertenece);
    } catch (Exception e) {
    }
  }
  
  @Test
  public void testQuitarVideoLista() throws Exception {
    iListas.quitarVideoLista("kairoh", "100 años de FING", "hectorg", "Nostalgia", false);
    List<Video> listaVideos = ManejadorUsuarios.getManejadorUsuarios().get("kairoh").getCanal().getLista("Nostalgia").getVideos();
    boolean pertenece = false;
    for (Video vid : listaVideos) {
      if (vid.getNombre().equals("100 años de FING")) {
        pertenece = true;
      }
    }
    assertFalse(pertenece);
  }

}
