package model;

import model.estructuras.*;
import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static class Metricas {
        public long comparaciones = 0;
        public long swaps = 0;
        public long tiempoMillis = 0;
    }

    public static <T extends Comparable<T>> void sort(Lista<T> lista, Metricas m) {
        int n = lista.size();
        // Copiamos a un ArrayList para facilitar el merge
        List<T> aux = new ArrayList<>(n);
        for (int i = 0; i < n; i++) aux.add(lista.get(i));

        long t0 = System.currentTimeMillis();
        mergeSort(aux, 0, n - 1, m);
        m.tiempoMillis = System.currentTimeMillis() - t0;

        // Volvemos a la lista original
        lista.clear();
        aux.forEach(lista::add);
    }

    private static <T extends Comparable<T>> void mergeSort(List<T> a, int izq, int der, Metricas m) {
        if (izq >= der) return;
        int mid = (izq + der) / 2;
        mergeSort(a, izq, mid, m);
        mergeSort(a, mid + 1, der, m);
        merge(a, izq, mid, der, m);
    }

    private static <T extends Comparable<T>> void merge(List<T> a, int izq, int mid, int der, Metricas m) {
        List<T> temp = new ArrayList<>();
        int i = izq, j = mid + 1;
        while (i <= mid && j <= der) {
            m.comparaciones++;
            if (a.get(i).compareTo(a.get(j)) <= 0) {
                temp.add(a.get(i++));
            } else {
                temp.add(a.get(j++));
                m.swaps++;
            }
        }
        while (i <= mid) temp.add(a.get(i++));
        while (j <= der) temp.add(a.get(j++));
        for (int k = 0; k < temp.size(); k++) {
            a.set(izq + k, temp.get(k));
            m.swaps++;
        }
    }
}
