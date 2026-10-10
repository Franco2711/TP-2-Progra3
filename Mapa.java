package logica;

import java.util.ArrayList;
import java.util.List;

public class Mapa {

	public static List<List<String>> calcularRegiones(List<String> nombresProvincias, List<Arista> aristas, int regiones){
		
		Grafo mapa = new Grafo(nombresProvincias.size());
		for(Arista arista : aristas) {
			mapa.agregarArista(arista.getVertice1(), arista.getVertice2(), arista.getPeso());
		}
		
		List<List<Integer>> regionesDelMapa = Regiones.formarRegiones(mapa, regiones);
		
        List<List<String>> regionesTextuales = new ArrayList<>();
        
        for (List<Integer> grupo : regionesDelMapa) {
            List<String> grupoTextual = new ArrayList<>();
            for (int vertice : grupo) {
                grupoTextual.add(nombresProvincias.get(vertice));
            }
            regionesTextuales.add(grupoTextual);
        }
        
        return regionesTextuales;
	}
}
