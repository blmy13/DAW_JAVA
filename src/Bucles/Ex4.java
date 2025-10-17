package Bucles;

import java.util.Scanner;

public class Ex4 {

    public static void main(String[] args) {
        
        Scanner tec = new Scanner(System.in);
        int suma = 0, num;

        for (int i = 5; i <= 5; i++) {
            System.out.println("Introdueix un numero");
            num = tec.nextInt();
            suma += num;
        }
        System.out.println("La suma dels números és: " + suma);
    }

}
