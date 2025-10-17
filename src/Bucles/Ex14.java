package Bucles;

import java.util.Scanner;

public class Ex14 {

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        
        System.out.println("Introdueix un número");
        int num = tec.nextInt();
        
        for (int i = num; i >= 1; i--){
            for (int j = 1; j<= i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }

    }

}
