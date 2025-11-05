/*
 Crea un mètode esParell(int n) que retorni true si el número és parell i false en
cas contrari. El programa ha de demanar un número i indicar si és parell o
imparell.
 */
package Mètodes_i_Classes;

import java.util.Scanner;

public class Ex2 {
    
    public static boolean esParell(int n) {
        boolean parell = true;
        if (n % 2 != 0) {
            parell = false;
        }
        System.out.println(parell);
        return parell;
    }
    
    public static void main(String[] args) {
        
        Scanner tec = new Scanner(System.in);
        System.out.println("Introdueix un número: ");
        int num = tec.nextInt();
        esParell(num);
    }
    
}
