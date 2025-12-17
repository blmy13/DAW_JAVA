package Strings;

/**
 * Fes un programa anomenat ParaulesSenars que llegeixi una frase escrita en una
 * sola línia des del teclat i tot seguit escrigui les paraules que hi ha en
 * posició senar (la primera, la tercera, etc.). Per exemple, si s'escriu “Hi
 * havia una vegada un lloc...”, es mostrarà “Hi una un”.
 */
import java.util.Scanner;

public class Ex4 {

    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);
        System.out.println("Introdueix una frase:");
        String frase = tec.nextLine();

        String[] fraseSeparada = frase.split(" ");

        for (int i = 0; i < fraseSeparada.length; i += 2) {
            System.out.print("\n" + fraseSeparada[i]);

        }
        System.out.println("");

    }

}
