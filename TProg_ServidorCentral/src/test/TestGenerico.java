package test;

import org.junit.Test;

import clases.Imagen;
import excepciones.NotFoundException;

public class TestGenerico {

  @Test
  public void test() throws NotFoundException {
    Imagen.borrar(234);
  }

}
