package Estructura_Alternativa;

import java.util.Scanner;

public class Ex9 {
    public static void main(String[] args) {
        int diaA, dies, mesA, anyA;
        boolean bisext = true;
        Scanner tec = new Scanner(System.in);
        System.out.println("Introdueix l'any actual:");
        anyA = tec.nextInt();
        System.out.println("Introdueix el mes actual:");
        mesA = tec.nextInt();
        System.out.println("Introdueix el dia actual");
        diaA = tec.nextInt();
        bisext = ((anyA % 4 == 0) && (anyA % 100 != 0)) || (anyA % 400 == 0);
        if (diaA > 31 || mesA > 12) {
            System.out.println("La data no és vàlida.");
        } else {
            int diaSeguent = diaA + 1;
            switch (mesA) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                    dies = 31;
                    if(diaSeguent > 31){
                        diaSeguent =1;
                        mesA++;
                    }
                    break;
                case 12:
                    dies = 31;
                    if (diaSeguent > 31) {
                        diaSeguent = 1;
                        mesA = 1;
                        anyA++;
                        if (mesA > 12) {
                            mesA = 1;
                        }
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    dies = 30;
                    if (diaSeguent > 30) {
                        diaSeguent = 1;
                        mesA++;
                    }
                    break;
                case 2:
                    dies = 28;
                    if (bisext) {
                        if (diaSeguent > 29) {
                            diaSeguent = 1;
                            mesA++;
                        }
                    }
                    break;
                default:
                    dies = -1;
            }
            System.out.println("La data és: " + diaSeguent + " /" + mesA + " /" + anyA);
        }
    }
}


