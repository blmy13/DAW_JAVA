package Estructura_Alternativa;

import java.util.Scanner;

public class Ex1 {

    public static void main(String[] args) {

        int num, numP, numS;

        Scanner tec = new Scanner(System.in);

        System.out.println("Introdueix un número: ");
        num = tec.nextInt();

        if (num % 2 == 0) {
            numP = num * 2 + 3;
            System.out.println("El número és parell, serà multiplicat per dos i se li sumarà 3, el resultat és: " + numP);
        } else {
            numS = num * 3 + 4;
            System.out.println("El número és senar, serà multiplicat per 3 i se li restarà 4, el resultat és: " + numS);
        }

    }

}