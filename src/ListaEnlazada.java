public class ListaEnlazada {
    private Nodo cabeza;

    public ListaEnlazada() {
        this.cabeza = null;
    }

    public Nodo getCabeza() {
        return cabeza;
    }

    public void insertarFinal(Producto producto) {
        Nodo nuevo = new Nodo(producto);
        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }
        Nodo actual = cabeza;
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        actual.setSiguiente(nuevo);
    }

    public boolean eliminarPorId(int id) {
        if (cabeza == null) {
            return false;
        }

        if (cabeza.getProducto().getId() == id) {
            cabeza = cabeza.getSiguiente();
            return true;
        }

        Nodo actual = cabeza;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getProducto().getId() == id) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    public Producto buscarPorId(int id) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.getProducto().getId() == id) {
                return actual.getProducto();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public void ordenarPorPrecio() {
        if (cabeza == null || cabeza.getSiguiente() == null) {
            return;
        }

        boolean huboCambio;
        do {
            huboCambio = false;
            Nodo previo = null;
            Nodo actual = cabeza;

            while (actual != null && actual.getSiguiente() != null) {
                Nodo siguiente = actual.getSiguiente();

                if (actual.getProducto().getPrecio() > siguiente.getProducto().getPrecio()) {
                    huboCambio = true;

                    if (previo == null) {
                        cabeza = siguiente;
                    } else {
                        previo.setSiguiente(siguiente);
                    }

                    actual.setSiguiente(siguiente.getSiguiente());
                    siguiente.setSiguiente(actual);

                    previo = siguiente;
                } else {
                    previo = actual;
                    actual = actual.getSiguiente();
                }
            }
        } while (huboCambio);
    }

    public void mostrarLista() {
        if (cabeza == null) {
            System.out.println("El inventario esta vacio.");
            return;
        }
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.println(actual.getProducto());
            actual = actual.getSiguiente();
        }
    }
}