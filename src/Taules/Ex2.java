package Taules;

/*
Fes un programa que donada una taula de números ja inicialitzada per codi,
la llegeixi amb un for i quan surti del for imprimeixi el valor més petit i el
més gran de la taula.
*/

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int taula[] = new int[10];
        for (int i = 0; i < taula.length; i++) {
            taula[i] = tec.nextInt();
            if (taula[i] < min) {
                min = taula[i];
            }
            if (taula[i] > max) {
                max = taula[i];
            }
        }

        System.out.println("mínim: " + min + "màxim: " + max);

    }
}
