import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GestorArchivo {

    public static void guardarEnCSV(String nombreArchivo, ListaEnlazada lista) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            Nodo actual = lista.getCabeza();
            while (actual != null) {
                Producto p = actual.getProducto();
                writer.write(p.getId() + "," + p.getNombre() + "," + p.getPrecio());
                writer.newLine();
                actual = actual.getSiguiente();
            }
            System.out.println("Inventario guardado exitosamente en " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    public static void cargarDesdeCSV(String nombreArchivo, ListaEnlazada lista) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    String[] datos = linea.split(",");
                    int id = Integer.parseInt(datos[0].trim());
                    String nombre = datos[1].trim();
                    double precio = Double.parseDouble(datos[2].trim());
                    lista.insertarFinal(new Producto(id, nombre, precio));
                }
            }
            System.out.println("Inventario cargado exitosamente desde " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("No se encontro un archivo previo. Se iniciará un inventario nuevo.");
        }
    }
}