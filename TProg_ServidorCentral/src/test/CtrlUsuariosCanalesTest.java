package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import datatypes.DtUsuario;
import interfaces.Fabrica;
import interfaces.ICategorias;
import interfaces.IListas;
import interfaces.IUsuariosCanales;
import interfaces.IVideos;

public class CtrlUsuariosCanalesTest {

  public IUsuariosCanales interfazUsuarios = Fabrica.getIUsuariosCanales();
  public IListas interfazListas = Fabrica.getIListas();
  public IVideos interfazVideos = Fabrica.getIVideos();
  public ICategorias interfazCategorias = Fabrica.getICategorias();
  public String[] listaUsuarios = { "hrubino", "mbusca", "hectorg", "tabarec", "cachilas", "juliob",
      "diegop", "kairoh", "robinh",
      "marcelot", "novick", "sergiop", "chino", "tonyp", "nicoJ" };

  @Test
  public void testIsSeguidor() {
    assertTrue(interfazUsuarios.isSeguidor("tabarec", "hrubino"));
    assertFalse(interfazUsuarios.isSeguidor("hrubino", "tabarec"));
    interfazUsuarios.dejarSeguir("tabarec", "hrubino");
    assertFalse(interfazUsuarios.isSeguidor("tabarec", "hrubino"));
  }

  @Test
  public void testYaCalificado() {
    assertTrue(interfazUsuarios.yaCalificacdo("sergiop", false, "50 años del InCo", "hectorg"));
    assertFalse(interfazUsuarios.yaCalificacdo("hectorg", true, "thriller", "kairoh"));
  }

  @Test
  public void testModificarValoracion() {
    interfazUsuarios.modificarValoracion(true, "sergiop", "50 años del InCo", "hectorg");
    assertFalse(interfazUsuarios.yaCalificacdo("sergiop", false, "50 años del InCo", "hectorg"));
    assertTrue(interfazUsuarios.yaCalificacdo("sergiop", true, "50 años del InCo", "hectorg"));
  }

  @Test
  public void testGetDt() {
    DtUsuario dtUsuario = interfazUsuarios.getDt("chino");
    assertEquals("Alvaro", dtUsuario.getNombre());
    assertEquals("Recoba", dtUsuario.getApellido());
    assertEquals("Chino Recoba", dtUsuario.getCanal());
    assertEquals("chino@trico.org.uy", dtUsuario.getCorreo());
  }

  @Test
  public void testLoginPorCorreo() {
    assertTrue(interfazUsuarios.checkLogin("chino@trico.org.uy", "Laika765"));
  }

}
