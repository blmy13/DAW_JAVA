package Interfícies_Gràfiques;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class ExempleJFrame {

    public static void main(String[] args) {
        JFrame finestra = new JFrame("Exemple JFrame");
        finestra.setSize(400, 300);  // Amplada x Alçada
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        finestra.setVisible(true);  // Mostrar la finestra
    }
}
