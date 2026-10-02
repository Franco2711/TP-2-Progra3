package tp2Progra3;

import java.util.ArrayList;
import java.util.LinkedList;

public class Grafo {
	
	private boolean[][] matrizDeAdyacencia;
	
	Grafo(){
		matrizDeAdyacencia = new boolean[23][23];
	}
	
	public void agregarArista(int i, int j) {
		matrizDeAdyacencia[i][j] = true;
		matrizDeAdyacencia[j][i] = true;
	}
	
	public boolean existeArista(int i, int j) {
		return matrizDeAdyacencia[i][j];
	}
	
	public void imprimirGrafo() {
		for(int f = 0; f < matrizDeAdyacencia.length; f++) {
			System.out.print("[ ");
			for (int c = 0; c < matrizDeAdyacencia[0].length; c++) {
				if(matrizDeAdyacencia[f][c] == true) {
					System.out.print("1 ");
				}else {
					System.out.print("0 ");
				}
			}System.out.println("]");
		}System.out.println();
			
	}
	
}
