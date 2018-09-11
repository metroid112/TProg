package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import clases.Calificacion;
import clases.Canal;
import clases.Comentario;
import clases.Usuario;
import clases.Video;
import dataTypes.DtVideo;
import excepciones.DuplicateClassException;
import excepciones.InvalidDataException;
import interfaces.Fabrica;
import interfaces.ICategorias;
import interfaces.IListas;
import interfaces.IUsuariosCanales;
import interfaces.IVideos;
import manejadores.ManejadorCategorias;
import manejadores.ManejadorUsuarios;

public class CtrlVideosTest {

  private String[] arrayCat = { "Deportes", "Musica" };
  private String[] arrayLis = { "(Pato,Lista1)" };
  private String[] arrayVid = { "(Pato,Video1)" };
  private ICategorias categorias = Fabrica.getICategorias();
  private DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
  private IListas lista = Fabrica.getIListas();
  private ManejadorCategorias manejadorCategorias = ManejadorCategorias.getManejadorCategorias();
  private ManejadorUsuarios manejadorUsuarios = ManejadorUsuarios.getManejadorUsuarios();
  private String[] usu = { "Pato" };
  private Date fecha = new Date();
  private Usuario usuario = new Usuario("Pato", "Federico", "Aguilera", "correo@.com", fecha, null);
  private Canal canal = new Canal("canalPato", "descripcionCanal", null, true, usuario);
  private IUsuariosCanales usuarios = Fabrica.getIUsuariosCanales();
  private IVideos video = Fabrica.getIVideos();

  @After
  public void clear() {
    manejadorUsuarios.removeAll();
  }

  @Test
  public void testAltaVideo() {
    carga();
    Duration duracion = Duration.ofMinutes(5);
    Video vid = new Video("Video1", "Descripcion1", duracion, "url", null, null, fecha);
    try {
      video.altaVideo(usuario.getNick(), "Video1", "Descripcion1", duracion, "url", null, fecha);
    } catch (DuplicateClassException e) {
      System.out.println(e.getMessage());
    }
    Assert.assertEquals(vid, manejadorUsuarios.get("Pato").getCanal().getVideoCanal("Video1"));
  }

  @Test
  public void testGetDtVideo() {
    carga();
    Duration duracion = Duration.ofMinutes(5);
    Video vid = new Video("Video1", "Descripcion1", duracion, "url", null, null, fecha);
    try {
      video.altaVideo(usuario.getNick(), "Video1", "Descripcion1", duracion, "url", null, fecha);
    } catch (DuplicateClassException e) {
      System.out.println(e.getMessage());
    }
    DtVideo esperado = new DtVideo("Video1", "Descripcion1", "url", null, fecha, duracion, false,
        new LinkedHashMap<Integer, Comentario>(), new LinkedList<Calificacion>());
    Assert.assertEquals(esperado, video.getDtVideo("Video1", "Pato"));
  }

  @Test
  public void testListarCategorias() throws Exception {
    categorias.altaCategoria("Deportes");
    categorias.altaCategoria("Musica");
    Assert.assertArrayEquals(arrayCat, video.listarCategorias());
  }

  @Test
  public void testListarUsuarios() throws Exception {
    carga();
    Assert.assertArrayEquals(usu, video.listarUsuarios());

  }

  @Test
  public void testListarVideos() {

    // Assert.assertArrayEquals(expecteds, actuals);
  }

  @Test
  public void testModificarVideo() {
    carga();
    Duration duracion = Duration.ofMinutes(5);
    Video vid = new Video("Video2", "Descripcion2", duracion, "url2", null, fecha, true, null);
    try {
      video.altaVideo(usuario.getNick(), "Video1", "Descripcion1", duracion, "url", null, fecha);
      video.modificarVideo(usuario.getNick(), "Video1", "Video2", "Descripcion2", "url2", null,
          duracion, true, fecha);
    } catch (DuplicateClassException | InvalidDataException e) {
      System.out.println(e.getMessage());
    }

    Assert.assertEquals(vid, manejadorUsuarios.get("Pato").getCanal().getVideoCanal("Video2"));
  }

  public void carga() {
    usuario.setCanal(canal);
    manejadorUsuarios.add(usuario);
  }

}
