package Reps.MotorAntifrau.Entitats.Processadors;

import Reps.MotorAntifrau.Entitats.Transaccio;

public class ProcessadorCripto implements ProcessadorEspecific {

    @Override
    public void processar(Transaccio t) {
        System.out.println("Processant pagament mitjançant criptomoneda per import de " + t.getImportTransaccio() + "€");
    }
}
