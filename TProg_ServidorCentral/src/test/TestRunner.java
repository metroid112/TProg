package test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
  public static void main(String[] args) {
    System.out.println( "¡Hola pap\u00e1!\nYa puedo escribir bien.\n\u00d1a\u00f1a\u00f1a\u00f1a" );
    Result result = JUnitCore.runClasses(TestSuite.class);

    for (Failure failure : result.getFailures()) {
      System.out.println(failure.toString());
    }

    System.out.println(result.wasSuccessful());
  }
}
