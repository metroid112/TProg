package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
	CtrlCategoriasTest.class,
	CtrlListasTest.class,
	CtrlUsuariosCanalesTest.class,
	CtrlVideosTest.class
	//ClassManejadorTest.class
})

public class TestSuite {
}
