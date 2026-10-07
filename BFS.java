package logica;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BFS 
{
	private static List<Integer> listaVisitados;
	private static boolean[] visitados;
	
	public static boolean esConexo(Grafo grafo) 
	{
		if (grafo == null)
			throw new IllegalArgumentException("El grafo no puede ser null.");
		
		return grafo.tamano() == 0 || alcanzables(grafo, 0).size() == grafo.tamano();
	}

	public static Set<Integer> alcanzables(Grafo grafo, int verticeOrigen) 
	{
		Set<Integer> resultado = new HashSet<Integer>();
		inicializarRecorrido(grafo, verticeOrigen);
		
		while (!listaVisitados.isEmpty()) 
		{
			int i = listaVisitados.get(0);
			visitados[i] = true;
			
			resultado.add(i);
			agregarVecinosPendientes(grafo, i);
			listaVisitados.remove(0);
		}
		return resultado;
	}

	private static void agregarVecinosPendientes(Grafo g, int vertice) 
	{		
		for (int vecino : g.vecinos(vertice))
			if (!visitados[vecino] && !listaVisitados.contains(vecino))
				listaVisitados.add(vecino);
	}
	
	private static void inicializarRecorrido(Grafo g, int verticeOrigen) 
	{
		listaVisitados = new LinkedList<Integer>();
		visitados = new boolean[g.tamano()];
		listaVisitados.add(verticeOrigen);
	}
}