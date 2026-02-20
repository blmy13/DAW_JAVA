package Files.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class ComptaParaulesFitxer {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new File("fistro.txt"))) {
            if (sc.hasNextLine()) {
                int numLn = 1;

                while (sc.hasNextLine() && !sc.nextLine().equals("fi")) {

                    String linia[] = sc.nextLine().split(" ");
                    
                    System.out.println("La línia " + numLn + " té " + linia.length + " paraules");
                    numLn++;
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }
}
