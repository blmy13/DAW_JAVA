package While;

//Escriu un programa que indiqui si existeix o no algun múltiple de 5 en una
//seqüència de nombres naturals finalitzada en -1.

import java.util.Scanner;

public class Ex4 {

    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);
        System.out.println("Introdueix un número.");
        int num = tec.nextInt();
        boolean multiple = false;

        while (num != -1 && !multiple) {

            if (num % 5 == 0){
                multiple = true;
            }
            if (!multiple) {
                System.out.println("Introdueix un altre número");
                num = tec.nextInt();
            }
        }
        String resultat = multiple ? "Si que hi ha un múltiple de 5." : "No hi ha cap múltiple de 5 als números que has introduït.";
        System.out.println(resultat);
    }

}
