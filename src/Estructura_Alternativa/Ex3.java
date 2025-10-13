package Estructura_Alternativa;

import java.util.Scanner;

public class Ex3 {

    public static void main(String[] args) {

        int num1, num2, num3, max;
        Scanner tec = new Scanner(System.in);

        System.out.println("Introdueix el primer número: ");
        num1 = tec.nextInt();

        System.out.println("Introdueix el segon número: ");
        num2 = tec.nextInt();

        System.out.println("Introdueix el tercer número: ");
        num3 = tec.nextInt();

        if (num1 >= num2 && num1 >= num3) {
            max = num1;
        } else if (num2 >= num1 && num2 >= num3) {
            max = num2;
        } else {
            max = num3;
        }
        System.out.println("El número més gran és " + max + ".");
    }

}
