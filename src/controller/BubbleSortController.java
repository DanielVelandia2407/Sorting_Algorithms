package controller;

import model.estructuras.*;
import view.VentanaBubbleSort;

import java.util.Random;

public class BubbleSortController {

    private final VentanaBubbleSort ventana;

    public BubbleSortController(VentanaBubbleSort ventana) {
        this.ventana = ventana;
    }

    public void ejecutar(int n) {
        Lista<Integer>[] listas = new Lista[] {
            new ListaSimple<>(),
            new ListaDoble<>(),
            new ListaCircularSimple<>(),
            new ListaCircularDoble<>()
        };
        String[] tipos = {"Simple", "Doble", "Circular Simple", "Circular Doble"};

        Random random = new Random();
        for (Lista<Integer> lista : listas) {
            for (int i = 0; i < n; i++) {
                lista.add(random.nextInt(1000)); // Random integers between 0 and 999
            }
        }

        for (int i = 0; i < listas.length; i++) {
            Lista<Integer> lista = listas[i];
            long startTime = System.currentTimeMillis();
            int[] metrics = bubbleSort(lista);
            long endTime = System.currentTimeMillis();

            ventana.mostrarResultados(tipos[i] + ": tiempo=" + (endTime - startTime) + "ms  comps=" + metrics[0] + " swaps=" + metrics[1]);
        }
    }

    private <T extends Comparable<T>> int[] bubbleSort(Lista<T> list) {
        int swaps = 0;
        int comparisons = 0;
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                comparisons++;
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swaps++;
                }
            }
        }
        return new int[] {comparisons, swaps};
    }
}
