package Bucles;

import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        
        Scanner tec = new Scanner(System.in);
        int suma = 0;
        
        for (int i = 5; i <= 5; i++){
            System.out.println("Introdueix un número.");
            int num = tec.nextInt();
            if (num >= 10){
                suma += num;
            }
        }
        System.out.println("La suma dels valors 10 o més grans és: " + suma);
    }
    
}
