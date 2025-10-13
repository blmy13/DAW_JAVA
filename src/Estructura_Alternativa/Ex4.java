package Estructura_Alternativa;

import java.util.Scanner;

public class Ex4 {

    public static void main(String[] args) {

        char ope;
        int num1, num2;
        Scanner tec = new Scanner(System.in);

        System.out.println("Introdueix un número: ");
        num1 = tec.nextInt();

        System.out.println("Introdueix un altre número: ");
        num2 = tec.nextInt();

        System.out.println("Introdueix l'operació que vols realitzar: ");
        ope = tec.next().charAt(0);

        switch (ope) {
            case '+':

                System.out.println("La suma dels números que has introduït és: " + (num1 + num2));
                break;
            case '-':

                System.out.println("La resta dels números que has introduït és: " + (num1 - num2));
                break;
            case '*':

                System.out.println("El producte dels números que has introduït" + (num1 * num2));
                break;
            case '/':

                System.out.println("La divisió dels números que has introduït és: " + (num1 / num2));
                break;
            case '%':

                System.out.println("El mòdul dels números que has introduï és: " + (num1 % num2));
                break;
            default:
                System.out.println("Aquesta operació no existeix. ");

        }
    }

}
