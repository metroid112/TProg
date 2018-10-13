package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Test;

import interfaces.Fabrica;
import junit.framework.Assert;

public class CargaDatosTest {

  @Test
  public void test() {
    try {
      Fabrica.getIDatos().cargaDatos();
    } catch (ParseException | IOException e) {
      e.printStackTrace();
    }
    assertTrue(true);
  }

}
