package model.estructuras;

public interface Lista<T> {
    void add(T dato);
    int size();
    T get(int indice);
    void set(int indice, T dato);
    void clear();
}
