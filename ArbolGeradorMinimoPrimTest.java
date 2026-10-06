package logica;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class ArbolGeradorMinimoPrimTest {

	@Test
	public void testAristaMenorQueVertice() {
	    Grafo grafo = new Grafo(4);
	    grafo.agregarArista(0, 1, 10.0);
	    grafo.agregarArista(1, 2, 20.0);
	    grafo.agregarArista(2, 3, 30.0);
	    grafo.agregarArista(0, 3, 100.0); 
	    List<Arista> agm = ArbolGeneradorMinimoPrim.calcularAGM(grafo);
	    assertEquals(3, agm.size());
	}

	@Test
	public void testCaminoMasBarato() {
	    Grafo grafo = new Grafo(4);
	    grafo.agregarArista(0, 1, 10.0);
	    grafo.agregarArista(1, 2, 20.0);
	    grafo.agregarArista(2, 3, 30.0);
	    grafo.agregarArista(0, 3, 100.0); 
	    List<Arista> agm = ArbolGeneradorMinimoPrim.calcularAGM(grafo);
	    double pesoTotal = 0;
	    for (Arista arista : agm) {
	        pesoTotal += arista.getPeso();
	    }
	    assertEquals(60.0, pesoTotal, 0.001);
	}
	
	@Test
	public void testPesosIgualesNoBucle() {
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(0, 1, 10);
		grafo.agregarArista(1, 2, 10);
		grafo.agregarArista(2, 3, 10);
		grafo.agregarArista(3, 0, 10);
		List<Arista> agm = ArbolGeneradorMinimoPrim.calcularAGM(grafo);
	    double pesoTotal = 0;
	    for (Arista arista : agm) {
	        pesoTotal += arista.getPeso();
	    }
	    assertEquals(30.0, pesoTotal, 0.001);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testGrafoVacio() {
		Grafo grafo = new Grafo(0);
		List<Arista> agm = ArbolGeneradorMinimoPrim.calcularAGM(grafo);
	}
	
	@Test
	public void testGrafoDeUnVertice() {
		Grafo grafo = new Grafo(1);
		List<Arista> agm = ArbolGeneradorMinimoPrim.calcularAGM(grafo);
		assertEquals(0, agm.size());
	}
	
	@Test
	public void testGrafoDeDosVertices() {
		Grafo grafo = new Grafo(2);
		grafo.agregarArista(0,1, 10);
		List<Arista> agm = ArbolGeneradorMinimoPrim.calcularAGM(grafo);
		assertEquals(1, agm.size());
	    assertEquals(10.0, agm.get(0).getPeso(), 0.001);
	}
	
	@Test
	public void testGrafoDesconectado() {
		Grafo grafo = new Grafo(5);
		List<Arista> agm = ArbolGeneradorMinimoPrim.calcularAGM(grafo);
		assertEquals(0, agm.size());
	}
	
	@Test
	public void testGrafoParcialmenteDesconectada() {
	    Grafo grafo = new Grafo(5);
	    grafo.agregarArista(0, 1, 10.0);
	    grafo.agregarArista(1, 2, 10.0);
	    
	    grafo.agregarArista(3, 4, 10.0);
	    List<Arista> agm = ArbolGeneradorMinimoPrim.calcularAGM(grafo);
	    assertEquals(2, agm.size());
	}
	
	

}
