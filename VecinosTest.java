package logica;

import static org.junit.Assert.*;

import org.junit.Test;

public class VecinosTest {

	@Test(expected = IllegalArgumentException.class)
	public void testVerticeNegativo() {
		Grafo grafo = new Grafo(5);
		grafo.vecinos(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testVerticeExcedido() {
		Grafo grafo = new Grafo(5);
		grafo.vecinos(5);
	}
	
	@Test
	public void testTodosAislados() {
		Grafo grafo = new Grafo(5);
		assertEquals(0, grafo.vecinos(2).size());
	}
	
	@Test
	public void testVerticeUniversal() {	//quiere decir que es vecinos de todos
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(1, 0,50);
		grafo.agregarArista(1, 2,50);
		grafo.agregarArista(1, 3,50);
		
		int[] esperado = {0,2,3};
		AssertsAuxiliares.iguales(esperado, grafo.vecinos(1));
	}

	@Test
	public void testVerticeNormal() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(1,3,50);
		grafo.agregarArista(2,3,50);
		grafo.agregarArista(2,4,50);
		
		int[] esperado = {1,2};
		AssertsAuxiliares.iguales(esperado, grafo.vecinos(3));
	}
	
	
	

}
