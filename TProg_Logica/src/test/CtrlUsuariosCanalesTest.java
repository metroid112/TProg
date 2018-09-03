package test;

import static org.junit.Assert.fail;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import clases.Canal;
import clases.Categoria;
import clases.Comentario;
import clases.Usuario;
import clases.Video;
import interfaces.Fabrica;
import interfaces.IUsuariosCanales;
import manejadores.ManejadorUsuarios;

public class CtrlUsuariosCanalesTest {
	
	private BufferedImage image = null;
	private IUsuariosCanales controladorUsuariosCanales = Fabrica.getIUsuariosCanales();
	private Usuario user = new Usuario("Pato", "Federico", "Aguilera", "correoPrueba", new Date(10), image);
	private Canal canal = new Canal("Canal", "Descripcion canal", null, true, user);
	Duration duracion = Duration.ofHours(1);
	private Video video = new Video("Video", "Descripcion video", duracion, "URL", null, canal, new Date(10));
	private Comentario comment = new Comentario("Prueba", user, video, new Date(10));
	
	@Before
	public void setup() {
		user.setCanal(canal);
		canal.agregarVideo(video);		
	}
	
	@After
	public void clear() {
		ManejadorUsuarios.getManejadorUsuarios().clear();
	}

	@Test
	public void testAltaUsuario() throws IOException {
		controladorUsuariosCanales.altaUsuario("Pato", "Federico", "Aguilera", "correoPrueba", new Date(10), image, null, null, null, true);
		Assert.assertEquals(user, ManejadorUsuarios.getManejadorUsuarios().get("Pato"));
	}

	@Test
	public void testComentarVideo() {
		ManejadorUsuarios.getManejadorUsuarios().add(user);
		controladorUsuariosCanales.comentarVideo("Prueba", new Date(10), "Pato", "Video", "Pato");
		Comentario recibido = ManejadorUsuarios.getManejadorUsuarios().get("Pato").getCanal().getVideos().get("Video").getComentario(Comentario.getContador() - 1);
		Assert.assertEquals(comment, recibido);
		//Assert.assertEquals(comment, ManejadorUsuarios.getManejadorUsuarios().get("Pato").getComentario(0));
	}

	@Test
	public void testExisteUsuario() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDt() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsCanalPublico() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsEmailUnique() {
		fail("Not yet implemented");
	}

	@Test
	public void testListarListasDeReproduccion() {
		fail("Not yet implemented");
	}

	@Test
	public void testListarSeguidores() {
		fail("Not yet implemented");
	}

	@Test
	public void testValorarVideo() {
		fail("Not yet implemented");
	}

	@Test
	public void testListarSeguidos() {
		fail("Not yet implemented");
	}

	@Test
	public void testListarUsuarios() {
		fail("Not yet implemented");
	}

	@Test
	public void testListarVideos() {
		fail("Not yet implemented");
	}

	@Test
	public void testListarVideosLista() {
		fail("Not yet implemented");
	}

	@Test
	public void testModificarValoracion() {
		fail("Not yet implemented");
	}

	@Test
	public void testResponderComentario() {
		fail("Not yet implemented");
	}

	@Test
	public void testSeguir() {
		fail("Not yet implemented");
	}

}
