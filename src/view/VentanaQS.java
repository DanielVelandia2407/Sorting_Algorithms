package view;

import controller.ControladorQS;
import model.estructuras.*;
import javax.swing.*;
import java.awt.*;

/**
 * Ventana para ordenar con QuickSort y mostrar métricas.
 */
public class VentanaQS extends JFrame {
    private JTextField tfTama;
    private JTextArea taResultados;
    private JButton btnEjecutar;

    public VentanaQS() {
        super("Ordenamiento QuickSort");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        JPanel pnlEntrada = new JPanel();
        pnlEntrada.add(new JLabel("Número de políticos:"));
        tfTama = new JTextField(5);
        pnlEntrada.add(tfTama);
        btnEjecutar = new JButton("Ordenar y medir");
        pnlEntrada.add(btnEjecutar);
        add(pnlEntrada, BorderLayout.NORTH);

        taResultados = new JTextArea();
        taResultados.setEditable(false);
        add(new JScrollPane(taResultados), BorderLayout.CENTER);

        btnEjecutar.addActionListener(e -> {
            int n = Integer.parseInt(tfTama.getText());
            taResultados.setText("");
            ControladorQS controlador = new ControladorQS(this);
            controlador.ejecutar(n);
        });
    }

    public void mostrarResultados(String texto) {
        taResultados.append(texto + "\n");
    }

    public void mostrarArrayOrdenado(String arrayTexto) {
        taResultados.append("Array ordenado: " + arrayTexto + "\n");
    }
}
