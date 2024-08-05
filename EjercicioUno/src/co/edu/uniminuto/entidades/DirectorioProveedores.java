
package co.edu.uniminuto.entidades;

import java.util.HashMap;
import java.util.Map;

public class DirectorioProveedores {
    private Map<Integer, Proveedor> proveedor = new HashMap<>();

    public DirectorioProveedores() {
    }

    public Map<Integer, Proveedor> getProveedor() {
        return proveedor;
    }

    public void setProveedor(Map<Integer, Proveedor> proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DirectorioProveedores{");
        sb.append("proveedor=").append(proveedor);
        sb.append('}');
        return sb.toString();
    }
    
    
}
