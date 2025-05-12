package controller;

import view.MainView;
import view.InsertionMenu;
import view.SelectionMenu;
import view.VentanaQS;
import view.VentanaBubbleSort;
import view.VentanaMerge;

import javax.swing.JButton;
import java.awt.BorderLayout;

public class MainController {
    private MainView mainView;

    public MainController(MainView view) {
        this.mainView = view;

        // Listeners para Sorting
        this.mainView.addBubbleSortListener(e -> openBubbleSortView());
        this.mainView.addQuickSortListener(e -> openQuickSortView());
        this.mainView.addMergeSortListener(e -> openMergeSortView()); // Añadimos el listener para MergeSort
        this.mainView.addInsertionSortListener(e -> openInsertionView());
        this.mainView.addSelectionSortListener(e -> openSelectionView());
    }

    // Method to show BubbleSort view
    private void openBubbleSortView() {
        mainView.setVisible(false);
        VentanaBubbleSort bubbleSortMenu = new VentanaBubbleSort();
        BubbleSortController controller = new BubbleSortController(bubbleSortMenu);
        controller.setMainView(mainView);

        // Agregar botón para volver al menú principal
        JButton btnVolver = new JButton("Volver al Menú Principal");
        btnVolver.addActionListener(e -> controller.volverAlMenu());
        bubbleSortMenu.add(btnVolver, BorderLayout.SOUTH);

        bubbleSortMenu.setVisible(true);
    }

    // Method to show QuickSort view
    private void openQuickSortView() {
        mainView.setVisible(false);
        VentanaQS quickSortMenu = new VentanaQS();
        ControladorQS controller = new ControladorQS(quickSortMenu);
        controller.setMainView(mainView);

        // Agregar botón para volver al menú principal
        JButton btnVolver = new JButton("Volver al Menú Principal");
        btnVolver.addActionListener(e -> controller.volverAlMenu());
        quickSortMenu.add(btnVolver, BorderLayout.SOUTH);

        quickSortMenu.setVisible(true);
    }

    // Method to show MergeSort view
    private void openMergeSortView() {
        mainView.setVisible(false);
        VentanaMerge mergeSortMenu = new VentanaMerge();
        MergeController controller = new MergeController(mergeSortMenu);
        controller.setMainView(mainView);

        // Agregar botón para volver al menú principal
        JButton btnVolver = new JButton("Volver al Menú Principal");
        btnVolver.addActionListener(e -> controller.volverAlMenu());
        mergeSortMenu.add(btnVolver, BorderLayout.SOUTH);

        mergeSortMenu.setVisible(true);
    }

    // Method to show Insertion view
    private void openInsertionView() {
        mainView.setVisible(false);
        InsertionMenu insertionMenu = new InsertionMenu();
        InsertionMenuController controller = new InsertionMenuController(insertionMenu);
        controller.setMainView(mainView);

        insertionMenu.showWindow();
    }

    // Method to show Selection view
    private void openSelectionView() {
        mainView.setVisible(false);
        SelectionMenu selectionMenu = new SelectionMenu();
        SelectionMenuController controller = new SelectionMenuController(selectionMenu);
        controller.setMainView(mainView);

        selectionMenu.showWindow();
    }

    // Main method for demonstration
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            MainView mainView = new MainView();
            MainController controller = new MainController(mainView);
            mainView.setVisible(true);
        });
    }
}