package view;

import model.*;
import controller.MergeController;

import javax.swing.*;
import java.awt.*;

public class VentanaMerge extends JFrame {
    private JTextField tfTama;
    private JTextArea taResultados;
    private JButton btnEjecutar;

    public VentanaMerge() {
        super("Ordenamiento MergeSort");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        // Panel superior: entrada
        JPanel pnlEntrada = new JPanel();
        pnlEntrada.add(new JLabel("Número de políticos:"));
        tfTama = new JTextField(5);
        pnlEntrada.add(tfTama);
        btnEjecutar = new JButton("Ordenar y medir");
        pnlEntrada.add(btnEjecutar);
        add(pnlEntrada, BorderLayout.NORTH);

        // Área de resultados
        taResultados = new JTextArea();
        taResultados.setEditable(false);
        add(new JScrollPane(taResultados), BorderLayout.CENTER);

        // Acción
        btnEjecutar.addActionListener(e -> {
            int n = Integer.parseInt(tfTama.getText());
            taResultados.setText("");
            MergeController controlador = new MergeController(this);
            controlador.ejecutar(n);
        });
    }

    public void mostrarResultados(String texto) {
        taResultados.append(texto + "\n");
    }
}
