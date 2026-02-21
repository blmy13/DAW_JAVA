package Files.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nom del fitxer:");
        String nom = sc.nextLine();
        File fitxerEntrada = new File(nom);

        if (fitxerEntrada.exists() && fitxerEntrada.isFile()) {

            try (Scanner tec = new Scanner(fitxerEntrada);
                 Formatter f = new Formatter("Histograma-" + nom)) {

                int contEx = 0, contNot = 0, contSuf = 0, contIn = 0;

                double nota = -1;

                if (tec.hasNextDouble()) {
                    nota = tec.nextDouble();
                }

                while (nota != -1) {

                    if (nota >= 9) contEx++;
                    else if (nota >= 6.5) contNot++;
                    else if (nota >= 5) contSuf++;
                    else contIn++;

                    if (tec.hasNextDouble()) {
                        nota = tec.nextDouble();
                    } else {
                        nota = -1;
                    }
                }

                f.format("Histograma del fitxer %s%n", nom);
                f.format("%s%n", "-".repeat(40));
                f.format("%-15s: %s%n", "Suspès", "*".repeat(contIn));
                f.format("%-15s: %s%n", "Aprovat", "*".repeat(contSuf));
                f.format("%-15s: %s%n", "Notable", "*".repeat(contNot));
                f.format("%-15s: %s%n", "Excel·lent", "*".repeat(contEx));

                System.out.println("S'ha generat el fitxer: Histograma-" + nom);

            } catch (FileNotFoundException ex) {
                System.out.println(ex);
            }
        } else {
            System.out.println("El fitxer '" + nom + "' no existeix a la carpeta del projecte.");
        }
        sc.close();
    }
}