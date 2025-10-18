package Bucles;

import java.util.Scanner;

public class Ex20 {
    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);

        System.out.println("Introdueix un número");
        int num = tec.nextInt();

        if (num > 3 && num % 2 != 0) {
            int mida = 2 * num - 1;

            for (int i = 0; i < mida; i++) {
                for (int j = 0; j < mida; j++) {
                    int distDreta = mida - 1 - j;
                    int distEsq = j;
                    int distUp = i;
                    int distDown = mida - 1 - i;

                    int minLateral = (distEsq < distDreta) ? distEsq : distDreta;
                    int minVertical = (distUp < distDown) ? distUp : distDown;
                    int minim = (minLateral < minVertical) ? minLateral : minVertical;

                    int val = minim + 1;
                    System.out.print(val + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("El número a introduïr ha de ser senar i més gran que 3.");
        }
    }
}
