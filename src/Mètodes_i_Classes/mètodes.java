
package Mètodes_i_Classes;

import java.util.Scanner;

public class mètodes {
    
    public static void saluda() { //public + static + tipus dada de retorn, parèntesis: dades d'entrada.
        System.out.println("Hola");   
    }
    public static void saludaAAlgu(String nom, int edat) {
        System.out.println("HOLA " + nom + ", tens " + edat + " anys.");
    }
    public static int sumar(int num1, int num2) {
        int suma = num1 + num2;
        return suma;
    }
    
    public static int demanarNumero() {
        Scanner tec = new Scanner(System.in);
        System.out.println("Introdueix un número: ");
        int num = tec.nextInt();
        return num;
        
    }
    
    public static void main(String[] args) {
        
        String alumne = "Àlex";       
        saludaAAlgu(alumne, 25);
        
        int resultat;
        resultat = sumar(13,444);
        System.out.println("El resultat és: " + resultat);
        
        demanarNumero();
                    
    }
    
}
