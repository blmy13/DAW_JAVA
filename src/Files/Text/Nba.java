package Files.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Nba {

    public static void main(String[] args) {

        List<String> equips = List.of("Celtics", "Pistons", "Grizzlies", "Suns", "Thunder", "Pelicans");
        String nom = "Resultats.txt";

        escriureResultats(nom, equips);
        Map<String, Integer> stan = llegirICalcular(nom);
        escriureClassificacio(stan);

    }

    public static void escriureResultats(String nom, List<String> equips) {
        Random punts = new Random();
        String[] teams = equips.toArray(new String[0]);

        try (Formatter f = new Formatter(nom)) {
            f.format("%-20s %-7s %-7s%n", "EQUIPS", "PUNTS 1", "PUNTS 2");
            f.format("%s%n", "-".repeat(35));
            for (int i = 0; i < teams.length; i++) {
                for (int j = i + 1; j < teams.length; j++) {
                    String eq1 = teams[i];
                    String eq2 = teams[j];

                    int punts1 = punts.nextInt(41) + 70;
                    int punts2 = punts.nextInt(41) + 70;

                    f.format("%-10s %-10s %-7d %-7d%n", eq1, eq2, punts1, punts2);

                }
            }
            System.out.println("Resultats generats correctament al fitxer Resultats.txt");
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }

    public static Map<String, Integer> llegirICalcular(String nom) {
        Map<String, Integer> standings = new HashMap<>();
        File f = new File(nom);

        try (Scanner sc = new Scanner(f)) {

            while (sc.hasNextLine()) {
                String linia = sc.nextLine();
                String dades[] = linia.trim().split("\\s+");

                if (dades.length == 4) {
                    String eq1 = dades[0];
                    String eq2 = dades[1];
                    int p1 = Integer.parseInt(dades[2]);
                    int p2 = Integer.parseInt(dades[3]);

                    standings.putIfAbsent(eq1, 0);
                    standings.putIfAbsent(eq2, 0);
                    Random guanyador = new Random();

                    if (p1 == p2) {
                        int winner = guanyador.nextInt(2);
                        if (winner == 0) {
                            p1++;
                        } else {
                            p2++;
                        }
                    }

                    if (p1 > p2) {
                        standings.put(eq1, standings.get(eq1) + 2);
                    } else {
                        standings.put(eq2, standings.get(eq2) + 2);
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        return standings;
    }

    public static void escriureClassificacio(Map<String, Integer> standings) {
        try (Formatter f = new Formatter("Classificacio.txt")) {

            standings.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .forEach(entry -> {
                        f.format("%s %d%n", entry.getKey(), entry.getValue());
                    });

            System.out.println("Classificacio generada al fitxer Classificacio.txt");
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }
}
