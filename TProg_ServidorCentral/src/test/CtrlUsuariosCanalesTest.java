package test;

import org.junit.Test;

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
  public void test() {

  }

}
