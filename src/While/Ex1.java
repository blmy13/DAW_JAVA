package While;

import java.util.Scanner;

public class Ex1 {

    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        System.out.println("Introdueix un número");
        int num = tec.nextInt();

        while (num > 0) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
            System.out.println("Introdueix el següent número: ");
            num = tec.nextInt();

        }
        if (num > 0) {
            System.out.println("El número més gran és: " + max);
            System.out.println("El número més petit és: " + min);
        } else {
            System.out.println("Has introduït un número negatiu.");
        }

    }

}
