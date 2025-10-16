package Random;

import java.util.Scanner;

public class Figures_For1 {
    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);

        System.out.println("Introdueix un número");
        int num = tec.nextInt();

        for (int i = 1; i <= num; i++){
            for (int j = 1; j <= i; j++){
                System.out.print(j +" ");
            }
            System.out.println();
        }
    }
}
