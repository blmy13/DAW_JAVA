package Reps.MotorAntifrau.Entitats;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class ProcessadorBatch {
    public void processarFitxer(String rutaOrigen, String rutaDesti, MotorAntifrau motor, List<ReglaFrau<Transaccio>> regles) {
        Path pathOrigen = Paths.get(rutaOrigen);
        Path pathDesti = Paths.get(rutaDesti);

        try (Stream<String> linies = Files.lines(pathOrigen)) {
            //data pipeline
            List<Transaccio> transaccionsLlegides = linies
                    .filter(linia -> !linia.isBlank())
                    .map(linia -> {
                        String [] parts =linia.split(",");
                        return new Transaccio(Double.parseDouble(parts[0]), parts[1]);

                    })
                    .toList();
            //motor avalua
            System.out.println(">> Analitzant " + transaccionsLlegides.size() + " transaccions...");
            List<Transaccio> sospitoses = motor.analitzarTransaccions(transaccionsLlegides, regles);

            //persistència
            List<String> liniesAlerta = sospitoses.stream()
                    .map(Transaccio::toString)
                    .toList();
            //escriure fitxer
            Files.write(pathDesti, liniesAlerta);
            System.out.println(">> Procés finalitzat. S'ha generat l'arxiu: " + rutaDesti);

        } catch (IOException e) {
            System.err.println(">> ERROR: Els fitxers no s'han processat correctament " + e.getMessage());
        }
    }
}
