package logica;

import java.util.HashSet;
import java.util.Set;

public class Grafo {
	
	private Double[][] matrizAdyacencia;
	
	public Grafo(int vertices) {
		
		matrizAdyacencia = new Double[vertices][vertices];
		
	}
	
	public void agregarArista(int i, int j, double peso) {
		verificarVertice(i);
		verificarVertice(j);
		verificarBucles(i, j);
		matrizAdyacencia[i][j] = peso;
		matrizAdyacencia[j][i] = peso;
	}
	
	public void eliminarArista(int i, int j) {
		verificarVertice(i);
		verificarVertice(j);
		verificarBucles(i, j);
		matrizAdyacencia[i][j] = null;
		matrizAdyacencia[j][i] = null;
	}

	public boolean existeArista(int i, int j) {
		verificarVertice(i);
		verificarVertice(j);
		verificarBucles(i, j);
		if(matrizAdyacencia[i][j] != null) {
			return true;
		}
		else return false;
	}
	
	public double pesoArista(int i, int j) {
		if(!existeArista(i, j)) {
			throw new IllegalArgumentException("No existe una arista entre estos vertices");
		}
		else {
			return matrizAdyacencia[i][j];
		}
	}
	
	public int tamano()
	{
		return matrizAdyacencia.length;
	}
	
	
	public Set<Integer> vecinos(int i){
		verificarVertice(i);
		Set<Integer> vec = new HashSet<Integer>();
		for(int j=0; j<matrizAdyacencia.length; j++) {
			if(i != j) {
				if(existeArista(i, j) == true) {
					vec.add(j);
				}
			}
		}
		return vec;
	}
	
	public int grado(int i)
	{
		verificarVertice(i);
		return vecinos(i).size();
	}

	
	
	private void verificarVertice(int i) {
		if(i < 0 || i>= matrizAdyacencia.length) {
			throw new IllegalArgumentException("El vertice no puede ser negativo");
		}
	}
	
	
	private void verificarBucles(int i, int j) {
		if(i == j) {
			throw new IllegalArgumentException("No se permiten bucles");
		}
	}
}
