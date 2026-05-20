package Reps.MotorAntifrau.Entitats;

import java.util.List;

public class MotorAntifrau {

    public List<Transaccio> analitzarTransaccions(List<Transaccio> transaccions, List<ReglaFrau<Transaccio>> regles) {
        return transaccions.stream()
                .filter(transaccio -> regles.stream().anyMatch(regla -> regla.avaluar(transaccio)))
                .toList();
    }
}
