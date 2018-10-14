package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import clases.ListaParticular;
import clases.Usuario;
import clases.Video;
import datatypes.DtBusqueda;
import interfaces.*;
import manejadores.ManejadorCategorias;
import manejadores.ManejadorListasDefecto;
import manejadores.ManejadorListasParticulares;
import manejadores.ManejadorUsuarios;
import manejadores.ManejadorVideos;

public class CargaDatosTest {
  
  public IUsuariosCanales iUsuarios = Fabrica.getIUsuariosCanales();
  public IListas iListas = Fabrica.getIListas();
  public IVideos iVideos = Fabrica.getIVideos();
  public ICategorias iCategorias = Fabrica.getICategorias();
  public String[] listaUsuarios = {"hrubino", "mbusca", "hectorg", "tabarec", "cachilas", "juliob", "diegop", "kairoh", "robinh", 
      "marcelot", "novick", "sergiop", "chino", "tonyp", "nicoJ"};
  

  @Before
  public void carga() {
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
      if (!iUsuarios.existeUsuario(nombre)) {
        fallo = true;
      }
    }
    assertFalse(fallo);
  }
  
  @Test
  public void testCategorias() {
    String[] cats = {"Musica", "Deporte", "Carnaval", "Noticias", "Entretenimiento", "Comida", "Videojuegos", "Ciencia y Tecnologia",
        "ONG y activismo", "Gente y blogs", "Mascotas y animales", "Viajes y eventos"};
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
     contador += ManejadorUsuarios.getManejadorUsuarios().get(usuario).getCanal().getListaParticulares().size();
    }
    assertTrue(contador == 6);
  }
  
  @Test
  public void testListasDefecto() {
    int contador = 0;
    int esperado = listaUsuarios.length * 3;
    for (String usuario : listaUsuarios) {
      contador += ManejadorUsuarios.getManejadorUsuarios().get(usuario).getCanal().getListaDefecto().size();
    }
    assertEquals(contador, esperado);
  }
  
  @Test
  public void testBusquedaGeneral() {
    String textoBusqueda = "";
    int esperado = 0;
    //Cantidad de videos publicos
    for (Video vid : ManejadorVideos.getManejadorVideos().getVideos().values()) { 
      if (vid.isVisible()) {
        esperado++;
      }
    }
    //Cantidad listas publicas
    for (ListaParticular lis : ManejadorListasParticulares.getManejadorListasParticulares().getListasParticulares().values()) {
      if (lis.isVisible()) {
        esperado++;
      }
    }
    //Cantidad canales publicos
    for (Usuario usu : ManejadorUsuarios.getManejadorUsuarios().getMap().values()) {
      if (usu.getCanal().isVisible()) {
        esperado++;
      }
    }
    DtBusqueda resultados = Fabrica.getIDatos().busquedaGeneral(textoBusqueda);
    int cantidadResultados = resultados.listas.size() + resultados.videos.size() + resultados.usuarios.size();
    System.out.println(esperado);
    assertEquals(esperado, cantidadResultados);
  }
  

}
