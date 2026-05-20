package Reps.MotorAntifrau.Programa;

import Reps.MotorAntifrau.Entitats.MotorAntifrau;
import Reps.MotorAntifrau.Entitats.ProcessadorBatch;
import Reps.MotorAntifrau.Entitats.ReglaFrau;
import Reps.MotorAntifrau.Entitats.Transaccio;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<ReglaFrau<Transaccio>> regles = new ArrayList<>();
        //regla 1 -- Import alt
        regles.add(t -> t.getImportTransaccio() > 10000);
        //regla 2 -- país sketchy
        regles.add(t -> t.getPaisOrigen().equalsIgnoreCase("paradís fiscal"));

        MotorAntifrau motor = new MotorAntifrau();
        ProcessadorBatch proBatch = new ProcessadorBatch();
        proBatch.processarFitxer("transaccions.csv", "alaertes_frau.log", motor, regles);

    }

}
