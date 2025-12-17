package Strings;

/*
Fes un programa que llegeixi una cadena i la mostri invertida.
 */
import java.util.Scanner;

public class Ex6 {

    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);

        System.out.println("Introdueix una frase:");
        String frase = tec.nextLine();

        char[] caracters = frase.toCharArray();

        int esquerra = 0;
        int dreta = caracters.length - 1;

        while (esquerra < dreta) {
            char temp = caracters[esquerra];
            caracters[esquerra] = caracters[dreta];
            caracters[dreta] = temp;

            esquerra++;
            dreta--;
        }

        String fraseInv = new String(caracters);

        System.out.println("Frase invertida: " + fraseInv);

    }

}
