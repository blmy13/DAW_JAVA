package Estructura_Alternativa;

import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        int modulA, modulB, modulC, modulD, modulE, any, diumP;
        Scanner tec = new Scanner(System.in);
        System.out.println("Introdueix l'any del que vols saber el dia de Pascua: ");
        any = tec.nextInt();
        modulA = any % 19;
        modulB = any % 4;
        modulC = any % 7;
        modulD = (19 * modulA + 24) % 30;
        modulE = (2 * modulB + 4 * modulC + 6 * modulD + 5) % 7;
        if (modulE + modulD < 10) {
            diumP = (22 + modulD + modulE);
            System.out.println("El diumenge de pascua és " + diumP + " de Març.");
        } else {
            diumP = (modulD + modulE - 9);
            System.out.println("El diumenge de pascua és " + diumP + " d'Abril.");
        }
    }
}

