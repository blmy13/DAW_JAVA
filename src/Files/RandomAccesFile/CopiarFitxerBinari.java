package Files.RandomAccesFile;

import java.io.*;
import java.util.Scanner;

public class CopiarFitxerBinari {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introdueix la ruta del fitxer d'origen");
        String rutaOrigen = sc.nextLine();

        System.out.println("Introdueix la ruta del fitxer destinatari");
        String rutaDesti = sc.nextLine();

        File f = new File(rutaOrigen);
        File g = new File(rutaDesti);

        if (f.exists() && !g.exists()) {

            try (FileInputStream in = new FileInputStream(f);
                 FileOutputStream out = new FileOutputStream(g)) {

                byte[] info = new byte[1024];
                int bytesLlegit;

                while ((bytesLlegit = in.read(info)) != -1) {
                    out.write(info, 0, bytesLlegit );
                }

            } catch (IOException ex) {
                System.out.println(ex);;
            }
        }
    }
}
