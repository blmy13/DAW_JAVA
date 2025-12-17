package Strings;

/**
 * Féu un programa que llegeixi una cadena de caràcters i indiqui si la cadena
 * és un palíndrom. Un palíndrom és una cadena que es llegeix d‟igual manera
 * d‟esquerra a dreta que de dreta a esquerra. Com per exemple : dabale arroz a
 * la zorra el abad.
 */
import java.util.Scanner;

public class Ex7 {

    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);
        System.out.println("Introdueix una frase sense espais:");
        String frase = tec.nextLine();

        boolean igual = true;
        int i = 0;
        int j = frase.length();
        char frase1[] = frase.toCharArray();

        while (igual && i < j) {
            if (frase1[i] != frase1[j]) {
                igual = false;
            }
            i++;
            j--;
        }
        String msg = igual ? "És un palíndrom" : "No és un palíndrom";
        System.out.println(msg);

    }

}
