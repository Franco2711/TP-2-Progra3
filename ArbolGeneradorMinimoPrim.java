package logica;

import java.util.ArrayList;
import java.util.List;

public class ArbolGeneradorMinimoPrim {
	
	public static List<Arista> calcularAGM(Grafo g) {
		List<Arista> arbol = new ArrayList<>();
		boolean[] marcados = new boolean[g.tamano()];
		
		marcados[0] = true; //comienza por el vertice 0
		for (int arista = 0; arista < g.tamano() - 1; arista++) {
			
			double minPeso = Double.MAX_VALUE;
			int verticeOrigen = -1;
			int verticeDestino = -1;

			for (int i = 0; i < g.tamano(); i++) {
				if (marcados[i] == true) {
					
					for (int j = 0; j < g.tamano(); j++) {
						if (!marcados[j] && g.existeArista(i, j)) { //si el vertice J cuenta con una arista con I, comparar si es el menor peso
							double pesoActual = g.pesoArista(i, j);
							if (pesoActual < minPeso) {
								minPeso = pesoActual;
								verticeOrigen = i;
								verticeDestino = j;
							}
						}
					}
				}
			}
			if (verticeOrigen != -1 && verticeDestino != -1) {
				arbol.add(new Arista(verticeOrigen, verticeDestino, minPeso)); //almacenamos la arista de menor peso encontrado para I
				marcados[verticeDestino] = true; //marcamos el nuevo vertice encontrado
			}
		}
		return arbol; //retornamos el arbol generador minimo de G
	}
}
