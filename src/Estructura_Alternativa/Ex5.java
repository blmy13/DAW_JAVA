package Estructura_Alternativa;

import java.util.Scanner;

public class Ex5 {

    public static void main(String[] args) {

        int num, numBits;
        numBits = 0;
        Scanner tec = new Scanner(System.in);

        System.out.println("Introdueix un número comprès entre el 0 i el 64");
        num = tec.nextInt();

        if (num >= 0 && num <= 64) {
            System.out.println("Número vàlid");
        } else {
            System.out.println("El número que has introduït no és admès.");

        }
        if (num < 2) {
            numBits = 1;
        } else if (num <= 3) {
            numBits = 2;
        } else if (num <= 7) {
            numBits = 3;
        } else if (num <= 15) {
            numBits = 4;
        } else if (num <= 31) {
            numBits = 5;
        } else if (num <= 63) {
            numBits = 6;
        } else if (num == 64) {
            numBits = 7;
        }
        System.out.println("Per escriure el número que has introduït en binari es necessiten: " + numBits + " bits.");
    }

}