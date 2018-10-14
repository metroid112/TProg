package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import clases.Categoria;
import clases.Video;
import excepciones.DuplicateClassException;
import interfaces.Fabrica;
import interfaces.ICategorias;
import interfaces.IListas;
import interfaces.IUsuariosCanales;
import interfaces.IVideos;
import manejadores.ManejadorCategorias;
import manejadores.ManejadorUsuarios;

public class CtrlCategoriasTest {
  public IUsuariosCanales iUsuarios = Fabrica.getIUsuariosCanales();
  public IListas iListas = Fabrica.getIListas();
  public IVideos iVideos = Fabrica.getIVideos();
  public ICategorias iCategorias = Fabrica.getICategorias();
  
  @Test
  public void AltaCategoriaTest() {
    try {
      iCategorias.altaCategoria("TestTarea2");
    } catch (Exception e) {
      e.printStackTrace();
    }
    assertEquals(true,ManejadorCategorias.getManejadorCategorias().existeCategoria("TestTarea2"));
  }
  
  @test
  public void GetInfoListasTest() {
    String[] esperado = {};
    String[] infoLista = iCategorias.
  }

}
