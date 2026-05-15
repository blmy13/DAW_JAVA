package Reps.Botiga;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.InputMismatchException;

public class main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Map<String, Venda> cataleg = getCataleg();

        double valorTotal = cataleg.values().stream()
                .mapToDouble(Venda::getPreu)
                .sum();

        System.out.println("\n<<< OFERTES >>>");
        cataleg.values().stream()
                .filter(a -> a.getPreu() < 500)
                .forEach(a -> System.out.println("  >> " + a.getNomArticle() + " a " + a.getPreu() + "€"));

        System.out.println("Quin Article vols comprar?");
        String nomCerca = sc.nextLine();
        if (cataleg.get(nomCerca) != null) {
            try {
                System.out.println("Quantes unitats en vols comprar?");
                int quantitat = sc.nextInt();
                sc.nextLine();

                double preuTotal = cataleg.get(nomCerca).getPreu() * quantitat;
                System.out.println("El preu total és de " + preuTotal + "€.");

                try (FileWriter fw = new FileWriter("tiquet.txt")) {
                    fw.write("<<< Tiquet de Compra >>>\n");
                    fw.write("Article: " + nomCerca + " | Quantitat: " + quantitat + " | Import: " + preuTotal + "€.");
                } catch (IOException e) {
                    System.out.println("Error en guardar el fitxer: " + e.getMessage());
                }

            } catch (InputMismatchException e) {
                System.out.println(">> ERROR: Introdueix la quantitat en valor numèric");
            }
        } else {
            System.out.println("El producte no es troba al catàleg.");
        }
    }

    private static Map<String, Venda> getCataleg() {
        Map<String, Venda> cataleg = new HashMap<>();
        Espasa e1 = new Espasa("Oblivion", 666.67, 75);
        Espasa e2 = new Espasa("Oathkeeper", 444.00, 75);
        Espasa e3 = new Espasa("Kingdom Key", 99.99, 40);
        Espasa e4 = new Espasa("Lionheart", 150.75, 50);
        Espasa e5 = new Espasa("Ultima Weapon", 999.99, 100);
        cataleg.put("Oblivion", e1);
        cataleg.put("Oathkeeper", e2);
        cataleg.put("Kingdom Key", e3);
        cataleg.put("Lionheart", e4);
        cataleg.put("Ultima Weapon", e5);
        return cataleg;
    }
}
