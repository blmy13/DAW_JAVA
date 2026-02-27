package Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Lector3 {
    public static void main(String[] args) {

        try (FileReader f = new FileReader("fitxer_fantasma.txt")) {

        } catch (FileNotFoundException ex) {
            System.out.println(ex + "El fitxer no s'ha pogut trobar, però el programa no ha petat");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
