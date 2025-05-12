package controller;

import model.*;
import model.estructuras.*;
import view.VentanaMerge;
import view.MainView;

public class MergeController {
    private final VentanaMerge vista;
    private MainView mainView;

    public MergeController(VentanaMerge vista) {
        this.vista = vista;
    }


    public void setMainView(MainView mainView) {
        this.mainView = mainView;
    }

    public void ejecutar(int n) {
        // 1) Generar lista de políticos aleatorios
        Lista<Politico>[] listas = new Lista[] {
                new ListaSimple<>(),
                new ListaDoble<>(),
                new ListaCircularSimple<>(),
                new ListaCircularDoble<>()
        };
        String[] tipos = {"Simple", "Doble", "Circular Simple", "Circular Doble"};

        for (int i = 0; i < listas.length; i++) {
            // Llenar
            for (int j = 0; j < n; j++) {
                listas[i].add(Politico.aleatorio());
            }
            // Medir y ordenar
            MergeSort.Metricas m = new MergeSort.Metricas();
            MergeSort.sort(listas[i], m);
            vista.mostrarResultados(
                    tipos[i] + ": tiempo=" + m.tiempoMillis + "ms  comps=" + m.comparaciones +
                            " swaps=" + m.swaps
            );
        }
    }

    public void volverAlMenu() {
        vista.dispose();
        if (mainView != null) {
            mainView.setVisible(true);
        }
    }
}