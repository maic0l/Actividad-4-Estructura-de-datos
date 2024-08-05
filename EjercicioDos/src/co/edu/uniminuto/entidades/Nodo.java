
package co.edu.uniminuto.entidades;

import java.util.List;

public class Nodo {
    private String nodo;
    private int costo;
    private List<String> camino;

    public Nodo(String nodo, int costo, List<String> camino) {
        this.nodo = nodo;
        this.costo = costo;
        this.camino = camino;
    }

    public List<String> getCamino() {
        return camino;
    }

    public void setCamino(List<String> camino) {
        this.camino = camino;
    }

    public String getNodo() {
        return nodo;
    }

    public void setNodo(String nodo) {
        this.nodo = nodo;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
            
}
