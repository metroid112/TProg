package test;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import clases.Canal;
import clases.Categoria;
import clases.Usuario;
import interfaces.Fabrica;
import interfaces.ICategorias;
import interfaces.IListas;
import interfaces.IUsuariosCanales;
import interfaces.IVideos;
import manejadores.ManejadorCategorias;
import manejadores.ManejadorUsuarios;

public class CtrlVideosTest {
	
	DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
	private Fabrica fabrica = Fabrica.getFabrica();
	private ICategorias categorias = fabrica.getICategorias();
	private IUsuariosCanales usuarios = fabrica.getIUsuariosCanales();
	private IListas lista = fabrica.getIListas();
	private IVideos video = fabrica.getIVideos();
	private ManejadorCategorias manejadorCategorias = ManejadorCategorias.getManejadorCategorias();
	private ManejadorUsuarios manejadorUsuarios = ManejadorUsuarios.getManejadorUsuarios();
    private String[] arrayCat = {"Deportes", "Musica"};
	private String[] arrayVid = {"(Pato,Video1)"};
	private String[] arrayLis = {"(Pato,Lista1)"};
	private String[] usu = {"Pato"};
	//Usuario usuario = new Usuario("Pato", "Federico", "Aguilera", "correo@.com", format.parse("11/04/1993"));
	
	@After
	public void clear() {
		manejadorUsuarios.removeAll();
	}

	@Test
	public void testListarUsuarios() throws Exception {
		
		usuarios.altaUsuario("Pato", "Federico", "Aguilera", "@.com", format.parse("11/04/1993"), "Pato", true);
		assertArrayEquals(usu, usuarios.listarUsuarios());
		
	}

	@Test
	public void testListarCategorias() throws Exception {
		categorias.altaCategoria("Deportes");
		categorias.altaCategoria("Musica");
		Assert.assertArrayEquals(arrayCat, video.listarCategorias());
	}

	@Test
	public void testAltaVideo() {
		fail("Not yet implemented");
	}

	@Test
	public void testListarVideos() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDtVideo() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testModificarVideo() {
		fail("Not yet implemented");
	}

}
