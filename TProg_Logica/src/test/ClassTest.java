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
		System.out.println("Testeo manejador categoria");
		ManejadorCategorias manejadorCategoria = new ManejadorCategorias();
		Categoria categoria = new Categoria();
		manejadorCategoria.add(categoria);
		Assert.assertEquals(true, manejadorCategoria.isMember(categoria));
		manejadorCategoria.remove(categoria);
		Assert.assertEquals(false, manejadorCategoria.isMember(categoria));
		System.out.println("Termino test manejador categoria\n");
	}
	
	public void testManejadorLista() {
		System.out.println("Testeo manejador lista");
		ManejadorListas manejadorLista = new ManejadorListas();
		String listaDefecto = "Lista";
		manejadorLista.add(listaDefecto);
		Assert.assertEquals(true, manejadorLista.isMember(listaDefecto));
		manejadorLista.remove(listaDefecto);
		Assert.assertEquals(false, manejadorLista.isMember(listaDefecto));
		System.out.println("Termino test manejador lista\n");
	}
	
	public void testManejadorUsuario() {		
		System.out.println("Testeo manejador usuario");
		ManejadorUsuarios manejadorUsuario = new ManejadorUsuarios();
		Usuario usuario = new Usuario();
		manejadorUsuario.add(usuario);
		Assert.assertEquals(true, manejadorUsuario.isMember(usuario));
		manejadorUsuario.remove(usuario);
		Assert.assertEquals(false, manejadorUsuario.isMember(usuario));
		System.out.println("Termino test manejador usuario\n");
	}
}
