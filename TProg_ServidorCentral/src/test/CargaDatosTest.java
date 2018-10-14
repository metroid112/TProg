package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import interfaces.*;

public class CargaDatosTest {
  
  public IUsuariosCanales iUsuarios = Fabrica.getIUsuariosCanales();
  public IListas iListas = Fabrica.getIListas();
  public IVideos iVideos = Fabrica.getIVideos();
  public ICategorias iCategorias = Fabrica.getICategorias();
  

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
    System.out.println(iUsuarios.listarNombresUsuarios());
    boolean fallo = false;
    for (String nombre : iUsuarios.listarNombresUsuarios()) {
      if (!iUsuarios.existeUsuario(nombre)) {
        fallo = true;
      }
    }
    assertFalse(fallo);
  }

}
