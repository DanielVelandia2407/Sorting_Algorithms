package controller;

import view.VentanaQS;
import view.MainView;
import model.estructuras.*;
import java.util.Arrays;
import java.util.Random;


public class ControladorQS {
    private VentanaQS vista;
    private MainView mainView;

    public ControladorQS(VentanaQS vista) {
        this.vista = vista;
    }

    public void setMainView(MainView mainView) {
        this.mainView = mainView;
    }

    public void ejecutar(int n) {
        // Generar array aleatorio de tamaño n
        int[] array = generarArrayAleatorio(n);

        // Mostrar array original
        vista.mostrarResultados("Array original: " + Arrays.toString(array));

        // Medir tiempo de ejecución
        long inicio = System.nanoTime();

        // Ejecutar QuickSort
        quickSort(array, 0, array.length - 1);

        long fin = System.nanoTime();
        long tiempoEjecucion = fin - inicio;

        // Mostrar resultados
        vista.mostrarResultados("Tiempo de ejecución: " + tiempoEjecucion + " nanosegundos");
        vista.mostrarArrayOrdenado(Arrays.toString(array));
    }

    private int[] generarArrayAleatorio(int n) {
        int[] array = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(1000); // Números aleatorios entre 0 y 999
        }
        return array;
    }

    // Implementación de QuickSort
    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Método para volver al menú principal
    public void volverAlMenu() {
        vista.dispose();
        if (mainView != null) {
            mainView.setVisible(true);
        }
    }
}