package Random;

import java.util.Scanner;

public class Figures_For8 {
    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);

        System.out.println("Introdueix un número.");
        int num = tec.nextInt();

        for (int i = 1; i <= num; i++){
            for (int j = num; j >= i; j--){
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
}
