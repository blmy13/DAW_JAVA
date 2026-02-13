package Files;

import java.io.File;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introdueix la ruta:");
        String ruta = sc.nextLine();
 
        System.out.println("Introdueix la mida en Kb");
        int mida = sc.nextInt();
        
        File f = new File(ruta);
        if (!f.exists()) {
            System.out.println("La ruta no és vàlida");
        }
        File[] files = f.listFiles();
        
        for (File a : files) {
            if (a.isFile()) {
                if (f.length() / 1024 > mida) {
                    System.out.println("El fitxer: " + a.getAbsolutePath() + " és més gran que la mida que has introduït");
                }
            }
        }
        
    }
}
