package Exam_Test;

//Programa que a partir d'una data introduïda per l'usuari diu la data que serà en 5 dies.

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {

        boolean bisext;
        int any, mes, dia;
        Scanner tec = new Scanner(System.in);

        System.out.println("Introdueix un any: ");
        any = tec.nextInt();

        bisext = ((any % 4 == 0) && (any % 100 != 0)) || (any % 400 == 0);

        System.out.println("Introdueix un mes:");
        mes = tec.nextInt();

        System.out.println("Introdueix un dia:");
        dia = tec.nextInt();

        if (dia > 31 || dia < 1 || mes < 1 || mes > 13) {
            System.out.println("Data no vàlida.");
        }

        int diesMes = switch (mes) {
            case 4, 6, 9, 11 -> 30;
            case 2 -> bisext ? 29 : 28;
            default -> 31;
        };

        if (dia > diesMes) {
            System.out.println("Data no vàlida per al mes indicat.");

        }

        int dia5 = dia + 5;

        while (dia5 > diesMes) {
            dia5 -= diesMes;
            mes++;
            if (mes > 12) {
                mes = 1;
                any++;
            }


            bisext = ((any % 4 == 0) && (any % 100 != 0)) || (any % 400 == 0);
            diesMes = switch (mes) {
                case 4, 6, 9, 11 -> 30;
                case 2 -> bisext ? 29 : 28;
                default -> 31;
            };
        }

        System.out.println("D'aquí 5 dies serà: " + dia5 + "/" + mes + "/" + any);
    }
}
