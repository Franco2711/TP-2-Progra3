package logica;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BFS 
{
	private static List<Integer> lista;
	private static boolean[] marcados;
	
	public static boolean esConexo(Grafo grafo) 
	{
		if (grafo == null)
			throw new IllegalArgumentException("El grafo no puede ser null.");
		
		return grafo.tamano() == 0 || alcanzables(grafo, 0).size() == grafo.tamano();
	}

	public static Set<Integer> alcanzables(Grafo g, int origen) 
	{
		Set<Integer> ret = new HashSet<Integer>();
		inicializarRecorrido(g, origen);
		
		while (!lista.isEmpty()) 
		{
			int i = lista.get(0);
			marcados[i] = true;
			
			ret.add(i);
			agregarVecinosPendientes(g, i);
			lista.remove(0);
		}
		return ret;
	}

	private static void agregarVecinosPendientes(Grafo g, int vertice) 
	{		
		for (int vecino : g.vecinos(vertice))
			if (!marcados[vecino] && !lista.contains(vecino))
				lista.add(vecino);
	}
	
	private static void inicializarRecorrido(Grafo g, int origen) 
	{
		lista = new LinkedList<Integer>();
		marcados = new boolean[g.tamano()];
		lista.add(origen);
	}
}