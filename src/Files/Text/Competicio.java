package Files.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Competicio {

    public static void main(String[] args) {

        List<String> equips = List.of("Alison", "Marc", "Enric", "Satan", "Mochi");
        String nom = "resultats.txt";

        escriureResultatsAleatoris(nom, equips);
        Map<String, Integer> clas = llegirResultatsICalcularClassificacio(nom);
        escriureClassificacio(clas);

    }

    public static void escriureResultatsAleatoris(String nom, List<String> equips) {

        Random gol = new Random();

        String[] teams = equips.toArray(new String[0]);

        try (Formatter f = new Formatter(nom)) {
            f.format("%-20s %-7s %-7s%n", "EQUIPS", "GOLS 1", "GOLS 2");
            f.format("%s%n", "-".repeat(35));
            for (int i = 0; i < teams.length; i++) {
                for (int j = i + 1; j < teams.length; j++) {
                    String equip1 = teams[i];
                    String equip2 = teams[j];

                    int gols1 = gol.nextInt(6);
                    int gols2 = gol.nextInt(6);

                    f.format("%-10s %-10s %-7d %-7d%n", equip1, equip2, gols1, gols2);                }
            }
            System.out.println("Partits generats correctament.");

        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }

    public static Map<String, Integer> llegirResultatsICalcularClassificacio(String nom) {
        File f = new File(nom);
        Map<String, Integer> classificacio = new HashMap<>();

        try (Scanner sc = new Scanner(f)) {
            while (sc.hasNextLine()) {
                String linia = sc.nextLine();

                String[] contingut = linia.trim().split("\\s+");

                if (contingut.length == 4) {
                    String eq1 = contingut[0];
                    String eq2 = contingut[1];
                    int g1 = Integer.parseInt(contingut[2]);
                    int g2 = Integer.parseInt(contingut[3]);

                    classificacio.putIfAbsent(eq1, 0);
                    classificacio.putIfAbsent(eq2, 0);

                    if (g1 > g2) {
                        classificacio.put(eq1, classificacio.get(eq1) + 3);
                    } else if (g1 < g2) {
                        classificacio.put(eq2, classificacio.get(eq2) + 3);
                    } else {
                        classificacio.put(eq1, classificacio.get(eq1) + 1);
                        classificacio.put(eq2, classificacio.get(eq2) + 1);
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No s'ha trobat el fitxer: " + ex);
        }
        return classificacio;
    }

    public static void escriureClassificacio(Map<String, Integer> classificacio) {
        try (Formatter f = new Formatter("classificacio.txt")) {
            //Ordernar mapa
            classificacio.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .forEach(entry -> {
                        f.format("%s %d%n", entry.getKey(), entry.getValue());
                    });

            System.out.println("Classificació guardada a classificacio.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
