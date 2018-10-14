package test;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.Date;

import org.junit.Test;

import clases.Video;
import excepciones.DuplicateClassException;
import excepciones.InvalidDataException;
import interfaces.Fabrica;
import interfaces.ICategorias;
import interfaces.IListas;
import interfaces.IUsuariosCanales;
import interfaces.IVideos;
import manejadores.ManejadorVideos;

public class CtrlVideosTest {
  
  public IUsuariosCanales interfazUsuarios = Fabrica.getIUsuariosCanales();
  public IListas interfazListas = Fabrica.getIListas();
  public IVideos interfazVideos = Fabrica.getIVideos();
  public ICategorias interfazCategorias = Fabrica.getICategorias();

  @Test
  public void testListarTodosLosVideos() {
    int videosKairoh = 3;
    assertEquals(videosKairoh, interfazVideos.listarVideos("kairoh").length);
    int videosCachilas = 5;
    assertEquals(videosCachilas, interfazVideos.listarVideos("cachilas").length);
    int videosVisiblesCachilas = videosCachilas;
   for (Video vid : ManejadorVideos.getManejadorVideos().getVideos().values()) {
     if (vid.isVisible() && vid.getCanal().getUsuario().getNick() != "cachilas") {
       videosVisiblesCachilas++;
     }
   }
   assertEquals(videosVisiblesCachilas, interfazVideos.listarTodosLosVideos("cachilas").length);
  }
  
  @Test
  public void testModificarVideo() throws InvalidDataException, DuplicateClassException {
    interfazVideos.modificarVideo("tabarec", "Locura celeste", "test", "testDescripcion", "testUrl", "Noticias", Duration.parse("PT1H"),
        true, new Date());
     
  }

}
