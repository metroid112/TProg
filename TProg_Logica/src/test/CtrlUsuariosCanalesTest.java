package test;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import clases.Calificacion;
import clases.Canal;
import clases.Comentario;
import clases.Usuario;
import clases.Video;
import datatypes.DtUsuario;
import interfaces.Fabrica;
import interfaces.IListas;
import interfaces.IUsuariosCanales;
import manejadores.ManejadorUsuarios;

public class CtrlUsuariosCanalesTest {

  private BufferedImage image = null;
  private IUsuariosCanales controladorUsuariosCanales = Fabrica.getIUsuariosCanales();
  private Usuario user = new Usuario("Pato", "Federico", "Aguilera", "correoPrueba", new Date(10),
      image);
  private Canal canal = new Canal("Canal", "Descripcion canal", null, true, user);
  private Duration duracion = Duration.ofHours(1);
  private Video video = new Video("Video", "Descripcion video", duracion, "URL", null, canal,
      new Date(10));
  private Comentario comment = new Comentario("Prueba", user, video, new Date(10));
  private Comentario respuesta = new Comentario("Prueba1", user, video, comment, new Date(50));
  private IListas ctrlListas = Fabrica.getIListas();

  @Before
  public void setup() {
    user.setCanal(canal);
    canal.agregarVideo(video);
  }

  @After
  public void clear() {
    ManejadorUsuarios.getManejadorUsuarios().clear();
  }

  @Test
  public void testAltaUsuario() throws IOException {
    controladorUsuariosCanales.altaUsuario("Pato", "Federico", "Aguilera", "correoPrueba",
        new Date(10), image, null, null, null, true);
    Assert.assertEquals(user, ManejadorUsuarios.getManejadorUsuarios().get("Pato"));
  }

  @Test
  public void testComentarVideo() {
    ManejadorUsuarios.getManejadorUsuarios().add(user);
    controladorUsuariosCanales.comentarVideo("Prueba", new Date(10), "Pato", "Video", "Pato");
    Comentario recibido = ManejadorUsuarios.getManejadorUsuarios().get("Pato").getCanal()
        .getVideos().get("Video").getComentario(Comentario.getContador() - 1);
    Assert.assertEquals(comment, recibido);
    // Assert.assertEquals(comment,
    // ManejadorUsuarios.getManejadorUsuarios().get("Pato").getComentario(0));
  }

  @Test
  public void testExisteUsuario() {
    ManejadorUsuarios.getManejadorUsuarios().add(user);
    Assert.assertTrue(controladorUsuariosCanales.existeUsuario(user.getNick()));
  }

  @Test
  public void testGetDt() {
    DtUsuario dtEsperado = new DtUsuario("Federico", "Aguilera", user.getCanal().getNombre(),
        user.getCorreo(), user.getCanal().getDescripcion(), user.getFecha(), user.getImagen(),
        true);
    ManejadorUsuarios.getManejadorUsuarios().add(user);
    Assert.assertEquals(dtEsperado, controladorUsuariosCanales.getDt(user.getNick()));
  }

  @Test
  public void testIsCanalPublico() {
    ManejadorUsuarios.getManejadorUsuarios().add(user);
    Assert.assertTrue(controladorUsuariosCanales.isCanalPublico(user.getNick()));
  }

  @Test
  public void testIsEmailUnique() {
    ManejadorUsuarios.getManejadorUsuarios().add(user);
    Assert.assertFalse(controladorUsuariosCanales.isEmailUnique("correoPrueba"));
  }

  @Test
  public void testListarListasDeReproduccion() {
    try {
      controladorUsuariosCanales.altaUsuario("Pato", "Federico", "Aguilera", "correoPrueba",
          new Date(10), image, "canalPato", "Descripcioncanal", null, true);
      ctrlListas.altaListaDefecto("listaDefecto");
      ctrlListas.altaListaParticular("listaParticular", "Pato", true);
      String[] esperado = { "listaDefecto2", "listaDefecto", "listaParticular" };
      Assert.assertArrayEquals(esperado,
          controladorUsuariosCanales.listarListasDeReproduccion("Pato"));
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  @Test
  public void testValorarVideo() throws Exception {
    ManejadorUsuarios.getManejadorUsuarios().add(user);
    Calificacion calEsperada = new Calificacion(true, user, video);
    controladorUsuariosCanales.valorarVideo(user.getNick(), true, video.getNombre(),
        video.getCanal().getUsuario().getNick());
    Assert.assertEquals(calEsperada, user.getCalificaciones().getFirst());
  }

  @Test
  public void testListarSeguidos() {
    Usuario seguidor = new Usuario("josefe", "Jose", "Fernandez", "correoPrueba2", new Date(15),
        image);
    Canal canal2 = new Canal("Canal1", "Descripcion canal1", null, true, seguidor);
    seguidor.setCanal(canal2);
    ManejadorUsuarios.getManejadorUsuarios().add(user);
    ManejadorUsuarios.getManejadorUsuarios().add(seguidor);
    controladorUsuariosCanales.seguir(seguidor.getNick(), user.getNick());
    Assert.assertEquals(user.getNick(),
        controladorUsuariosCanales.listarSeguidos(seguidor.getNick())[0]);
  }

  @Test
  public void testListarUsuarios() {
    ManejadorUsuarios.getManejadorUsuarios().add(user);
    String[] esperado = { "Pato" };
    Assert.assertArrayEquals(esperado, controladorUsuariosCanales.listarUsuarios());
  }

  @Test
  public void testListarVideos() {
    ManejadorUsuarios.getManejadorUsuarios().add(user);
    String[] esperado = { "Video" };
    Assert.assertArrayEquals(esperado, controladorUsuariosCanales.listarVideos(user.getNick()));
  }

  /*
   * @Test public void testListarVideosLista() { try {
   * ManejadorUsuarios.getManejadorUsuarios().add(user);
   * controladorUsuariosCanales.altaUsuario("Pato", "Federico", "Aguilera", "correoPrueba", new
   * Date(10), image, "canalPato", "Descripcioncanal", null, true);
   * ctrlListas.altaListaDefecto("listaDefecto"); ctrlListas.altaListaParticular("listaParticular",
   * "Pato", true); IListas ctrlLista = Fabrica.getIListas();
   * ctrlLista.agregarVideoLista(user.getNick(), video.getNombre(), "Pato", "listaParticular",
   * false); String[] esperado = {video.getNombre()}; Assert.assertArrayEquals(esperado,
   * controladorUsuariosCanales.listarVideosLista(user.getNick(), "listaParticular", false)); }
   * catch (Exception e) { System.out.println(e.getMessage()); } }
   */
  @Test
  public void testModificarValoracion() throws Exception {
    ManejadorUsuarios.getManejadorUsuarios().add(user);
    Calificacion calEsperada = new Calificacion(false, user, video);
    controladorUsuariosCanales.valorarVideo(user.getNick(), true, video.getNombre(),
        video.getCanal().getUsuario().getNick());
    controladorUsuariosCanales.modificarValoracion(false, user.getNick(), video.getNombre(),
        video.getCanal().getUsuario().getNick());
    Assert.assertEquals(calEsperada, user.getCalificaciones().getFirst());
  }

  @Test
  public void testResponderComentario() {
    ManejadorUsuarios.getManejadorUsuarios().add(user);
    controladorUsuariosCanales.comentarVideo("Prueba", new Date(10), "Pato", "Video", "Pato");
    controladorUsuariosCanales.responderComentario("Prueba1", new Date(50), user.getNick(),
        video.getNombre(), user.getNick(), Comentario.getContador() - 1);
    Comentario recibido = ManejadorUsuarios.getManejadorUsuarios().get("Pato").getCanal()
        .getVideos().get("Video").getComentario(Comentario.getContador() - 2);
    Assert.assertEquals(comment, recibido);
  }

  @Test
  public void testSeguir() {
    Usuario seguidor = new Usuario("josefe", "Jose", "Fernandez", "correoPrueba2", new Date(15),
        image);
    Canal canal2 = new Canal("Canal1", "Descripcion canal1", null, true, seguidor);
    seguidor.setCanal(canal2);
    ManejadorUsuarios.getManejadorUsuarios().add(user);
    ManejadorUsuarios.getManejadorUsuarios().add(seguidor);
    controladorUsuariosCanales.seguir(seguidor.getNick(), user.getNick());
    Assert.assertEquals(seguidor,
        user.getSeguidores().get(controladorUsuariosCanales.listarSeguidores(user.getNick())[0]));
    // Assert.assertEquals(seguidor, user.getSeguidores().get("josefe"));

  }

  @Test
  public void testAltaVideoCanal() {
    canal.altaVideo("pruebaVideo", "", duracion, "url123", null, new Date(50), false);
    Video esperado = new Video("pruebaVideo", "", duracion, "url123", null, canal, new Date(50));
    Assert.assertEquals(esperado, canal.getVideoCanal("pruebaVideo"));
  }

}
