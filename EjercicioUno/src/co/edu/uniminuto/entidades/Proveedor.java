
package co.edu.uniminuto.entidades;

import java.util.ArrayList;
import java.util.List;

public class Proveedor {
    
    private int nit;
    private String nombre;
    private String direccion;
    private String correo; 

    public Proveedor(int nit, String nombre, String direccion, String correo) {
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
    }

    public Proveedor() {
    }

    @Override
    public String toString() {
        return "Datos Proveedor( NIT: " + nit + ", Nombre: " + nombre + ", Direccion: " + direccion + ", Correo: " + correo + ")";
    }         
}
