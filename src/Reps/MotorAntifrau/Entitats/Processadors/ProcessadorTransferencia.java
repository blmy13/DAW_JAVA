package Reps.MotorAntifrau.Entitats.Processadors;

import Reps.MotorAntifrau.Entitats.Transaccio;

public class ProcessadorTransferencia implements ProcessadorEspecific{
    @Override
    public void processar(Transaccio t) {
        System.out.println(">> Processant pagament per transferència per import de " + t.getImportTransaccio() + "€");
    }
}
