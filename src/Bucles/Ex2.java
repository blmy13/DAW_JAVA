package Bucles;

import java.util.Scanner;

public class Ex2 {

    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for (int i = 1; i < 6; i++) {
            System.out.println("Introdueix un número: ");
            int num = tec.nextInt();
            if (num > max) {
                max = num;
            }
            if (min > num) {
                min = num;
            }
        }
        System.out.println("El número més gran és " + max);
        System.out.println("El número més petit és " + min);
    }

}
