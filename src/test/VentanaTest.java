package test;

import javax.swing.*;

import view.VentanaBubbleSort;
import view.VentanaMerge;
import view.VentanaQS;

public class VentanaTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaQS ventanaQS = new VentanaQS();
            ventanaQS.setVisible(true);

            VentanaMerge ventanaMerge = new VentanaMerge();
            ventanaMerge.setVisible(true);

            VentanaBubbleSort ventanaBubbleSort = new VentanaBubbleSort();
            ventanaBubbleSort.setVisible(true);
        });
    }
}
