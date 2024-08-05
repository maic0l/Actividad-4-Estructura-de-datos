
package ejerciciouno;

import co.edu.uniminuto.entidades.DirectorioProveedores;
import co.edu.uniminuto.entidades.Proveedor;
import javax.swing.JOptionPane;
/**
 *
 * @author michael
 */

public class EjercicioUno {
    
    /**
     * La empresa de Juan quiere contar con un sistema tipo directorio que le 
     * permitatener un listado de proveedores. Elabórenlo, teniendo en cuenta que:
     * a. Cada proveedor debe tener el NIT, el nombre del proveedor, la dirección y el correo electrónico. 
     * b. El listado de proveedores (diccionario) debe tener mínimo los métodos: 
     * i. Get(k), si el diccionario tiene una entrada con la clave K retorna el valor (proveedor), en caso contrario retorna null. 
     * ii. Put(k,v), inserta al diccionario la entrada (k,v), siendo k la clave y v el valor (datos del proveedor). 
     * iii. Remove(k), elimina del diccionario la entrada con clave k o retorna null en caso de no existir. 
     * iv. Size, retorna el tamaño del diccionario (número de proveedores). 
     * v. isEmpty, retorna si el diccionario está vacío (verdadero) o no (falso) 
     * vi. keys, retorna un arreglo o iterador con todas las claves k del diccionario.
     * vii. Values, retorna un arreglo o iterador con todos valore (proveedores) del diccionario.
     */
    
    public static void main(String[] args) {
        // Crear una instancia del directorio de proveedores
        var directorioProveedores = new DirectorioProveedores();
        var salir = false;

        // Bucle para mostrar el menú y manejar las opciones hasta que el usuario decida salir
        while (!salir) {
            try {
                salir = mostrarMenu(salir, directorioProveedores);
            } catch (Exception e) {
                // Captura y muestra errores que puedan ocurrir durante la ejecución
                System.out.println("Ha ocurrido un error: " + e.getMessage());
            }
        }
    }

    private static boolean mostrarMenu(boolean salir, DirectorioProveedores directorioProveedores) {
        // Variables para almacenar la información del proveedor
        StringBuilder sb = new StringBuilder();
        int nit;
        String nombre;
        String direccion;
        String correo;
        var resultadoDeProveedor = new Proveedor();
        boolean resultado;

        // Mostrar el menú y obtener la opción seleccionada por el usuario
        var opcion = Short.parseShort(JOptionPane.showInputDialog("""
            1. Consultar Proveedor(Get)
            2. Añadir Proveedor (Input)
            3. Remover Proveedor (Remove)
            4. Número de Proveedores (Size)
            5. Verificar Estado (IsEmpty)
            6. Clave De Los Proveedores(Keys)
            7. Proveedores (Values)
            0. Salir
            """));

        // Manejar las acciones según la opción seleccionada
        switch (opcion) {
            case 1 -> {
                // Consultar proveedor por NIT
                resultado = directorioProveedores.getProveedor().isEmpty();
                if (!resultado) {
                    nit = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el NIT (Clave): "));
                    resultadoDeProveedor = directorioProveedores.getProveedor().get(nit);
                    if (resultadoDeProveedor != null)
                        mostrarMensaje("Proveedor Encontrado: " + resultadoDeProveedor);
                    else
                        mostrarMensaje("No se ha encontrado un resultado: " + resultadoDeProveedor);
                } else
                    mostrarMensaje("Lista Vacía, Por favor añada Proveedores");
            }
            case 2 -> {
                // Añadir nuevo proveedor
                nit = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el NIT: "));
                nombre = JOptionPane.showInputDialog("Ingrese el Nombre del Proveedor");
                direccion = JOptionPane.showInputDialog("Ingrese la dirección del Proveedor");
                correo = JOptionPane.showInputDialog("Ingrese el correo del Proveedor");

                Proveedor proveedor = new Proveedor(nit, nombre, direccion, correo);
                directorioProveedores.getProveedor().put(nit, proveedor);

                // Mostrar todos los proveedores actuales
                directorioProveedores.getProveedor().forEach((llave, valor) -> {
                    sb.append("Llave: ").append(llave).append(", Valor: ").append(valor).append("\n");
                });
                mostrarMensaje("Actualización: " + "\n" + sb.toString());
            }
            case 3 -> {
                // Remover proveedor por NIT
                resultado = directorioProveedores.getProveedor().isEmpty();
                if (!resultado) {
                    nit = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el NIT (Clave): "));
                    resultadoDeProveedor = directorioProveedores.getProveedor().get(nit);
                    if (resultadoDeProveedor != null) {
                        mostrarMensaje("Proveedor Removido: " + directorioProveedores.getProveedor().get(nit));
                        directorioProveedores.getProveedor().remove(nit);
                    } else
                        mostrarMensaje("No se ha encontrado un resultado: " + resultadoDeProveedor);
                } else
                    mostrarMensaje("Lista Vacía, Por favor añada Proveedores");
            }
            case 4 -> mostrarMensaje("Número de Proveedores: " + directorioProveedores.getProveedor().size());
            case 5 -> {
                // Verificar si el directorio de proveedores está vacío
                resultado = directorioProveedores.getProveedor().isEmpty();
                if (resultado)
                    mostrarMensaje("Lista Vacía");
                else
                    mostrarMensaje("Lista con Objetos");
            }
            case 6 -> {
                // Mostrar todas las claves de los proveedores
                resultado = directorioProveedores.getProveedor().isEmpty();
                if (!resultado) {
                    directorioProveedores.getProveedor().forEach((llave, valor) -> {
                        sb.append("Llave: ").append(llave).append("\n");
                    });
                    mostrarMensaje(sb.toString());
                } else
                    mostrarMensaje("Lista Vacía, Por favor añada Proveedores");
            }
            case 7 -> {
                // Mostrar todos los valores (proveedores)
                resultado = directorioProveedores.getProveedor().isEmpty();
                if (!resultado) {
                    directorioProveedores.getProveedor().forEach((llave, valor) -> {
                        sb.append("Valor: ").append(valor).append("\n");
                    });
                    mostrarMensaje(sb.toString());
                } else
                    mostrarMensaje("Lista Vacía, Por favor añada Proveedores");
            }
            case 0 -> salir = true; // Salir del bucle
            default -> System.out.println("Opción no válida"); // Opción no reconocida
        }
        return salir; // Retornar el estado del bucle
    }

    //Muestra un mensaje en una ventana de diálogo.
     
    private static void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }
}