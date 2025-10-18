package Bucles;

import java.util.Scanner;

public class Ex17 {
    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);
        System.out.println("Introdueix un número:");
        int num = tec.nextInt();

        for (int i = 0; i < num; i++) {
            int numEspais = (i <= num / 2) ? i : num - 1 - i;
            int numEstrelles = num - 2 * numEspais;

            for (int j = 0; j < numEspais; j++) {
                System.out.print("  ");
            }


            for (int j = 0; j < numEstrelles; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
