package Files.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Nom del fitxer");
        String nom = sc.nextLine();
        File fitxer = new File(nom);
        sc.close();
        
        if (fitxer.exists() && fitxer.isFile()) {
            try (Scanner tec = new Scanner( new File (nom))) {
                if (tec.hasNextDouble()) {
                    while (tec.hasNextDouble() && tec.nextDouble() != -1)) {
                        
                    }
                }
            } catch (FileNotFoundException ex) {
                System.out.println(ex);
            }
        }
    }
}
