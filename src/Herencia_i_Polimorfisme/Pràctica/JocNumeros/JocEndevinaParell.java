package Herencia_i_Polimorfisme.Pràctica.JocNumeros;

import Herencia_i_Polimorfisme.Pràctica.Interfícies.Jugable;

public class JocEndevinaParell extends JocEndevinaNumero implements Jugable {

    public JocEndevinaParell(int numMisteri, int videsInicials) {
        super(numMisteri, videsInicials);
    }

     @Override
    public boolean validaNumero(int x) {
        if (x % 2 == 0) {
            return true;
        } else {
            System.out.println("El número no és parell.");
            return false;
        }
     }

    @Override
    public String mostraNom() {
        return "|| Joc Endevina el Número Parell ||";
    }

    @Override
    public String mostraInfo() {
        return"Tens " + videsInicials + " intents per endevinar un número parell del 1 al 10.";
    }
}
