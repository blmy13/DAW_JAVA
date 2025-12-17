package Strings;

/**
 * Fes un programa que llegeixi una cadena i un número enter N i ens digui
 * quantes paraules tenen longitud N.
 */
import java.util.Scanner;

public class Ex5 {

    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);
        System.out.println("Introdueix una frase");
        String frase = tec.nextLine();
        int cont = 0;

        System.out.println("Introdueix un número:");
        int num = tec.nextInt();

        String fraseSeparada[] = frase.split(" ");

        for (String fraseSeparada1 : fraseSeparada) {
            if (fraseSeparada1.length() == num) {
                cont++;
            }
        }
        System.out.println("Paraules amb longitud = num: " + cont);
    }

}
