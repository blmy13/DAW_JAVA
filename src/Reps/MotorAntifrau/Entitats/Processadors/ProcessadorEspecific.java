package Reps.MotorAntifrau.Entitats.Processadors;

import Reps.MotorAntifrau.Entitats.Transaccio;

@FunctionalInterface
public interface ProcessadorEspecific {
    void processar(Transaccio t);
}
