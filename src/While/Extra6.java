package While;

/*
Es diu que un número és deficient si no arriba a ser perfecte. perquè la suma dels
divisors del número és menor que el número. En el sentit contrari, es diu que un
número és abundant si la suma dels divisors és més gran que ell. Construïu un
programa que per a un rang de 1 a n, sent n entrada pel programa, determini si el
número és deficient, perfecte o abundant. Indiqueu també quants hi ha de cada un
dels tipus.
 */

import java.util.Scanner;

public class Extra6 {
    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);

        int contPerf = 0, contAbu = 0, contDef = 0;
        int numActual = 1;
        System.out.println("Introdueix el rang.");
        int num = tec.nextInt();

        while (numActual <= num) {

            int sumaDiv = 0;

            if (num == 1) {
                sumaDiv = 0;

            } else {

                int divisor = 1;
                while (divisor <= numActual / 2) {
                    if (numActual % divisor == 0) {
                        sumaDiv += divisor;
                    }
                    divisor++;
                }
                if (sumaDiv == numActual) {
                    contPerf++;
                } else if (sumaDiv > numActual) {
                    contAbu++;
                } else {
                    contDef++;
                }
                numActual++;
            }
        }
        System.out.println("Hi ha " + contPerf + " números perfectes.");
        System.out.println("Hi ha " + contAbu + " números abundants.");
        System.out.println("Hi ha " + contDef + " números deficients.");
    }
}

