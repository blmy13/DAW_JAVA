package Herencia_i_Polimorfisme.Pràctica.JocNumeros;

import Herencia_i_Polimorfisme.Pràctica.Interfícies.Jugable;

public class JocEndevinaMultiplicacio extends JocNumeros implements Jugable {

    private final int num1, num2, resultat;
    private int nivell;

    public JocEndevinaMultiplicacio(int videsInicials, int nivell) {
        super(videsInicials);
        int max;
        switch (nivell) {
            case 1 -> max = 5;
            case 2 -> max = 10;
            default -> max = 15;
        }

        this.num1 = (int) (Math.random() * max) + 1;
        this.num2 = (int) (Math.random() * max) + 1;
        this.resultat = num1 * num2;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public int getNivell() {
        return nivell;
    }

    public int getResultat() {
        return resultat;
    }

    @Override
    public boolean heGuanyat() {
        return triaRecent == resultat;
    }

    @Override
    public String mostraNom() {
        return "|| Joc Endevinar Multiplicació ||";
    }

    @Override
    public String mostraInfo() {
        return "Tens " + videsInicials + "intents per endevinar el resultat de la multiplicació de 2 números generats aleatòriament. Bona Sort!!! :)";
    }
}
