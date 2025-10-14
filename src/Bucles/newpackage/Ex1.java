package Bucles.newpackage;

import java.util.Scanner;

public class Ex1 {

    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);
        
        int suma = 0;
        
        for (int i = 1; i <= 5; i++) {
            System.out.println("Introdueix un número");
            int num =  tec.nextInt();
            suma += num;
            
        }
        System.out.println("La suma és: "+ suma);

    }
    

}
