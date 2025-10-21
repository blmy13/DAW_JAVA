package While;

//Programa que llegeixi un número i indiqui si tots els dígits són parells.

import java.util.Scanner;

public class Ex12 {

    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);

        System.out.println("Introdueix un número.");
        int num = tec.nextInt();
        int d;
        boolean totsParells = true;

        while (num > 0 && totsParells) {

            d = num % 10;

            if (d % 2 != 0) {

                totsParells = false;
            }

            num = num / 10;

        }

        System.out.println(totsParells ? "Tots els dígits del número que has introduït són parells." : "No tots els dígits són parells");

    }

}
