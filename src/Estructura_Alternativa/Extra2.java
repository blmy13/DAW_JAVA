package Estructura_Alternativa;

import java.util.Scanner;

public class Extra2 {

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);

        System.out.println("Introdueix un dia:");
        int dia = tec.nextInt();

        System.out.println("Introdueix un mes:");
        int mes = tec.nextInt();

        if ((dia > 31 || dia <= 0) || (mes > 12 || mes <= 0)) {
            System.out.println("Data no vàlida.");

        } else {
            String estacio, zodiac;
        }

    }

}
