/*
Calculeu aproximadament l’arrel quadrada d’un número real positiu r seguint el
mètode de Newton.
 */

import java.util.Scanner;

public class Extra4 {

    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);

        System.out.println("Introdueix un número.");
        double numR = tec.nextDouble();

        double xI, xIS;

        xI = numR / 2;
        xIS = (xI + (numR / xI)) / 2;

        while (Math.abs(xIS - xI) >= 0.0001) {
            xI = xIS;
            xIS = (xI + (numR / xI)) / 2;

        }
        System.out.println("El valor de l'arrel quadrada del número que has introduït és " + xIS);

    }

}
