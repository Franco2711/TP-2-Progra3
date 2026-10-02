package tp2Progra3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Random;

public class Main {
	
	static Nodo[] nodos = new Nodo[23];
	static LinkedList<Arista> aristas = new LinkedList<>();
	static String[] vBuenosAires = {"Entre Ríos", "Santa Fe", "Córdoba", "La Pampa", "Río Negro"};
	static String[] vCatamarca = {"Salta", "Tucumán", "Santiago del Estero", "Córdoba", "La Rioja"};
	static String[] vChaco = {"Formosa", "Corrientes", "Santa Fe", "Santiago del Estero", "Salta"};
	static String[] vChubut = {"Río Negro", "Santa Cruz"};
	static String[] vCórdoba = {"Santiago del Estero", "Santa Fe", "Buenos Aires", "La Pampa", "San Luis", "La Rioja", "Catamarca"};
	static String[] vCorrientes = {"Misiones", "Chaco", "Santa Fe", "Entre Ríos"};
	static String[] vEntreRíos = {"Corrientes", "Santa Fe", "Buenos Aires"};
	static String[] vFormosa = {"Salta", "Chaco"};
	static String[] vJujuy = {"Salta"};
	static String[] vLaPampa = {"Mendoza", "San Luis", "Córdoba", "Buenos Aires", "Río Negro", "Neuquén"};
	static String[] vLaRioja = {"Catamarca", "Córdoba", "San Luis", "San Juan"};
	static String[] vMendoza = {"San Juan", "San Luis", "La Pampa", "Neuquén"};
	static String[] vMisiones = {"Corrientes"};
	static String[] vNeuquén = {"Mendoza", "La Pampa", "Río Negro"};
	static String[] vRíoNegro = {"Neuquén", "La Pampa", "Buenos Aires", "Chubut"};
	static String[] vSalta = {"Jujuy", "Formosa", "Chaco", "Santiago del Estero", "Tucumán", "Catamarca"};
	static String[] vSanJuan = {"La Rioja", "San Luis", "Mendoza"};
	static String[] vSanLuis = {"San Juan", "La Rioja", "Córdoba", "La Pampa", "Mendoza"};
	static String[] vSantaCruz = {"Chubut"};
	static String[] vSantaFe = {"Chaco", "Corrientes", "Entre Ríos", "Buenos Aires", "Córdoba", "Santiago del Estero"};
	static String[] vSantiagoDelEstero = {"Salta", "Chaco", "Santa Fe", "Córdoba", "Catamarca", "Tucumán"};
	static String[] vTierraDelFuego = {"Santa Cruz"};
	static String[] vTucumán = {"Salta", "Catamarca", "Santiago del Estero"};
	
	public static void crearNodos(String[] provincias) {
		for(int i = 0; i < provincias.length; i++) {
			Nodo n = new Nodo(provincias[i]);
			nodos[i] = n;
		}
	}
	
	public static Nodo buscarNodo(Nodo[] nodos, String provincia) {
		for(int i = 0; i < nodos.length; i++) {
			if(nodos[i].getInfo().equals(provincia)) {
				return nodos[i];
			}
		}return null;
	}
	
	public static int buscarNodoPosicion(Nodo[] nodos, String provincia) {
		int pos = -1;
		for(int i = 0; i < nodos.length; i++) {
			if(nodos[i].getInfo().equals(provincia)) {
				pos = i;
				
			}
		}return pos;
	}
	
	public static void recorrerVecinos(Grafo grafo, Nodo[] nodos, ArrayList<String[]> lista) {
		Random rand = new Random();
		int p = rand.nextInt(9)+1;
		for(int i = 0; i < lista.size(); i++) {
			String[] v = lista.get(i);
			for(int j = 0; j < v.length; j++) {
				crearAristas(grafo, nodos, nodos[i].getInfo(), v[j], p);
			}
		}
	}
	
	public static void crearAristas(Grafo grafo, Nodo[] nodos, String provincia1, String provincia2, int peso) {
		int p1Pos = buscarNodoPosicion(nodos, provincia1);;
		int p2Pos = buscarNodoPosicion(nodos, provincia2);
		if(!grafo.existeArista(p1Pos, p2Pos)){
			grafo.agregarArista(p1Pos, p2Pos);
			Arista a = new Arista(p1Pos, p2Pos, peso);
			aristas.add(a);
		}
	}

	public static void main(String[] args) {
		
		String[] provincias = {"Buenos Aires", "Catamarca", "Chaco", "Chubut", 
				"Córdoba", "Corrientes", "Entre Ríos", "Formosa", "Jujuy", 
				"La Pampa", "La Rioja", "Mendoza", "Misiones", "Neuquén", 
				"Río Negro", "Salta", "San Juan", "San Luis", "Santa Cruz", 
				"Santa Fe", "Santiago del Estero", "Tierra del Fuego", "Tucumán"};
		
		ArrayList<String[]> listaV = new ArrayList<>();
		listaV.add(vBuenosAires);
		listaV.add(vCatamarca);
		listaV.add(vChaco);
		listaV.add(vChubut);
		listaV.add(vCórdoba);
		listaV.add(vCorrientes);
		listaV.add(vEntreRíos);
		listaV.add(vFormosa);
		listaV.add(vJujuy);
		listaV.add(vLaPampa);
		listaV.add(vLaRioja);
		listaV.add(vMendoza);
		listaV.add(vMisiones);
		listaV.add(vNeuquén);
		listaV.add(vRíoNegro);
		listaV.add(vSalta);
		listaV.add(vSanJuan);
		listaV.add(vSanLuis);
		listaV.add(vSantaCruz);
		listaV.add(vSantaFe);
		listaV.add(vSantiagoDelEstero);
		listaV.add(vTierraDelFuego);
		listaV.add(vTucumán);
		
		
		Grafo g = new Grafo();
		crearNodos(provincias);
		recorrerVecinos(g, nodos, listaV);
		g.imprimirGrafo();
		System.out.println(aristas.size());
		
	}

}
