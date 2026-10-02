package tp2Progra3;

public class Arista {

	private int nodo1;
	private int nodo2;
	private int peso;
	
	public Arista(int dato1, int dato2, int peso) {
		this.nodo1 = dato1;
		this.nodo2 = dato2;
		this.peso = peso;
	}
	
//	public Nodo[] consultarDatos() {
//		return nodos;
//	}
	
	public int consultarPeso() {
		return peso;
	}
	
}
