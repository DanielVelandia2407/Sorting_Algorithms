package controller;

import model.Politico;
import modelo.*;
import view.VentanaQS;

public class ControladorQS {
    private final VentanaQS vista;

    public ControladorQS(VentanaQS vista) {
        this.vista = vista;
    }

    public void ejecutar(int n) {
        Lista<Politico>[] listas = new Lista[] {
            new ListaSimple<>(),
            new ListaDoble<>(),
            new ListaCircularSimple<>(),
            new ListaCircularDoble<>()
        };
        String[] tipos = {"Simple", "Doble", "Circular Simple", "Circular Doble"};

        for (int i = 0; i < listas.length; i++) {
            // Generar datos aleatorios
            for (int j = 0; j < n; j++) {
                listas[i].add(Politico.aleatorio());
            }
            // Ordenar y medir métricas
            QuickSort.Metricas m = new QuickSort.Metricas();
            QuickSort.sort(listas[i], m);
            vista.mostrarResultados(
                tipos[i] + ": tiempo=" + m.tiempoMillis + "ms  comps=" + m.comparaciones +
                "  swaps=" + m.swaps
            );
        }
    }
}
