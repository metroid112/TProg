package test;

import org.junit.Assert;

import clases.Categoria;
import clases.Usuario;
import manejadores.ManejadorCategorias;
import manejadores.ManejadorListas;
import manejadores.ManejadorUsuarios;

public class ClassTest {
	
	public void testManejadores() {
		testManejadorCategoria();
		testManejadorLista();
		testManejadorUsuario();
	}

	public void testManejadorCategoria() {
		System.out.println("Testeo manejador categoria\n");
		testManejadorCategoriaAdd();
		testManejadorCategoriaRemove();
		testManejadorCategoriasToArray();
		System.out.println("Termino test manejador categoria\n");
	}
	
	public void testManejadorCategoriaAdd() {
		ManejadorCategorias manejadorCategoria = new ManejadorCategorias();
		Categoria categoria = new Categoria();
		manejadorCategoria.add(categoria);
		Assert.assertEquals(true, manejadorCategoria.isMember(categoria));
	}
	
	public void testManejadorCategoriaRemove() {
		ManejadorCategorias manejadorCategoria = new ManejadorCategorias();
		Categoria categoria = new Categoria();
		manejadorCategoria.add(categoria);
		Assert.assertEquals(true, manejadorCategoria.isMember(categoria));
		manejadorCategoria.remove(categoria);
		Assert.assertEquals(false, manejadorCategoria.isMember(categoria));
	}
	
	public void testManejadorCategoriasToArray() {
		ManejadorCategorias manejadorCategoria = new ManejadorCategorias();
		Categoria categoria = new Categoria();
		categoria.setNombre("Test toArray() en espacio 0");
		manejadorCategoria.add(categoria);
		System.out.println("\t" + manejadorCategoria.toArray()[0] + "\n");
	}
	
	public void testManejadorLista() {
		System.out.println("Testeo manejador lista");
		ManejadorListas manejadorLista = new ManejadorListas();
		String listaDefecto = "Lista";
		manejadorLista.add(listaDefecto);
		Assert.assertEquals(true, manejadorLista.isMember(listaDefecto));
		//manejadorLista.remove(listaDefecto);
		//Assert.assertEquals(false, manejadorLista.isMember(listaDefecto));
		
		System.out.println(manejadorLista.toArray()[0]);
		System.out.println("Termino test manejador lista\n");
	}
	
	public void testManejadorUsuario() {		
		System.out.println("Testeo manejador usuario");
		ManejadorUsuarios manejadorUsuario = new ManejadorUsuarios();
		Usuario usuario = new Usuario();
		usuario.setNick("user");
		manejadorUsuario.add(usuario);
		Assert.assertEquals(true, manejadorUsuario.isMember(usuario));
		//manejadorUsuario.remove(usuario);
		//Assert.assertEquals(false, manejadorUsuario.isMember(usuario));
		
		System.out.println(manejadorUsuario.toArray()[0]);
		System.out.println("Termino test manejador usuario\n");
	}
}
