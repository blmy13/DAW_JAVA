package Estructura_Alternativa;

import java.util.Scanner;

public class Ex6 {
    public static void main(String[] args) {
        int mes, any;
        boolean bisext = true;
        Scanner tec = new Scanner(System.in);
        System.out.println("Introdueix un any: ");
        any = tec.nextInt();
        bisext = ((any % 4 == 0) && (any % 100 != 0)) || (any % 400 == 0);
        if (bisext) {
            System.out.println("L'any que has introduït és un any bisext. ");
        } else {
            System.out.println("L'any que has introduït és un any normal. ");
        }
        System.out.println("Introdueix un mes. ");
        mes = tec.nextInt();
        int dies = switch (mes) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 2 -> {
                if (bisext) {
                    yield 29;
                } else {
                    yield 28;
                }
            }
            case 4, 6, 9, 11 -> 30;
            default -> -1;
        };
        if (dies != -1) {
            System.out.println("El mes que has introduït té " + dies + " dies.");
        }
    }
}

