package Herencia_i_Polimorfisme.Pràctica.JocNumeros;

import Herencia_i_Polimorfisme.Pràctica.Interfícies.Jugable;

public class JocEndevinaSenar extends JocEndevinaNumero implements Jugable {

    public JocEndevinaSenar(int numMisteri, int videsInicials) {
        super(numMisteri, videsInicials);
    }

    @Override
    public boolean validaNumero(int x) {
        if (x % 2 != 0) {
            return true;
        }
        System.out.println("El número no és senar.");
        return false;
    }

    @Override
    public String mostraNom() {
        return "|| Joc Endevina el Número Senar ||";
    }

    @Override
    public String mostraInfo() {
        return"Tens " + videsInicials + " intents per endevinar un número senar del 1 al 10.";
    }
}
