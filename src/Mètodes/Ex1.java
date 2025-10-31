
package Mètodes;

import java.util.Scanner;

public class Ex1 {
    
    public static boolean esPrimer(int x) {
    
    int div = 2;
    boolean primer = true;
    while (div < x / 2 && primer) {
        
        if (x % div == 0) {
            primer = false;            
        }
        div++; 
    }
        System.out.println(primer);
    return primer;
}
    public static void main(String[] args) {
        
        Scanner tec = new Scanner(System.in);
        System.out.println("Introdueix un número.");
        int num = tec.nextInt();
        esPrimer(num);
    }
}
