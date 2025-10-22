/*
Es diu que un número es perfecte si la suma dels seus divisors és igual al mateix
número. Per exemple el número 6 és perfecte perquè la suma dels seus divisors
(1+2+3) és igual a 6.
 */

import java.util.Scanner;

public class Extra5 {

    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);

        System.out.println("Introdueix un número.");
        int num = tec.nextInt();       

        int sumaDiv = 0;
        int divInicial = 1;
        
        while (divInicial <= num / 2){
            
            if (num % divInicial == 0) {
                sumaDiv += divInicial;              
                
            }
            divInicial++;
        }
        
        System.out.println((num == sumaDiv) ? "El número és perfecte" : "El número no és perfecte.");

    }

}
