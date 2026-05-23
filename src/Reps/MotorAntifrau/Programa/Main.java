package Reps.MotorAntifrau.Programa;

import Reps.MotorAntifrau.Entitats.MotorAntifrau;
import Reps.MotorAntifrau.Entitats.ProcessadorBatch;
import Reps.MotorAntifrau.Entitats.Processadors.FabricaProcessadors;
import Reps.MotorAntifrau.Entitats.ReglaFrau;
import Reps.MotorAntifrau.Entitats.Transaccio;
import Reps.MotorAntifrau.Persistencia.BDSingleton;
import Reps.MotorAntifrau.Persistencia.TransaccioDAO;

import java.sql.Connection;
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
        FabricaProcessadors fabrica = new FabricaProcessadors();

        try {
            // 1. Obtenir connexio
            Connection connexioReal = BDSingleton.getInstance();

            // 2. Injectar connexio al DAO
            TransaccioDAO dao = new TransaccioDAO(connexioReal);

            // 3. Executar
            proBatch.processarFitxer("transaccions.csv", "alertes_frau.log", motor, regles, fabrica, dao);

            // 4. Tancar connexió
            connexioReal.close();
            System.out.println(">> BBDD: Connexió tancada.");

        } catch (Exception e) {
            System.err.println(">> ERROR CRÍTIC: Falla el sistema principal: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
