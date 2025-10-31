/*
Crea quatre mètodes: `sumar`, `restar`, `multiplicar` i `dividir`. El programa ha
de demanar dos números i una operació (`+`, `-`, `*`, `/`) i mostrar el resultat.
 */
package Mètodes;

import java.util.Scanner;

public class Ex3 {

    public static int suma(int x, int y) {
        int suma = x + y;
        return suma;
    }

    public static int resta(int x, int y) {
        int resta = x - y;
        return resta;
    }

    public static int prod(int x, int y) {
        int prod = x * y;
        return prod;
    }

    public static int div(int x, int y) {
        int div = x / y;
        return div;
    }

    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);
        System.out.println("Introdueix un número: ");
        int num1 = tec.nextInt();
        System.out.println("Introdueix el segon número: ");
        int num2 = tec.nextInt();

        System.out.println("Introdueix la operació que vols realitzar: ");
        char ope = tec.next().charAt(0);

        if (ope != '+' || ope != '-' || ope != '*' || ope != '/') {
            System.out.println("Operador no vàlid");
        } else {
            switch (ope) {
                case '+':
                    System.out.println(suma(num1, num2));
                    break;
                case '-':
                    System.out.println(resta(num1, num2));
                    break;
                case '*':
                    System.out.println(prod(num1, num2));
                    break;
                case '/':
                    System.out.println(div(num1, num2));
                    break;

            }
        }
    }

}
