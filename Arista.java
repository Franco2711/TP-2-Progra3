package logica;

public class Arista implements Comparable<Arista> {
	
	private int vertice1;
	private int vertice2;
	private double peso;

	public Arista(int vertice1, int vertice2, double peso) {
		this.vertice1 = vertice1;
		this.vertice2 = vertice2;
		this.peso = peso;
	}

	public int getVertice1() { 
		return vertice1; 
	}
	
	public int getVertice2() { 
		return vertice2; 
	}
	
	public double getPeso() { 
		return peso; 
	}

	@Override
	public int compareTo(Arista otra) { //comparamos el peso de 2 aristas
		return Double.compare(this.peso, otra.peso);
	}
}
