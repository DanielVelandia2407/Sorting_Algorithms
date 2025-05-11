package model.estructuras;


public class ListaSimple<T> implements Lista<T> {
    private class Nodo {
        T dato;
        Nodo siguiente;
        Nodo(T dato) { this.dato = dato; }
    }

    private Nodo cabeza;
    private int tama;

    public ListaSimple() {
        cabeza = null;
        tama = 0;
    }

    @Override
    public void add(T dato) {
        Nodo nuevo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevo;
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
        for (int i = 0; i < indice; i++) {
            temp = temp.siguiente;
        }
        return temp.dato;
    }

    @Override
    public void set(int indice, T dato) {
        if (indice < 0 || indice >= tama) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
        }
        Nodo temp = cabeza;
        for (int i = 0; i < indice; i++) {
            temp = temp.siguiente;
        }
        temp.dato = dato;
    }

    @Override
    public void clear() {
        cabeza = null;
        tama = 0;
    }
}
