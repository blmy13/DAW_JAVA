package Bucles;

import java.util.Scanner;

public class Ex15 {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        System.out.println("Introdueix un número");
        int num = tec.nextInt();

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num - i; j++) {
                System.out.print("  ");
            }
            for (int k = 1; k <= i; k++){
                System.out.print("* ");
            }

            System.out.println();
        }
    }

}
