package test;

import static org.junit.Assert.*;

import org.junit.Test;

import datatypes.DtUsuario;
import interfaces.Fabrica;
import interfaces.ICategorias;
import interfaces.IListas;
import interfaces.IUsuariosCanales;
import interfaces.IVideos;

public class CtrlUsuariosCanalesTest {
  
  public IUsuariosCanales iUsuarios = Fabrica.getIUsuariosCanales();
  public IListas iListas = Fabrica.getIListas();
  public IVideos iVideos = Fabrica.getIVideos();
  public ICategorias iCategorias = Fabrica.getICategorias();
  public String[] listaUsuarios = {"hrubino", "mbusca", "hectorg", "tabarec", "cachilas", "juliob", "diegop", "kairoh", "robinh", 
      "marcelot", "novick", "sergiop", "chino", "tonyp", "nicoJ"};

  @Test
  public void testIsSeguidor() {
    assertTrue(iUsuarios.isSeguidor("tabarec", "hrubino"));
    assertFalse(iUsuarios.isSeguidor("hrubino", "tabarec"));
    iUsuarios.dejarSeguir("tabarec", "hrubino");
    assertFalse(iUsuarios.isSeguidor("tabarec", "hrubino"));
  }
  
  @Test
  public void testYaCalificado() {
    assertTrue(iUsuarios.yaCalificacdo("sergiop", false, "50 años del InCo", "hectorg"));
    assertFalse(iUsuarios.yaCalificacdo("hectorg", true, "thriller", "kairoh"));
  }
  
  @Test
  public void testModificarValoracion() {
    iUsuarios.modificarValoracion(true, "sergiop", "50 años del InCo", "hectorg");
    assertFalse(iUsuarios.yaCalificacdo("sergiop", false, "50 años del InCo", "hectorg"));
    assertTrue(iUsuarios.yaCalificacdo("sergiop", true, "50 años del InCo", "hectorg"));
  }
  
  @Test
  public void testGetDt() {
    DtUsuario dtUsuario = iUsuarios.getDt("chino");
    assertEquals("Alvaro", dtUsuario.getNombre());
    assertEquals("Recoba",dtUsuario.apellido);
    assertEquals("Chino Recoba",dtUsuario.getCanal());
    assertEquals("chino@trico.org.uy",dtUsuario.correo);
  }
  
  @Test
  public void testLoginPorCorreo() {
    assertTrue(iUsuarios.checkLogin("chino@trico.org.uy", "Laika765"));
  }

}
