import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaEnlazada inventario = new ListaEnlazada();
        String rutaArchivo = "inventario.csv";
        GestorArchivo.cargarDesdeCSV(rutaArchivo, inventario);

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 6) {
            System.out.println("\n--- MENU DE GESTION DE INVENTARIO ---");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Ver Inventario");
            System.out.println("3. Buscar Producto por ID");
            System.out.println("4. Eliminar Producto por ID");
            System.out.println("5. Ordenar Inventario por Precio");
            System.out.println("6. Guardar y Salir");
            System.out.print("Seleccione una opcion: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } else {
                scanner.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese Precio: ");
                    double precio = scanner.nextDouble();
                    scanner.nextLine();

                    inventario.insertarFinal(new Producto(id, nombre, precio));
                    System.out.println("Producto agregado con exito.");
                    break;

                case 2:
                    System.out.println("\n--- LISTA DE PRODUCTOS ---");
                    inventario.mostrarLista();
                    break;

                case 3:
                    System.out.print("Ingrese el ID a buscar: ");
                    int idBuscar = scanner.nextInt();
                    scanner.nextLine();
                    Producto encontrado = inventario.buscarPorId(idBuscar);
                    if (encontrado != null) {
                        System.out.println("Encontrado: " + encontrado);
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el ID a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    scanner.nextLine();
                    if (inventario.eliminarPorId(idEliminar)) {
                        System.out.println("Producto eliminado correctamente.");
                    } else {
                        System.out.println("No se encontro un producto con ese ID.");
                    }
                    break;

                case 5:
                    inventario.ordenarPorPrecio();
                    System.out.println("Inventario ordenado por precio mediante intercambio de punteros.");
                    inventario.mostrarLista();
                    break;

                case 6:
                    GestorArchivo.guardarEnCSV(rutaArchivo, inventario);
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }
        }
        scanner.close();
    }
}