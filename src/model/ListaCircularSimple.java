package modelo.estructuras;

public class ListaCircularSimple<T> implements Lista<T> {
    private class Nodo {
        T dato;
        Nodo siguiente;
        Nodo(T dato) { this.dato = dato; }
    }

    private Nodo cabeza;
    private int tama;

    public ListaCircularSimple() {
        cabeza = null;
        tama = 0;
    }

    @Override
    public void add(T dato) {
        Nodo nuevo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            nuevo.siguiente = cabeza;
        } else {
            Nodo temp = cabeza;
            while (temp.siguiente != cabeza) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevo;
            nuevo.siguiente = cabeza;
        }
        tama++;
    }

    @Override
    public int size() {
        return tama;
    }

    @Override
    public T get(int indice) {
        if (indice < 0 || indice >= tama) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
        }
        Nodo temp = cabeza;
        for (int i = 0; i < indice; i++) temp = temp.siguiente;
        return temp.dato;
    }

    @Override
    public void set(int indice, T dato) {
        if (indice < 0 || indice >= tama) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
        }
        Nodo temp = cabeza;
        for (int i = 0; i < indice; i++) temp = temp.siguiente;
        temp.dato = dato;
    }

    @Override
    public void clear() {
        cabeza = null;
        tama = 0;
    }
}
