package test;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Test;

import datatypes.DtPaquete;
import interfaces.Fabrica;
import servicios.Publicador;

public class TestServicio {

  @Test
  public void test() throws ParseException, IOException, Exception {
    Fabrica.getIDatos().cargaDatos();
    Publicador publicador = new Publicador();
    DtPaquete hola = publicador.listarCategorias();
    hola.getListaDt();
  }

}
