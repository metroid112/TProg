package test;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import clases.Categoria;
import controladores.CtrlCategorias;
import interfaces.Fabrica;
import interfaces.ICategorias;
import interfaces.IListas;
import interfaces.IUsuariosCanales;
import interfaces.IVideos;
import manejadores.ManejadorCategorias;

public class CtrlCategoriasTest {
	
	private Categoria categoria = new Categoria("Prueba");
	private Fabrica fabrica = Fabrica.getFabrica();
	private ICategorias categorias = fabrica.getICategorias();
	private IUsuariosCanales usuarios = fabrica.getIUsuariosCanales();
	private IListas lista = fabrica.getIListas();
	private IVideos video = fabrica.getIVideos();
	private ManejadorCategorias manejadorCategorias = ManejadorCategorias.getManejadorCategorias();
	private String[] arrayCat = {"Deportes", "Musica"};
	private String[] arrayVid = {"(Pato,Video1)"};
	private String[] arrayLis = {"(Pato,Lista1)"};
	
	@After
	public void clear() {
		manejadorCategorias.removeAll();
	}

	@Test
	public void testAltaCategoria() throws Exception{
		categorias.altaCategoria("Prueba");
		Categoria categoriaPrueba = manejadorCategorias.get("Prueba");
		Assert.assertEquals(categoria, categoriaPrueba);
	}

	@Test
	public void testListarCategorias() throws Exception {
		categorias.altaCategoria("Deportes");
		categorias.altaCategoria("Musica");
		Assert.assertArrayEquals(arrayCat, categorias.listarCategorias());
	}

	@Test
	public void testGetInfoVideos() throws Exception {
		categorias.altaCategoria("Prueba");
		DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		usuarios.altaUsuario("Pato", "Federico", "Aguilera", "pato@hotmail.com", format.parse("11/04/1993"), "Pato", true);
		video.altaVideo("Pato", "Video1", "Jeje", Duration.parse("PT2S"), "https:", "Prueba", format.parse("11/04/1993"));
		Assert.assertArrayEquals(arrayVid, categorias.getInfoVideos("Prueba"));
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
