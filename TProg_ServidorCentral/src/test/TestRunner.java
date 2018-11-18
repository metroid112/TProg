package test;

import servicios.Publicador;

public class TestRunner {
  public static void main(String[] args) {
    Publicador publicador = new Publicador();
    publicador.publicar();
  }
}
