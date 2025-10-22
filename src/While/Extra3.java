package While;/*
Per trobar el màxim comú divisor (mcd) de dos números s’utilitza l’algorisme
d’Euclides. Donat dos números enters a i b, es mira quin és el més gran. Si el més
gran és a, es substitueix per a - b; si el més gran és b es substitueix per b – a , i així
successivament fins que a = b. Aleshores a és el mcd. Escriviu un programa que
calculi el mcd de dos números.
 */

import java.util.Scanner;

public class Extra3 {
    public static void main(String[] args) {
        
        Scanner tec = new Scanner(System.in);
        
        System.out.println("Introdueix un número.");
        int numA = tec.nextInt();
        
        System.out.println("Introdueix un número.");
        int numB = tec.nextInt();
        
        while (numA != numB) { 
            
            if (numA > numB) {
                
                numA -= numB;
                
            } else {
                
                numB -= numA;
            }
            
        }
        
        int mcd = numA;
        
        System.out.println("El màxim comú divisor és: " + mcd);
    }
    
}
