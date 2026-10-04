package logica;

import static org.junit.Assert.*;

import org.junit.Test;

public class AristaTest {

	@Test
	public void testExisteArista() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2,3,50);
		assertTrue(grafo.existeArista(2,3));
	}
	
	@Test
	public void testExisteAristaOpuesta() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2,3,50);
		assertTrue(grafo.existeArista(3,2));
	}
	
	@Test
	public void testAristaInexistente() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2,3,50);
		assertFalse(grafo.existeArista(1,4));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPrimerVerticeNegativo() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(-1,3,50);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSegundoVerticeNegativo() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(3,-1,50);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPrimerVerticeExcedido() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(5,3,50);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSegundoVerticeExcedido() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(3,5,50);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testBucle() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(4,4,50);
	}
	
	@Test
	public void testEliminarAristaExistente() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2,4,50);
		grafo.eliminarArista(2,4);
		assertFalse(grafo.existeArista(2,4));
	}
	
	@Test
	public void testEliminarAristaInexistente() {
		Grafo grafo = new Grafo(5);
		grafo.eliminarArista(2,4);
		assertFalse(grafo.existeArista(2,4));
	}
	
	@Test
	public void testAgregarAristaDosVeces() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2,4,50);
		grafo.agregarArista(2,4,50);
		assertTrue(grafo.existeArista(2,4));
	}
	
	@Test
	public void testEliminarAristaDosVeces() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2,4,50);
		grafo.eliminarArista(2,4);
		grafo.eliminarArista(2,4);
		assertFalse(grafo.existeArista(2,4));
	}

}
