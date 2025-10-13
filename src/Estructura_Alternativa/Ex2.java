package Estructura_Alternativa;

import java.util.Scanner;

public class Ex2 {

    public static void main(String[] args) {
        final int SOUD = 4;
        final int SOUN = 6;
        final int NITF = 9;
        final int DIAF = 6;
        int horesL, horesD, souT;
        char torn;
        int diumenge;

        Scanner tec = new Scanner(System.in);

        System.out.println("Especifica si pertanys al torn diurn o nocturn(D/N): ");
        torn = tec.next().charAt(0);
        torn = Character.toUpperCase(torn);

        if (torn != 'D' && torn != 'N') {
            System.out.println("El torn que has introduït no és vàlid");

        } else {
            if (torn == 'D') {
                System.out.println("Introdueix un 1 si has treballat diumenge i un 2 si no has treballat diumenge: ");
                diumenge = tec.nextInt();
                if (diumenge == 1) {
                    System.out.println("Introdueix les hores treballades el diumenge: ");
                    horesD = tec.nextInt();
                    System.out.println("Introdueix les hores treballades durant dies laborals: ");
                    horesL = tec.nextInt();
                    souT = (horesD * DIAF) + (horesL * SOUD);

                    System.out.println("El sou que et correspon és de " + souT + " euros.");

                } else {
                    System.out.println("Introdueix les hores que has treballat: ");
                    horesL = tec.nextInt();
                    souT = horesL * SOUD;
                    System.out.println("El sou que et correspon és de " + souT + " euros.");
                }

            } else {
                System.out.println("Introdueix un 1 si has treballat diumenge i un 2 si no has treballat diumenge: ");
                diumenge = tec.nextInt();
                if (diumenge == 1) {
                    System.out.println("Introdueix les hores treballades diumenge: ");
                    horesD = tec.nextInt();
                    System.out.println("Introdueix les hores treballades durant dies laborals: ");
                    horesL = tec.nextInt();
                    souT = (horesD * NITF) + (horesL * SOUN);
                    System.out.println("El sou que et correspon és de " + souT + " euros.");
                } else {
                    System.out.println("Introdueix les hores que has treballat: ");
                    horesL = tec.nextInt();
                    souT = horesL * SOUN;
                    System.out.println("El sou que et correspon és de " + souT + " euros.");

                }
            }
        }

    }

}
