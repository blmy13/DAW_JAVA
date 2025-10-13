package Exam_Test;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {

        int num;
        Scanner tec = new Scanner(System.in);

        System.out.println("Introdueix un número. ");
        num = tec.nextInt();

        for (int i = 1; i <= num; i++) {
            for (int j = i; j < num; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2 * i - 1); j++) {
                if (j % 2 == 1) {
                    System.out.print("*");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
        for (int i = num - 1; i >= 1; i--) {
            for (int j = 1; j <= (num - i); j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2 * i - 1); j++) {
                if (j % 2 == 1) {
                    System.out.print("*");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }
}
