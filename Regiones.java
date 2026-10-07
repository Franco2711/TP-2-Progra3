package logica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Regiones {
	    
	    public static List<List<Integer>> formarRegiones(Grafo mapa, int k) {
	        
	    	if (k <= 0 || k > mapa.tamano()) {
	    		throw new IllegalArgumentException("Debe ingresar un valor entre 1 y la cantidad de provincias seleccionadas");
	    	}
	    	
	        List<Arista> agm = ArbolGeneradorMinimoPrim.calcularAGM(mapa);
	        Collections.sort(agm); //ordeno de menor a mayor las aristas por peso
	        
	        int aristasAEliminar = k - 1;
	        for (int i = 0; i < aristasAEliminar; i++) {
	            agm.remove(agm.size() - 1);
	        }
	        
	        //reconstruir el mapa
	        Grafo grafoRegiones = new Grafo(mapa.tamano());
	        for (Arista arista : agm) {
	            grafoRegiones.agregarArista(arista.getVertice1(), arista.getVertice2(), arista.getPeso());
	        }
	        
	        //dividir en regiones
	        List<List<Integer>> regiones = new ArrayList<>();
	        boolean[] visitados = new boolean[mapa.tamano()];
	        
	        for (int i = 0; i < mapa.tamano(); i++) {
	            if (!visitados[i]) {
	              
	            	List<Integer> nuevaRegion = new ArrayList<>(BFS.alcanzables(grafoRegiones, i));
	                regiones.add(nuevaRegion);
	                
	                for (int provincia : nuevaRegion) {
	                    visitados[provincia] = true;
	                }
	            }
	        }
	        
	        return regiones;
	    }
}
