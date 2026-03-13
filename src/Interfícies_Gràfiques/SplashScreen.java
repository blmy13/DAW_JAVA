package Interfícies_Gràfiques;


import javax.swing.*;
import java.awt.*;

public class SplashScreen {
   public static void main(String[] args) {
        JWindow splash = new JWindow();
        splash.setSize(400, 250);
        splash.setLayout(new BorderLayout());

        JLabel imatge = new JLabel(new ImageIcon("icon-splash.png"));
        JProgressBar barraProgres = new JProgressBar();
        barraProgres.setStringPainted(true);

        splash.add(imatge, BorderLayout.CENTER);
        splash.add(barraProgres, BorderLayout.SOUTH);
        splash.setLocationRelativeTo(null);
        splash.setVisible(true);

        // Simular càrrega progressiva
        for (int i = 0; i <= 100; i += 10) {
            try {
                Thread.sleep(500);
                barraProgres.setValue(i);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        splash.dispose();

        JFrame finestraPrincipal = new JFrame("Aplicació Principal");
        finestraPrincipal.setSize(600, 400);
        finestraPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestraPrincipal.setVisible(true);
    }
}
