package test;

import static org.junit.Assert.*;

import org.junit.Test;

import clases.Categoria;
import controladores.CtrlCategorias;
import interfaces.Fabrica;
import interfaces.ICategorias;
import manejadores.ManejadorCategorias;

public class CtrlCategoriasTest {
	
	Categoria categoria = new Categoria("Prueba");
	Fabrica fabrica = Fabrica.getFabrica();
	ICategorias categorias = fabrica.getICategorias();
	ManejadorCategorias manejadorCategorias = ManejadorCategorias.getManejadorCategorias();

	@Test
	public void testCtrlCategorias() {
		fail("Not yet implemented");
	}

	@Test
	public void testAltaCategoria() {
		try {
			categorias.altaCategoria("Prueba");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Categoria categoriaPrueba = manejadorCategorias.get("Prueba");
		if (!categoria.equals(categoriaPrueba)) {
			fail("Diferentes!");	
		}
	}

	@Test
	public void testListarCategorias() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetInfoVideos() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetInfoListas() {
		fail("Not yet implemented");
	}

}
