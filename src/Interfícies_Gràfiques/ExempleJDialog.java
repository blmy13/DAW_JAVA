package Interfícies_Gràfiques;

import javax.swing.*;
import java.util.stream.Stream;

public class ExempleJDialog {

    public static void main(String[] args) {
        JFrame marc = new JFrame("Finestra principal");
        marc.setSize(300, 200);
        marc.setVisible(true);
        marc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JDialog dialeg = new JDialog(marc, "Exemple de JDialog", true);
        dialeg.setSize(200, 150);
        dialeg.setVisible(true);
    }
}
