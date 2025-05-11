package model;

import model.estructuras.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de QuickSort con métricas de comparaciones, swaps y tiempo.
 */
public class QuickSort {
    public static class Metricas {
        public long comparaciones = 0;
        public long swaps = 0;
        public long tiempoMillis = 0;
    }

    /**
     * Ordena la lista usando QuickSort y mide comparaciones, swaps y tiempo.
     */
    public static <T extends Comparable<T>> void sort(Lista<T> lista, Metricas m) {
        int n = lista.size();
        List<T> aux = new ArrayList<>(n);
        for (int i = 0; i < n; i++) aux.add(lista.get(i));

        long t0 = System.currentTimeMillis();
        quickSort(aux, 0, n - 1, m);
        m.tiempoMillis = System.currentTimeMillis() - t0;

        lista.clear();
        for (T item : aux) lista.add(item);
    }

    private static <T extends Comparable<T>> void quickSort(List<T> a, int low, int high, Metricas m) {
        if (low < high) {
            int pivotIndex = partition(a, low, high, m);
            quickSort(a, low, pivotIndex - 1, m);
            quickSort(a, pivotIndex + 1, high, m);
        }
    }

    private static <T extends Comparable<T>> int partition(List<T> a, int low, int high, Metricas m) {
        T pivot = a.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            m.comparaciones++;
            if (a.get(j).compareTo(pivot) <= 0) {
                i++;
                swap(a, i, j, m);
            }
        }
        swap(a, i + 1, high, m);
        return i + 1;
    }

    private static <T> void swap(List<T> a, int i, int j, Metricas m) {
        T temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
        m.swaps++;
    }
}

