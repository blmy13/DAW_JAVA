package Random;

import java.util.Scanner;

public class Figures_For10 {
    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);

        System.out.println("Introdueix un número");
        int num = tec.nextInt();

        for (int i = 1; i <= num; i++){
            for (int j = num; j >= i; j--){
                if(i % 2 == 0){
                    System.out.print(j +" ");
                } else {
                    System.out.print(i +" ");
                }
            }
            System.out.println();l
        }
    }
}
