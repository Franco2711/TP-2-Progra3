package tp2Progra3;

public class Arista {

	private int origen;
	private int destino;
	private int peso;
	
	public Arista(int dato1, int dato2, int peso) {
		this.origen = dato1;
		this.destino = dato2;
		this.peso = peso;
	}
	
	public int[] consultarDatos() {
		int[] aristas = {origen, destino};
		return aristas;
	}
	
	public int consultarPeso() {
		return peso;
	}
	
}
