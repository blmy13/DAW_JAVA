package Files.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ComptaParaulesFitxer {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new File("fistro.txt"))) {

            int numLn = 1;

            String textLinia = "fi";

            if (sc.hasNextLine()) {
                textLinia = sc.nextLine();
            }

            while (!textLinia.equals("fi")) {

                int numParaules = 0;
                if (!textLinia.isEmpty()) {
                    String[] linia = textLinia.split(" ");
                    numParaules = linia.length;
                }

                System.out.println("La línia " + numLn + " té " + numParaules + " paraules");
                numLn++;

                if (sc.hasNextLine()) {
                    textLinia = sc.nextLine();
                } else {
                    textLinia = "fi";
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println("No s'ha trobat el fitxer: " + ex.getMessage());
        }
    }
}