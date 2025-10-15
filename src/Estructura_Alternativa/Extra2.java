package Estructura_Alternativa;

import java.util.Scanner;

public class Extra2 {

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        String estacio, zodiac, cuspide;
        boolean valid = true;
        boolean esCuspide = false;

        System.out.println("Introdueix un dia:");
        int dia = tec.nextInt();

        System.out.println("Introdueix un mes:");
        int mes = tec.nextInt();

        if (mes > 12 || mes <= 0) {
            valid = false;
        }
        switch (mes) {
            case 4, 6, 9, 11: {

                if (dia > 30) {
                    valid = false;
                }
                break;
            }
            case 2:
                if (dia > 29) {
                    valid = false;
                }
                break;

            default:
                if (dia > 31) {
                    valid = false;
                }
                break;
        }
        if (valid) {
            if ((dia >= 21 && mes == 12) || mes == 1 || mes == 2 || (dia <= 20 && mes == 3)) {
                estacio = "Hivern.";
            } else if ((dia > 20 && mes == 3) || mes == 4 || mes == 5 || (dia <= 20 && mes == 6)) {
                estacio = "Primavera.";
            } else if ((dia > 20 && mes == 6) || mes == 7 || mes == 8 || (dia <= 22 && mes == 9)) {
                estacio = "Estiu.";
            } else {
                estacio = "Tardor.";
            }
            System.out.println("L'estació és: " + estacio);

            if ((dia >= 21 && mes == 3) || (dia <= 19 && mes == 4)) {
                zodiac = "Àries";
            } else if ((dia > 19 && mes == 4) || (dia <= 20 && mes == 5)) {
                zodiac = "Taure";
            } else if ((dia > 20 && mes == 5) || (dia <= 20 && mes == 6)) {
                zodiac = "Bessons";
            } else if ((dia > 20 && mes == 6) || (dia <= 22 && mes == 7)) {
                zodiac = "Cranc";
            } else if ((dia > 22 && mes == 7) || (dia <= 22 && mes == 8)) {
                zodiac = "Leo";
            } else if ((dia > 22 && mes == 8) || (dia <= 22 && mes == 9)) {
                zodiac = "Verge";
            } else if ((dia > 22 && mes == 9) || (dia <= 22 && mes == 10)) {
                zodiac = "Balança";
            } else if ((dia > 22 && mes == 10) || (dia <= 21 && mes == 11)) {
                zodiac = "Escorpí";
            } else if ((dia > 21 && mes == 11) || (dia <= 21 && mes == 12)) {
                zodiac = "Sagitari";
            } else if ((dia > 21 && mes == 12) || (dia <= 19 && mes == 1)) {
                zodiac = "Capricorn";
            } else if ((dia > 19 && mes == 1) || (dia <= 18 && mes == 2)) {
                zodiac = "Aquari";
            } else {
                zodiac = "Peixos";
            }

            System.out.println("El teu zodíac és: " + zodiac);

            if (mes == 1 && (dia >= 19 && dia <= 21)) {
                esCuspide = true;
            } else if (mes == 2 && (dia >= 18 && dia <= 20)) {
                esCuspide = true;
            } else if (mes == 3 && (dia >= 20 && dia <= 22)) {
                esCuspide = true;
            } else if (mes == 4 && (dia >= 19 && dia <= 21)) {
                esCuspide = true;
            } else if (mes == 5 && (dia >= 20 && dia <= 22)) {
                esCuspide = true;
            } else if (mes == 6 && (dia >= 20 && dia <= 22)) {
                esCuspide = true;
            } else if (mes == 7 && (dia >= 22 && dia <= 24)) {
                esCuspide = true;
            } else if (mes == 8 && (dia >= 22 && dia <= 24)) {
                esCuspide = true;
            } else if (mes == 9 && (dia >= 22 && dia <= 24)) {
                esCuspide = true;
            } else if (mes == 10 && (dia >= 22 && dia <= 24)) {
                esCuspide = true;
            } else if (mes == 11 && (dia >= 21 && dia <= 23)) {
                esCuspide = true;
            } else if (mes == 12 && (dia >= 21 && dia <= 23)) {
                esCuspide = true;
            }
            String missatgeCuspide = esCuspide ? "Atenció: Ets a la cúspide entre dos signes!" : "No ets a la cúspide";
            System.out.println(missatgeCuspide);

        } else {
            System.out.println("El dia o mes no és vàlid.");
        }

    }

}