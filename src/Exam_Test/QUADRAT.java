package Exam_Test;

import java.util.Scanner;

public class QUADRAT {
    public static void main(String[] args) {

        int num;
        Scanner tec = new Scanner(System.in);

        System.out.println("Introdueix un numero.");
        num = tec.nextInt();

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                if ((i == 1 || i == num) && (j == 1 || j == num)) {
                    System.out.print("* ");
                } else if (i == 1 || i == num) {
                    System.out.print("- ");
                } else if (j == 1 || j == num) {
                    System.out.print("| ");
                } else if (num % 2 != 0 && (i == num / 2 + 1) && (j == num / 2 + 1)) {
                    System.out.print("X ");
                } else if (i == j) {
                    System.out.print("\\ ");
                } else if (j == num - (i - 1)) {
                    System.out.print("/ ");
                }  else {
                    System.out.print("  ");
                }


            }
            System.out.println();
        }

    }
}
