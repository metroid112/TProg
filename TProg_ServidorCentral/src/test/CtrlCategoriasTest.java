package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import datatypes.DtCategoria;
import interfaces.Fabrica;
import interfaces.ICategorias;
import interfaces.IListas;
import interfaces.IUsuariosCanales;
import interfaces.IVideos;
import manejadores.ManejadorCategorias;

public class CtrlCategoriasTest {
  public IUsuariosCanales iUsuarios = Fabrica.getIUsuariosCanales();
  public IListas iListas = Fabrica.getIListas();
  public IVideos iVideos = Fabrica.getIVideos();
  public ICategorias iCategorias = Fabrica.getICategorias();

  @Test
  public void altaCategoriaTest() {
    try {
      iCategorias.altaCategoria("TestTarea2");
    } catch (Exception e) {
      e.printStackTrace();
    }
    assertEquals(true, ManejadorCategorias.getManejadorCategorias().existeCategoria("TestTarea2"));
  }

  @Test
  public void getInfoListasTest() {
    String[] esperado = {};
    String[] infoLista = iCategorias.getInfoListas("Viajes y eventos");
    assertArrayEquals(esperado, infoLista);
    int cantInfoLista = iCategorias.getInfoListas("Noticias").length;
    assertEquals(3, cantInfoLista);
  }

  @Test
  public void getInfoListasPublicasTest() {
    String[] esperado = {};
    String[] infoLista = iCategorias.getInfoListasPublicas("Viajes y eventos");
    int cantInfoLista = iCategorias.getInfoListasPublicas("Noticias").length;
    assertEquals(3, cantInfoLista);

  }

  @Test
  public void getInfoVideosTest() {
    String[] esperado = {};
    String[] infoLista = iCategorias.getInfoVideos("Viajes y eventos");
    assertArrayEquals(esperado, infoLista);
    int cant = iCategorias.getInfoVideos("Noticias").length;
    assertEquals(3, cant);
  }

  @Test
  public void getInfoVideosPublicosTest() {
    String[] esperado = {};
    String[] infoLista = iCategorias.getInfoVideosPublicos("Viajes y eventos");
    assertArrayEquals(esperado, infoLista);
    int cant = iCategorias.getInfoVideosPublicos("Noticias").length;
    assertEquals(3, cant);
  }

  @Test
  public void listarCategoriasTest() {
    int esperado = 13;
    List<String> lista = iCategorias.listarCategorias();
    assertEquals(esperado, lista.size());
  }
}
