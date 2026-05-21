package Reps.MotorAntifrau.Entitats.Processadors;

import Reps.MotorAntifrau.Entitats.Transaccio;

public class ProcessadorTargeta implements ProcessadorEspecific{
    @Override
    public void processar(Transaccio t) {
        System.out.println(">> Processant pagament amb targeta per import de " + t.getImportTransaccio() + "€");
    }
}
