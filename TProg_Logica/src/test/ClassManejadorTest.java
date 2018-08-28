package test;

import org.junit.*;

import clases.Categoria;
import clases.Usuario;
import manejadores.ManejadorCategorias;
import manejadores.ManejadorListas;
import manejadores.ManejadorUsuarios;

public class ClassManejadorTest {

	@Test
	public void testManejadorCategoriaAdd() {
		ManejadorCategorias manejadorCategoria = ManejadorCategorias.getManejadorCategorias();
		Categoria categoria = new Categoria();
		manejadorCategoria.add(categoria);
		Assert.assertEquals(true, manejadorCategoria.isMember(categoria));
	}

	@Test
	public void testManejadorCategoriaRemove() {
		ManejadorCategorias manejadorCategoria = ManejadorCategorias.getManejadorCategorias();
		Categoria categoria = new Categoria();
		manejadorCategoria.add(categoria);
		Assert.assertEquals(true, manejadorCategoria.isMember(categoria));
		manejadorCategoria.remove(categoria);
		Assert.assertEquals(false, manejadorCategoria.isMember(categoria));
	}

	@Test
	public void testManejadorCategoriasToArray() {
		ManejadorCategorias manejadorCategoria = ManejadorCategorias.getManejadorCategorias();
		Categoria categoria = new Categoria();
		categoria.setNombre("Test toArray() en espacio 0");
		manejadorCategoria.add(categoria);
		System.out.println("\t" + manejadorCategoria.toArray()[0] + "\n");
	}

	@Test
	public void testManejadorListaAdd() {
		ManejadorListas manejadorLista = ManejadorListas.getManejadorListas();
		String listaDefecto = "Lista";
		manejadorLista.add(listaDefecto);
		Assert.assertEquals(true, manejadorLista.isMember(listaDefecto));
	}

	@Test
	public void testManejadorListaRemove() {
		ManejadorListas manejadorLista = ManejadorListas.getManejadorListas();
		String listaDefecto = "Lista";
		manejadorLista.add(listaDefecto);
		Assert.assertEquals(true, manejadorLista.isMember(listaDefecto));
		manejadorLista.remove(listaDefecto);
		Assert.assertEquals(false, manejadorLista.isMember(listaDefecto));
	}

	@Test
	public void testManejadorListaToArray() {
		ManejadorListas manejadorLista = ManejadorListas.getManejadorListas();
		String listaDefecto = "Lista";
		manejadorLista.add(listaDefecto);
		Assert.assertEquals(true, manejadorLista.isMember(listaDefecto));
		System.out.println("\t" + manejadorLista.toArray()[0] + "\n");
	}

	@Test
	public void testManejadorUsuarioAdd() {
		ManejadorUsuarios manejadorUsuario = ManejadorUsuarios.getManejadorUsuarios();
		Usuario usuario = new Usuario();
		usuario.setNick("user");
		manejadorUsuario.add(usuario);
		Assert.assertEquals(true, manejadorUsuario.isMember(usuario));
	}

	@Test
	public void testManejadorUsuarioRemove() {
		ManejadorUsuarios manejadorUsuario = ManejadorUsuarios.getManejadorUsuarios();
		Usuario usuario = new Usuario();
		usuario.setNick("user");
		manejadorUsuario.add(usuario);
		Assert.assertEquals(true, manejadorUsuario.isMember(usuario));
		manejadorUsuario.remove(usuario);
		Assert.assertEquals(false, manejadorUsuario.isMember(usuario));
	}

	@Test
	public void testManejadorUsuarioToArray() {
		ManejadorUsuarios manejadorUsuario = ManejadorUsuarios.getManejadorUsuarios();
		Usuario usuario = new Usuario();
		usuario.setNick("user");
		manejadorUsuario.add(usuario);
		Assert.assertEquals(true, manejadorUsuario.isMember(usuario));
		System.out.println("\t" + manejadorUsuario.toArray()[0] + "\n");
	}
}
