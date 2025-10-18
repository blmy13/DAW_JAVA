package Bucles;

import java.util.Scanner;

public class Ex18i19 {
    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);
        System.out.println("Introdueix un número senar més gran que 3: ");
        int num = tec.nextInt();

        if (num < 3 || num % 2 == 0) {
            System.out.println("El número ha de ser senar i més gran que 3.");
        } else {
            for (int i = 0; i < num; i++) {


                for (int j = 0; j < num - i - 1; j++) {
                    System.out.print(" ");
                }

                for (int k = 0; k < 2 * i + 1; k++) {

                    if (i == num - 1 || k == 0 || k == 2 * i || i == num / 2) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }

                System.out.println();
            }
        }
    }
}
