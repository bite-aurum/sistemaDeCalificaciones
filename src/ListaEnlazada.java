
public class ListaEnlazada {

    private Nodo cabeza;
    private int tamanio;

    public ListaEnlazada() {
        cabeza = null;
        tamanio = 0;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void insertarOrdenado(int valor) {

        if (tamanio >= 300 || valor < 0 || valor > 100) {
            System.out.println("Calificacion invalida o limite alcanzado.");
            return;
        }

        Nodo nuevo = new Nodo(valor);

        if (cabeza == null) {
            cabeza = nuevo;
        } else if (valor < cabeza.dato) {
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;

            while (actual.siguiente != null &&
                    actual.siguiente.dato <= valor) {
                actual = actual.siguiente;
            }

            nuevo.siguiente = actual.siguiente;
            actual.siguiente = nuevo;
        }

        tamanio++;
        System.out.println("Calificacion agregada.");
    }

    public void mostrar() {

        if (estaVacia()) {
            System.out.println("Lista vacia.");
            return;
        }

        Nodo actual = cabeza;

        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }

        System.out.println("null");
    }

    public boolean buscar(int valor) {

        Nodo actual = cabeza;

        while (actual != null) {

            if (actual.dato == valor) {
                return true;
            }

            actual = actual.siguiente;
        }

        return false;
    }

    public boolean eliminar(int valor) {

        if (estaVacia()) {
            return false;
        }

        if (cabeza.dato == valor) {
            cabeza = cabeza.siguiente;
            tamanio--;
            return true;
        }

        Nodo anterior = cabeza;
        Nodo actual = cabeza.siguiente;

        while (actual != null) {

            if (actual.dato == valor) {
                anterior.siguiente = actual.siguiente;
                tamanio--;
                return true;
            }

            anterior = actual;
            actual = actual.siguiente;
        }

        return false;
    }

    public int consultarPosicion(int posicion) {

        if (posicion < 1 || posicion > tamanio) {
            return -1;
        }

        Nodo actual = cabeza;

        for (int i = 1; i < posicion; i++) {
            actual = actual.siguiente;
        }

        return actual.dato;
    }

    public boolean corregir(int posicion, int nuevaCalificacion) {

        if (posicion < 1 || posicion > tamanio ||
                nuevaCalificacion < 0 || nuevaCalificacion > 100) {
            return false;
        }

        Nodo actual = cabeza;
        Nodo anterior = null;

        for (int i = 1; i < posicion; i++) {
            anterior = actual;
            actual = actual.siguiente;
        }

        if (anterior == null) {
            cabeza = actual.siguiente;
        } else {
            anterior.siguiente = actual.siguiente;
        }

        tamanio--;

        insertarOrdenado(nuevaCalificacion);

        return true;
    }
}
