package Bucles;

import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        
        System.out.println("Introdueix un número:");
        int num = tec.nextInt();
        
        for (int i = 1; i <= num; i++){
            System.out.print("* ");
        }
    }   
}
