package Interfícies_Gràfiques;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Suma {

    public static void main(String[] args) {

        UIManager.put("OptionPane.cancelButtonText", "Cancel·lar");
        UIManager.put("OptionPane.okButtonText", "Acceptar");

        String primer = JOptionPane.showInputDialog(null, //quadre de diàleg, si es cancela retorna null
                "Introdueix el primer número", "Entrada de valors",
                JOptionPane.INFORMATION_MESSAGE);

        String segon = JOptionPane.showInputDialog(null,
                "Introdueix el segon número", "Entrada de valors",
                JOptionPane.INFORMATION_MESSAGE);

        if (primer != null && segon != null) {
            if (primer.matches("\\d+") && segon.matches("\\d*")) {
                int numero1 = Integer.parseInt(primer);
                int numero2 = Integer.parseInt(segon);
                int suma = numero1 + numero2;
                JOptionPane.showMessageDialog(null, "La suma és " + suma,
                        "Suma de dos enters", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Posa números, animal!!",
                        "Inútil!", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "T'avorreixes o què?",
                    "Collons!", JOptionPane.ERROR_MESSAGE);
        }
    }
}
