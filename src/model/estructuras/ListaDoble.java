package model.estructuras;

public class ListaDoble<T> implements Lista<T> {
    private class Nodo {
        T dato;
        Nodo siguiente;
        Nodo anterior;
        Nodo(T dato) { this.dato = dato; }
    }

    private Nodo cabeza;
    private Nodo cola;
    private int tama;

    public ListaDoble() {
        cabeza = cola = null;
        tama = 0;
    }

    @Override
    public void add(T dato) {
        Nodo nuevo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
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
        Nodo temp;
        if (indice < tama / 2) {
            temp = cabeza;
            for (int i = 0; i < indice; i++) temp = temp.siguiente;
        } else {
            temp = cola;
            for (int i = tama - 1; i > indice; i--) temp = temp.anterior;
        }
        return temp.dato;
    }

    @Override
    public void set(int indice, T dato) {
        if (indice < 0 || indice >= tama) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
        }
        Nodo temp;
        if (indice < tama / 2) {
            temp = cabeza;
            for (int i = 0; i < indice; i++) temp = temp.siguiente;
        } else {
            temp = cola;
            for (int i = tama - 1; i > indice; i--) temp = temp.anterior;
        }
        temp.dato = dato;
    }

    @Override
    public void clear() {
        cabeza = cola = null;
        tama = 0;
    }
}
