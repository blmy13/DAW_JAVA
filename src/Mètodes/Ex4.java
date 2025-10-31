/*
Fes un mètode `sumaDigits(int n)` que retorni la suma de tots els dígits d’un
número. Exemple: si `n = 347`, el resultat és 3 + 4 + 7 = 14.
 */
package Mètodes;

import java.util.Scanner;

public class Ex4 {
    
    public static int sumaDigits(int x) {
        
        int d;
        int sumaD = 0;
        while (x > 1) {
            
            
            d = x % 10;
            x = x / 10;
            sumaD += d;
        }
        return sumaD;
    }
    
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        System.out.println("Introdueix un número: ");
        int num = tec.nextInt();
        
        System.out.println("El resultat és " + sumaDigits(num));
        
    }
    
}
