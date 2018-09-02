package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import clases.Categoria;
import interfaces.Fabrica;
import interfaces.ICategorias;
import interfaces.IListas;
import interfaces.IUsuariosCanales;
import interfaces.IVideos;
import manejadores.ManejadorCategorias;

public class CtrlCategoriasTest {

	private String[] arrayCat = { "Deportes", "Musica" };
	private String[] arrayLis = { "(Pato,Lista1)" };
	private String[] arrayVid = { "(Pato,Video1)" };
	private Categoria categoria = new Categoria("Prueba");
	private ICategorias categorias = Fabrica.getICategorias();
	private IListas lista = Fabrica.getIListas();
	private ManejadorCategorias manejadorCategorias = ManejadorCategorias.getManejadorCategorias();
	private IUsuariosCanales usuarios = Fabrica.getIUsuariosCanales();
	private IVideos video = Fabrica.getIVideos();

	@After
	public void clear() {
		manejadorCategorias.removeAll();
	}

	@Test
	public void testAltaCategoria() throws Exception {
		categorias.altaCategoria("Prueba");
		Categoria categoriaPrueba = manejadorCategorias.get("Prueba");
		Assert.assertEquals(categoria, categoriaPrueba);
	}

	@Test
	public void testGetInfoVideos() throws Exception {
		categorias.altaCategoria("Prueba");
		DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		// usuarios.altaUsuario("Pato", "Federico", "Aguilera", "pato@hotmail.com",
		// format.parse("11/04/1993"), "Pato", true);
		video.altaVideo("Pato", "Video1", "Jeje", Duration.parse("PT2S"), "https:", "Prueba",
				format.parse("11/04/1993"));
		Assert.assertArrayEquals(arrayVid, categorias.getInfoVideos("Prueba"));
	}

	@Test
	public void testListarCategorias() throws Exception {
		categorias.altaCategoria("Deportes");
		categorias.altaCategoria("Musica");
		Assert.assertArrayEquals(arrayCat, categorias.listarCategorias());
	}

//	@Test
//	public void testGetInfoListas() throws Exception{
//		
//		categorias.altaCategoria("Prueba");
//		DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
//		usuarios.altaUsuario("Pato", "Federico", "Aguilera", "pato@hotmail.com", format.parse("11/04/1993"), "Pato", true);
//		video.altaVideo("Pato", "Video1", "Jeje", Duration.parse("PT2S"), "https:", "Prueba", format.parse("11/04/1993"));
//		lista.altaListaParticular("Lista1", "Pato", true);
//		lista.
//		
//	}

}
