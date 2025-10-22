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

        int num = 0;
        int sumaDiv = 0;
        int contPerf = 0, contAbu = 0, contDef = 0;
        int divInicial = 1;

        while (num != -1) {
            System.out.println("Introdueix un número.");
            num = tec.nextInt();
            while (divInicial <= num / 2) {
                if (num % divInicial == 0) {
                    sumaDiv += divInicial;
                }
                divInicial++;
            }
            if (sumaDiv == num) {
                contPerf++;
            } else if (sumaDiv > num) {
                contAbu++;
            } else {
                contDef++;
            }
        }
        System.out.println("Hi ha " + contPerf + " números perfectes.");
        System.out.println("Hi ha " + contAbu + " números abundants.");
        System.out.println("Hi ha " + contDef + " números deficients.");
    }
}

