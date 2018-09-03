package test;

import static org.junit.Assert.fail;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import clases.Categoria;
import clases.ListaParticular;
import dataTypes.DtLista;
import interfaces.Fabrica;
import interfaces.IListas;
import interfaces.IUsuariosCanales;
import manejadores.ManejadorUsuarios;

public class CtrlListasTest {
	
	private IListas ctrlLista = Fabrica.getIListas();
	private IUsuariosCanales ctrlUsuario = Fabrica.getIUsuariosCanales();
	private BufferedImage img = null;
	private ManejadorUsuarios manejadorUsuarios = ManejadorUsuarios.getManejadorUsuarios();
	
	@Before
	public void carga() throws Exception {
		ctrlUsuario.altaUsuario("hectorg", "Héctor", "Guido", "hector.gui@elgalpon.org.uy",new Date(10), img, "hectorg", "Canal HG", "Sin categoria", true);
	}

	@Test
	public void testAltaListaDefecto() throws Exception {
		ctrlLista.altaListaDefecto("listaDefecto2");
		Assert.assertEquals("listaDefecto2", manejadorUsuarios.get("hectorg").getCanal().getListaDefecto().get("listaDefecto2").getNombre());
	}

	@Test
	public void testAltaListaParticular() throws Exception {
		ctrlLista.altaListaParticular("Lista01", "hectorg", true);
		ListaParticular listaEsperada = new ListaParticular("Lista01", manejadorUsuarios.get("hectorg").getCanal(), new HashMap<String,Categoria>(), true);
		Assert.assertEquals(listaEsperada, (ListaParticular) manejadorUsuarios.get("hectorg").getCanal().getLista("Lista01"));
	}
	
	@Test
	public void testGetDt() throws Exception {
		ctrlLista.altaListaParticular("ListagetDt", "hectorg", true);
		DtLista lista = ctrlLista.getDt("ListagetDt", "hectorg");
		DtLista esperado = new DtLista("ListagetDt", "Particular", true, new LinkedList<String>(), new LinkedList<String>());
		Assert.assertEquals(esperado, lista);
	}


}
