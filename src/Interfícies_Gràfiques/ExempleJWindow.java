package Interfícies_Gràfiques;

import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.*;

public class ExempleJWindow {

    public static void main(String[] args) {
        JWindow finestra = new JWindow(); // Crear un JWindow
        finestra.setSize(300, 200);

        JLabel etiqueta = new JLabel("Finestra tonta sense marc", SwingConstants.CENTER);
        finestra.add(etiqueta);

        finestra.setLocationRelativeTo(null); // Centrar a la pantalla
        finestra.setVisible(true);

        // Tanca automàticament després de 5 segons
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        finestra.dispose(); // Tanca el JWindow
    }
}
