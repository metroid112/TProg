package test;

import org.junit.Assert;
import org.junit.Test;

import clases.Categoria;
import clases.Usuario;
import manejadores.ManejadorCategorias;
import manejadores.ManejadorListas;
import manejadores.ManejadorUsuarios;

public class ClassManejadorTest {
	
	private ManejadorCategorias manejadorCategoria = ManejadorCategorias.getManejadorCategorias();
	private ManejadorListas manejadorLista = ManejadorListas.getManejadorListas();
	private ManejadorUsuarios manejadorUsuario = ManejadorUsuarios.getManejadorUsuarios();

	@Test
	public void testManejadorCategoriaAdd() {
		Categoria categoria = new Categoria();
		manejadorCategoria.add(categoria);
		Assert.assertTrue(manejadorCategoria.isMember(categoria));
	}

	@Test
	public void testManejadorCategoriaRemove() {
		Categoria categoria = new Categoria();
		manejadorCategoria.add(categoria);
		Assert.assertTrue(manejadorCategoria.isMember(categoria));
		manejadorCategoria.remove(categoria);
		Assert.assertTrue(manejadorCategoria.isMember(categoria));
	}

	@Test
	public void testManejadorCategoriasToArray() {
		Categoria categoria = new Categoria();
		categoria.setNombre("Test toArray() en espacio 0");
		manejadorCategoria.add(categoria);
		System.out.println("\t" + manejadorCategoria.toArray()[0] + "\n");
	}

	@Test
	public void testManejadorListaAdd() {
		String listaDefecto = "Lista";
		manejadorLista.add(listaDefecto);
		Assert.assertTrue(manejadorLista.isMember(listaDefecto));
	}

	@Test
	public void testManejadorListaRemove() {
		String listaDefecto = "Lista";
		manejadorLista.add(listaDefecto);
		Assert.assertTrue(manejadorLista.isMember(listaDefecto));
		manejadorLista.remove(listaDefecto);
		Assert.assertFalse(manejadorLista.isMember(listaDefecto));
	}

	@Test
	public void testManejadorListaToArray() {
		String listaDefecto = "Lista";
		manejadorLista.add(listaDefecto);
		Assert.assertTrue(manejadorLista.isMember(listaDefecto));
		System.out.println("\t" + manejadorLista.toArray()[0] + "\n");
	}

	@Test
	public void testManejadorUsuarioAdd() {
		Usuario usuario = new Usuario();
		usuario.setNick("user");
		manejadorUsuario.add(usuario);
		Assert.assertTrue(manejadorUsuario.isMember(usuario));
	}

	@Test
	public void testManejadorUsuarioRemove() {
		Usuario usuario = new Usuario();
		usuario.setNick("user");
		manejadorUsuario.add(usuario);
		Assert.assertTrue(manejadorUsuario.isMember(usuario));
		manejadorUsuario.remove(usuario);
		Assert.assertFalse(manejadorUsuario.isMember(usuario));
	}

	@Test
	public void testManejadorUsuarioToArray() {
		Usuario usuario = new Usuario();
		usuario.setNick("user");
		manejadorUsuario.add(usuario);
		Assert.assertTrue(manejadorUsuario.isMember(usuario));
		System.out.println("\t" + manejadorUsuario.toArray()[0] + "\n");
	}
}
