package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import clases.ListaParticular;
import clases.Usuario;
import clases.Video;
import datatypes.DtBusqueda;
import interfaces.Fabrica;
import interfaces.ICategorias;
import interfaces.IListas;
import interfaces.IUsuariosCanales;
import interfaces.IVideos;
import manejadores.ManejadorCategorias;
import manejadores.ManejadorListasParticulares;
import manejadores.ManejadorUsuarios;
import manejadores.ManejadorVideos;

public class CargaDatosTest {

  public IUsuariosCanales interfazUsuarios = Fabrica.getIUsuariosCanales();
  public IListas interfazListas = Fabrica.getIListas();
  public IVideos interfazVideos = Fabrica.getIVideos();
  public ICategorias interfazCategorias = Fabrica.getICategorias();
  public String[] listaUsuarios = { "hrubino", "mbusca", "hectorg", "tabarec", "cachilas", "juliob",
      "diegop", "kairoh", "robinh",
      "marcelot", "novick", "sergiop", "chino", "tonyp", "nicoJ" };
  public String[] listaPass = { "Rufus123", "Cookie234", "Poncho345", "Ketchup1", "Sancho456",
      "Salome56", "Ruffo678", "Corbata15", "Aquiles67",
      "Mancha890", "Xenon987", "Sultan876", "Laika765", "Kitty543", "Albino80" };

  @Before
  public void carga() throws Exception {
    try {
      Fabrica.getIDatos().cargaDatos();
    } catch (ParseException | IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testUsuarios() {
    boolean fallo = false;
    for (String nombre : listaUsuarios) {
      if (!interfazUsuarios.existeUsuario(nombre)) {
        fallo = true;
      }
    }
    assertFalse(fallo);
  }

  @Test
  public void testCategorias() {
    String[] cats = { "Música", "Deporte", "Carnaval", "Noticias", "Entretenimiento", "Comida",
        "Videojuegos", "Ciencia y Tecnología",
        "ONG y activismo", "Gente y blogs", "Mascotas y animales", "Viajes y eventos" };
    boolean fallo = false;
    for (String nombre : cats) {
      if (!ManejadorCategorias.getManejadorCategorias().existeCategoria(nombre)) {
        fallo = true;
      }
    }
    assertFalse(fallo);
  }

  @Test
  public void testVideos() {
    boolean fallo = false;
    int esperado = 22; // Cantidad de videos cargados
    int cantidad = ManejadorVideos.getManejadorVideos().getVideos().size();
    assertTrue(esperado == cantidad);
  }

  @Test
  public void testListasParticulares() {
    int contador = 0;
    for (String usuario : listaUsuarios) {
      contador += ManejadorUsuarios.getManejadorUsuarios().getUsuario(usuario).getCanal()
          .getListaParticulares().size();
    }
    assertTrue(contador == 6);
  }

  @Test
  public void testListasDefecto() {
    int contador = 0;
    int esperado = listaUsuarios.length * 3;
    for (String usuario : listaUsuarios) {
      contador +=
          ManejadorUsuarios.getManejadorUsuarios().getUsuario(usuario).getCanal().getListaDefecto()
              .size();
    }
    assertEquals(contador, esperado);
  }

  @Test
  public void testBusquedaGeneral() {
    String textoBusqueda = "";
    int esperado = 0;
    // Cantidad de videos publicos
    for (Video vid : ManejadorVideos.getManejadorVideos().getVideos().values()) {
      if (vid.isVisible()) {
        esperado++;
      }
    }
    // Cantidad listas publicas
    for (ListaParticular lis : ManejadorListasParticulares.getManejadorListasParticulares()
        .getListasParticulares().values()) {
      if (lis.isVisible()) {
        esperado++;
      }
    }
    // Cantidad canales publicos
    for (Usuario usu : ManejadorUsuarios.getManejadorUsuarios().getUsuarios().values()) {
      if (usu.getCanal().isVisible()) {
        esperado++;
      }
    }
    DtBusqueda resultados = Fabrica.getIDatos().busquedaGeneral(textoBusqueda);
    int cantidadResultados =
        resultados.listas.size() + resultados.videos.size() + resultados.usuarios.size();
    assertEquals(esperado, cantidadResultados);
  }

  @Test
  public void testMails() {
    String[] mails = { "horacio.rubino@guambia.com.uy", "Martin.bus@agadu.org.uy",
        "hector.gui@elgalpon.org.uy", "tabare.car@agadu.org.uy",
        "Cachila.sil@c1080.org.uy", "juliobocca@sodre.com.uy", "diego@efectocine.com",
        "kairoher@pilsenrock.com.uy", "Robin.h@tinglesa.com.uy",
        "marcelot@ideasdelsur.com.ar", "edgardo@novick.com.uy", "puglia@alpanpan.com.uy",
        "chino@trico.org.uy", "eltony@manya.org.uy",
        "jodal@artech.com.uy" };
    boolean fallo = false;
    for (String mail : mails) {
      if (!interfazUsuarios.existeUsuarioMail(mail)) {
        fallo = true;
      }
    }
    assertFalse(fallo);
  }

  @Test
  public void testCanalesPublicos() {
    int esperadoPub = 12;
    int esperadoPri = 3;
    int publicos = 0;
    int privados = 0;
    for (String usuario : listaUsuarios) {
      if (interfazUsuarios.isCanalPublico(usuario)) {
        publicos++;
      } else {
        privados++;
      }
    }
    assertEquals(esperadoPub, publicos);
    assertEquals(esperadoPri, privados);
  }

  @Test
  public void testSeguidores() {
    int[] seguidoresEsperado = { 3, 3, 3, 2, 4, 4, 5, 2, 0, 0, 0, 1, 1, 1, 0 };
    int[] seguidores = new int[15];
    int contador = 0;
    for (String usuario : listaUsuarios) {
      seguidores[contador] = interfazUsuarios.getSeguidores(usuario).size();
      contador++;
    }
    assertArrayEquals(seguidoresEsperado, seguidores);
  }

  @Test
  public void testSeguidos() {
    int[] seguidosEsperado = { 2, 3, 2, 2, 1, 2, 1, 1, 3, 3, 3, 3, 1, 1, 1 };
    int[] seguidos = new int[15];
    int contador = 0;
    for (String usuario : listaUsuarios) {
      seguidos[contador] = interfazUsuarios.getSeguidos(usuario).size();
      contador++;
    }
    assertArrayEquals(seguidosEsperado, seguidos);
  }

  @Test
  public void testLogin() {
    int contador = 0;
    boolean fallo = false;
    for (String usuario : listaUsuarios) {
      if (!interfazUsuarios.checkLogin(usuario, listaPass[contador])) {
        fallo = true;
        System.out.println(listaPass[contador]);
      }
      contador++;
    }
    assertFalse(fallo);
  }

  @Test
  public void testListarNombresUsuarios() {
    List<String> usuariosListados = interfazUsuarios.listarNombresUsuarios();
    boolean fallo = false;
    for (String usuario : listaUsuarios) {
      if (!usuariosListados.contains(usuario)) {
        fallo = true;
      }
    }
    assertFalse(fallo);
  }

}
