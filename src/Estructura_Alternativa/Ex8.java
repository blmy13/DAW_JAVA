package Estructura_Alternativa;

import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {
        int mesN, diaN, anyN, diaA, mesA, anyA;
        boolean majorAny = true;
        Scanner tec = new Scanner(System.in);
        System.out.println("Introdueix el teu any de naixement: ");
        anyN = tec.nextInt();
        System.out.println("Introdueix el teu mes de naixement: ");
        mesN = tec.nextInt();
        System.out.println("Introdueix el teu dia de naixement: ");
        diaN = tec.nextInt();
        System.out.println("Introdueix l'any actual. ");
        anyA = tec.nextInt();
        System.out.println("Introdueix el mes actual. ");
        mesA = tec.nextInt();
        System.out.println("Introdueix el dia actual. ");
        diaA = tec.nextInt();
        majorAny = (anyA - anyN > 18);
        if (majorAny) {
            System.out.println("És major d'edat.");
        } else if (anyA - anyN < 18) {
            System.out.println("És menor d'edat.");
        } else {
            if (mesN < mesA) {
                System.out.println("És major d'edat.");
            } else if (mesN > mesA) {
                System.out.println("És menor d'edat.");
            } else {
                if (diaN <= diaA) {
                    System.out.println("És major d'edat.");
                } else {
                    System.out.println("És menor d'edat.");
                }
            }
        }
    }
}

