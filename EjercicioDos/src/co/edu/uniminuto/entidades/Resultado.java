
package co.edu.uniminuto.entidades;

import java.util.List;

public class Resultado {
    
    private int tiempo;
    private List<String> ruta;

    public Resultado(int tiempo, List<String> ruta) {
        this.tiempo = tiempo;
        this.ruta = ruta;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public List<String> getRuta() {
        return ruta;
    }

    public void setRuta(List<String> ruta) {
        this.ruta = ruta;
    }
        
        
    }
