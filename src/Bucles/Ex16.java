package Bucles;

import java.util.Scanner;

public class Ex16 {
    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);
        System.out.println("Introdueix un número.");
        int num = tec.nextInt();

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i - 1; j++) {
                System.out.print("  ");
            }
            for (int k = num; k >= i; k--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
