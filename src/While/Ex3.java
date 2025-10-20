package While;

import java.util.Scanner;

public class Ex3 {

    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);
        System.out.println("Introdueix un número.");
        int num = tec.nextInt();

        int suma = 0;
        int d = num % 10;

        while (num != 0) {

            suma += d;
            num = num / 10;
            d = num % 10;
        }
        System.out.println("La suma dels dígits del número que has introduït és: " + suma);
    }

}
