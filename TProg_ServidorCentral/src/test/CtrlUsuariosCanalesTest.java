package test;

import static org.junit.Assert.*;

import org.junit.Test;

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
  public String[] listaUsuarios = { "hrubino", "mbusca", "hectorg", "tabarec", "cachilas", "juliob",
      "diegop", "kairoh", "robinh",
      "marcelot", "novick", "sergiop", "chino", "tonyp", "nicoJ" };

  @Test
  public void test() {

  }

}
