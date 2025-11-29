package Herencia_i_Polimorfisme.Pràctica.JocNumeros;

public class JocEndevinaNumero extends JocNumeros {

    private final int numMisteri;

    public JocEndevinaNumero(int numMisteri, int videsInicials) {
        super(videsInicials);
        this.numMisteri = numMisteri;

    }

    public int getNumMisteri() {
        return numMisteri;
    }

    @Override
    public boolean heGuanyat() {
        return triaRecent == numMisteri;
    }

    @Override
    public String mostraNom() {
        return "|| Joc d'Endevinar el Número ||";
    }

    @Override
    public String mostraInfo() {
        return "Tens " + videsInicials + " intents per intentar endevinar un número del 0 al 10";
    }

}
