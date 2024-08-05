
package ejerciciodos;

import co.edu.uniminuto.entidades.Nodo;
import co.edu.uniminuto.entidades.Resultado;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;


public class EjercicioDos {

    /**
     * Tomando como base el sistema de Transmilenio, realicen lo siguiente: 
     * a. Creen un grafo que represente la siguiente imagen: Fuente: elaboración 
     * propia El usuario debe establecer en el sistema los tiempos de cada arista 
     * del grafo. b. Encuentren la mejor ruta para ir de la calle 72 a la Av. Boyacá, 
     * de acuerdo con los tiempos establecidos para cada arista. Muestren como 
     * resultado los nombres de las estaciones y el tiempo total de la ruta. 
     * Ejemplo: Calle72 – Heroes – Av. Boyacá con un tiempo de 20 minutos.
     */
    public static void main(String[] args) {
        // Crear el grafo
        List<String> estaciones = Arrays.asList("Calle 72", "Calle 76", "Heroes", "Escuela Militar");
        Map<String, Map<String, Integer>> grafo = new HashMap<>();
        estaciones.forEach(estacion ->{
                                    grafo.put(estacion, new HashMap<>());
                                       });

        grafo.get("Calle 72").put("Calle 76", 2);
        grafo.get("Calle 72").put("Heroes", 3);
        grafo.get("Calle 76").put("Escuela Militar", 4);
        grafo.get("Heroes").put("Escuela Militar", 2);
        grafo.get("Heroes").put("Av. Boyacá", 5);
        grafo.get("Escuela Militar").put("Av. Boyacá", 4);

        // Encontrar la mejor ruta de Calle 72 a Av. Boyacá
        Resultado resultado = calcularMejorRuta(grafo, "Calle 72", "Av. Boyacá");

        System.out.println("La mejor ruta es: " + String.join(" -> ", resultado.getRuta()) + " con un tiempo de " + resultado.getTiempo() + " minutos.");
    }

    // Método para encontrar la mejor ruta utilizando el algoritmo de Dijkstra
    public static Resultado calcularMejorRuta(Map<String, Map<String, Integer>> grafo, String inicio, String fin) {
        // Cola de prioridad para almacenar los nodos a visitar, ordenados por costo
        PriorityQueue<Nodo> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(nodo -> nodo.getCosto()));
        // Añadir el nodo inicial a la cola de prioridad con costo 0
        colaPrioridad.add(new Nodo(inicio, 0, new ArrayList<>()));
        // Conjunto para almacenar los nodos visitados
        Set<String> visitados = new HashSet<>();

        // Mientras haya nodos en la cola de prioridad
        while (!colaPrioridad.isEmpty()) {
            // Obtener el nodo con el menor costo
            Nodo actual = colaPrioridad.poll();
            // Si el nodo ya ha sido visitado, continuar con el siguiente
            if (visitados.contains(actual.getNodo())) {
                continue;
            }
            // Marcar el nodo como visitado
            visitados.add(actual.getNodo());
            // Añadir el nodo actual al camino
            actual.getCamino().add(actual.getNodo());

            // Si hemos llegado al nodo destino, devolver el resultado
            if (actual.getNodo().equals(fin)) {
                return new Resultado(actual.getCosto(), actual.getCamino());
            }

            // Explorar los vecinos del nodo actual
            for (Map.Entry<String, Integer> vecino : grafo.get(actual.getNodo()).entrySet()) {
                // Si el vecino no ha sido visitado
                if (!visitados.contains(vecino.getKey())) {
                    // Crear una nueva lista de camino basada en el camino actual
                    List<String> nuevoCamino = new ArrayList<>(actual.getCamino());
                    // Añadir el vecino a la cola de prioridad con el costo acumulado
                    colaPrioridad.add(new Nodo(vecino.getKey(), actual.getCosto() + vecino.getValue(), nuevoCamino));
                }
            }
        }

        // Si no se encuentra un camino, devolver un resultado con costo infinito y un camino vacío
        return new Resultado(Integer.MAX_VALUE, new ArrayList<>());
    }
}

