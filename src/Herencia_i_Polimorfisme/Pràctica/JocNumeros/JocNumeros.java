package Herencia_i_Polimorfisme.Pràctica.JocNumeros;

import Herencia_i_Polimorfisme.Pràctica.Interfícies.Jugable;
import Herencia_i_Polimorfisme.Pràctica.ClasseJoc.Joc;
import java.util.Scanner;

public abstract class JocNumeros extends Joc implements Jugable {

    
    protected int triaRecent = -1;

    public JocNumeros(int videsInicials) {
        super(videsInicials);
    }

    @Override
    public void juga() {
        Scanner tec = new Scanner(System.in);
        reiniciarPartida();

        System.out.println("Comença el joc!!!");
        System.out.println("Introdueix un número: ");
        int tria = tec.nextInt();

        while (!validaNumero(tria)) {
            System.out.println("Introdueix un número vàlid: ");
            tria = tec.nextInt();
        }
        triaRecent = tria;

        while (!heGuanyat() && mostraVidesRestants() > 0) {
            treuVida();
            System.out.println("Incorrecte. Vides restants: " + mostraVidesRestants());

            if (mostraVidesRestants() > 0) {
                System.out.println("Introdueix un nou número: ");
                tria = tec.nextInt();

                while (!validaNumero(tria)) {
                    System.out.println("Introdueix un número vàlid: ");
                    tria = tec.nextInt();
                }
                triaRecent = tria;
            }
        }

        if (heGuanyat()) {
            System.out.println("Enhorabona!!! Has guanyat!!!");
            actualitzaRecord();
        } else {
            System.out.println("T'has quedat sense vides :(");
            System.out.println("Fi de la partida.");
        }
    }

    public boolean validaNumero(int x) {
        return true;
    }

}





