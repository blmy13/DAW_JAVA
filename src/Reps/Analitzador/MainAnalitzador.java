package Reps.Analitzador;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class MainAnalitzador {
    public static void main(String[] args) throws FileNotFoundException {
        List<Videojoc> catalegJocs = new ArrayList<>();
        File f = new File("vendes.csv");
        try (Scanner sc = new Scanner(f)) {
            while (sc.hasNextLine()) {
                String linia = sc.nextLine();
                String[] columnes = linia.split(";");
                String titol = columnes[0];
                String plataforma = columnes[1];
                double vendes = Double.parseDouble(columnes[2]);

                Videojoc nouJoc = new Videojoc(titol, plataforma, vendes);
                catalegJocs.add(nouJoc);
            }

            System.out.println(catalegJocs.size() + " fitxers carregats amb èxit.");

        } catch (FileNotFoundException e) {
            System.out.println(">> ERROR:No s'ha trobat el fitxer.");
        }
        catalegJocs.forEach(System.out::println);
        vendesPerPlataforma(catalegJocs);
        top3(catalegJocs);
    }

    public static double vendesSwitch(List<Videojoc> c) {
        return c.stream()
                .filter(a -> a.getPlataforma().equalsIgnoreCase("switch"))
                .mapToDouble(Videojoc::getVendesMilions)
                .sum();
    }

    public static void top3(List<Videojoc> c) {
        System.out.println("<<< TOP 3 VIDEOJOCS MÉS VENUTS >>>");
        c.stream()
                .sorted(Comparator.comparingDouble(Videojoc::getVendesMilions).reversed())
                .limit(3)
                .forEach(System.out::println);
    }

    public static void vendesPerPlataforma(List<Videojoc> c) {
        System.out.println("<<< VENDES TOTALS PER PLATAFORMA >>>");
        Map<String, Double> vendes = c.stream()
                .collect(Collectors.groupingBy(Videojoc::getPlataforma, Collectors.summingDouble(Videojoc::getVendesMilions)));

        vendes.forEach((plataforma, total) ->System.out.printf(plataforma + " ha venut " + total + "M."));
    }
}
