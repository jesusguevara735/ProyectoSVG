package main;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ventana extends JFrame {

    private JPanel panel;
    private JTextArea texto;
    private JScrollPane scrollPane;

    public Ventana(String html) {
        setTitle("Imagen SVG");
        setSize(550, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setResizable(false);
        iniciar();
        texto.setText(html);
    }

    private void iniciar() {
        panel = new JPanel();
        panel.setLayout(new GridLayout());
        this.getContentPane().add(panel);
        texto = new JTextArea();
        texto.setFont(new Font("Arial", Font.PLAIN, 14));
        scrollPane = new JScrollPane(texto);
        panel.add(scrollPane);
    }

}
