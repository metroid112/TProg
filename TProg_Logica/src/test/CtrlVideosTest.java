package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import interfaces.Fabrica;
import interfaces.ICategorias;
import interfaces.IListas;
import interfaces.IUsuariosCanales;
import interfaces.IVideos;
import manejadores.ManejadorCategorias;
import manejadores.ManejadorUsuarios;

public class CtrlVideosTest {
	
	private String[] arrayCat = {"Deportes", "Musica"};
	private String[] arrayLis = {"(Pato,Lista1)"};
	private String[] arrayVid = {"(Pato,Video1)"};
	private ICategorias categorias = fabrica.getICategorias();
	private Fabrica fabrica = Fabrica.getFabrica();
	DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
	private IListas lista = fabrica.getIListas();
	private ManejadorCategorias manejadorCategorias = ManejadorCategorias.getManejadorCategorias();
    private ManejadorUsuarios manejadorUsuarios = ManejadorUsuarios.getManejadorUsuarios();
	private String[] usu = {"Pato"};
	//Usuario usuario = new Usuario("Pato", "Federico", "Aguilera", "correo@.com", format.parse("11/04/1993"));
	private IUsuariosCanales usuarios = fabrica.getIUsuariosCanales();
	private IVideos video = fabrica.getIVideos();
	
	@After
	public void clear() {
		manejadorUsuarios.removeAll();
	}

	@Test
	public void testAltaVideo() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDtVideo() {
		fail("Not yet implemented");
	}

	@Test
	public void testListarCategorias() throws Exception {
		categorias.altaCategoria("Deportes");
		categorias.altaCategoria("Musica");
		Assert.assertArrayEquals(arrayCat, video.listarCategorias());
	}

	@Test
	public void testListarUsuarios() throws Exception {
		
		usuarios.altaUsuario("Pato", "Federico", "Aguilera", "@.com", format.parse("11/04/1993"), "Pato", true);
		assertArrayEquals(usu, usuarios.listarUsuarios());
		
	}

	@Test
	public void testListarVideos() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testModificarVideo() {
		fail("Not yet implemented");
	}

}
