package Random;

import java.util.Scanner;

public class Figures_For7 {
    public static void main(String[] args) {


        Scanner tec = new Scanner(System.in);

        System.out.println("Introdueix un número.");
        int num = tec.nextInt();

        for (int i = num; i >= 1; i--) {
            for (int j = i; j >= 1; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
