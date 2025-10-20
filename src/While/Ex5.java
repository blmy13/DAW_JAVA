package While;

//Donat un número llegit per teclat, realitzar la suma de tots els dígits parells

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);

        System.out.println("Introdueix un número.");
        int num = tec.nextInt();

        int d = num % 10;
        int suma = 0;

        while (num > 0) {
            d = num % 10;
            if (d % 2 == 0) {
                suma += d;
            }
            num = num / 10;
        }
        System.out.println("La suma dels dígits parells del nombre que has introduït és: " + suma);
    }
}
