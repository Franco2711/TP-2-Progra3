package logica;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class RegionesTest {

	@Test
	public void testOrdenarPesosDeMenorAMayor() {
	    Grafo grafo = new Grafo(5);
	    grafo.agregarArista(0, 1, 10.0);
	    grafo.agregarArista(1, 2, 20.0);
	    grafo.agregarArista(2, 3, 40.0);
	    grafo.agregarArista(3, 4, 20.0);
	    
	    List<Arista> agm = ArbolGeneradorMinimoPrim.calcularAGM(grafo);
	    Collections.sort(agm);
	    double pesoAnterior = 0.0;
	    for (Arista aristaActual : agm) {
	        assertTrue(aristaActual.getPeso() >= pesoAnterior);
	        pesoAnterior = aristaActual.getPeso();
	    }
	}
	
	@Test
	public void testDividirEnUnaRegion() {
		Grafo grafo = new Grafo(5);
	    grafo.agregarArista(0, 1, 10.0);
	    grafo.agregarArista(1, 2, 20.0);
	    grafo.agregarArista(2, 3, 40.0);
    	grafo.agregarArista(3, 4, 20.0);
    	
    	List<List<Integer>> resultado = Regiones.formarRegiones(grafo, 1);
	    assertEquals(1, resultado.size());
	}
	
	@Test
	public void testDividirEnTresRegiones() {
		Grafo grafo = new Grafo(6);
	    grafo.agregarArista(0, 1, 10.0);
	    grafo.agregarArista(1, 2, 60.0);
	    grafo.agregarArista(2, 3, 40.0);
	    grafo.agregarArista(3, 4, 20.0);
	    grafo.agregarArista(3, 5, 50.0);
	    
	    List<List<Integer>> resultado = Regiones.formarRegiones(grafo, 3);
	    assertEquals(3, resultado.size());
	}
	
	@Test
	public void testDividirTodosLosVerticesEnRegiones() {
		Grafo grafo = new Grafo(4);
	    grafo.agregarArista(0, 1, 10.0);
	    grafo.agregarArista(1, 2, 20.0);
	    grafo.agregarArista(2, 3, 40.0);
	    
	    List<List<Integer>> resultado = Regiones.formarRegiones(grafo, 4);
	    assertEquals(4, resultado.size());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testKIgualACero() {
		Grafo grafo = new Grafo(4);
	    grafo.agregarArista(0, 1, 10.0);
	    List<List<Integer>> resultado = Regiones.formarRegiones(grafo, 0);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testKMayorQueVertices() {
		Grafo grafo = new Grafo(4);
	    grafo.agregarArista(0, 1, 10.0);
	    List<List<Integer>> resultado = Regiones.formarRegiones(grafo, 5);
	}
	
	@Test
	public void testGrafoDeUnSoloVerticeDevuelveUnaRegion() {
		Grafo grafo = new Grafo(1);
	    List<List<Integer>> resultado = Regiones.formarRegiones(grafo, 1);
	    assertEquals(1, resultado.size());
	}

}
