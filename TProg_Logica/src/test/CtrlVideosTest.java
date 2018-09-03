package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import clases.Usuario;
import interfaces.Fabrica;
import interfaces.ICategorias;
import interfaces.IListas;
import interfaces.IUsuariosCanales;
import interfaces.IVideos;
import manejadores.ManejadorCategorias;
import manejadores.ManejadorUsuarios;

public class CtrlVideosTest {

	private String[] arrayCat = { "Deportes", "Musica" };
	private String[] arrayLis = { "(Pato,Lista1)" };
	private String[] arrayVid = { "(Pato,Video1)" };
	private ICategorias categorias = Fabrica.getICategorias();
	private DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
	private IListas lista = Fabrica.getIListas();
	private ManejadorCategorias manejadorCategorias = ManejadorCategorias.getManejadorCategorias();
	private ManejadorUsuarios manejadorUsuarios = ManejadorUsuarios.getManejadorUsuarios();
	private String[] usu = { "Pato" };
	private Date fecha = new Date();
	private Usuario usuario = new Usuario("Pato", "Federico", "Aguilera", "correo@.com", fecha, null);
	private IUsuariosCanales usuarios = Fabrica.getIUsuariosCanales();
	private IVideos video = Fabrica.getIVideos();

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
		manejadorUsuarios.add(usuario);
		
		Assert.assertArrayEquals(usu, video.listarUsuarios());

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
