package test;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import clases.Video;
import datatypes.DtVideo;
import excepciones.DuplicateClassException;
import excepciones.InvalidDataException;
import excepciones.NotFoundException;
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
    interfazVideos.modificarVideo("tabarec", "Locura celeste", "test", "testDescripcion", "https://youtu.be/zBR2pnASlQE", "Noticias", Duration.parse("PT1H"),
        true, new Date());
     
  }
  
  @Test
  public void testListarCategorias() {
    int cantidadCategorias = 13;
    int cantCategoriasObtenidas = interfazVideos.listarCategorias().length;
    assertEquals(cantidadCategorias, cantCategoriasObtenidas);
  }
  
  @Test
  public void testAltaVideo() throws DuplicateClassException, NotFoundException {
    int cantVideosHectorg = interfazVideos.listarVideos("hectorg").length;
    interfazVideos.altaVideo("hectorg", "TestVideo", "testDescripcion", Duration.parse("PT1H"), "https://youtu.be/GzOJSk4urlM", "Noticias",
        new Date(), true);
    assertEquals(cantVideosHectorg + 1, interfazVideos.listarVideos("hectorg").length);
    
  }
  
  @Test
  public void testDtVideo() throws NotFoundException {
   List<DtVideo> listaDtVideos = interfazVideos.getDtVideosPropietario("nicoJ");
   DtVideo vid = listaDtVideos.get(0);
   assertTrue(vid.urlWatchtFormat().contains("https://www.youtube.com/embed/"));
   assertEquals("0:05:39", vid.duracionPrintFormat());
   assertEquals(0, vid.getCantidadCalificacionesNegativas());
   assertEquals(0, vid.getCantidadCalificacionesPositivas());
   interfazUsuarios.valorarVideo("kairoh", true, "Entrevista a director CUTI", "nicoJ");
   interfazUsuarios.valorarVideo("hectorg", true, "Entrevista a director CUTI", "nicoJ");
   interfazUsuarios.valorarVideo("chino", false, "Entrevista a director CUTI", "nicoJ");
   int id = vid.idVideo;
   vid = interfazVideos.getDtVideo(id);
   assertEquals(2, vid.getCalificacionesPositivas().size());
   assertEquals(1, vid.getCalificacionesNegativas().size());
   
   
  }

}
