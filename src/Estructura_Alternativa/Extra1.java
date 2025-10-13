package Estructura_Alternativa;

import java.util.Scanner;

public class Extra1 {

    public static void main(String[] args) {
        int nota, notaRecu = 0, cond, rec = 0;
        boolean conducta, recu;
        Scanner tec = new Scanner(System.in);

        System.out.println("Introdueix la nota de l'alumne");
        nota = tec.nextInt();

        System.out.println("Introdueix un 1 si l'alumne ha tingut una conducta positiva o un 2 si ha tingut conducta negativa.");
        cond = tec.nextInt();

        if ((cond != 1 && cond != 2)) {
            System.out.println("Has introduït un número incorrecte.");

        }
        if (cond == 2) {
            conducta = true;
        } else {
            conducta = false;
        }

        if (nota < 0 || nota > 10) {
            System.out.println("La nota no és vàlida");
        } else {
            switch (nota) {
                case 5, 6:
                    if (conducta) {
                        System.out.println("Suspès per conducta.");
                    } else {
                        System.out.println("Aprovat.");
                    }
                    break;
                case 7, 8:
                    if (conducta) {
                        System.out.println("Aprovat.");
                    } else {
                        System.out.println("Notable.");
                    }
                    break;
                case 9, 10:
                    if (conducta) {
                        System.out.println("Notable");
                    } else {
                        System.out.println("Excel·lent.");
                    }
                    break;
                case 0, 1, 2, 3:
                    System.out.println("Suspès.");
                    break;
                case 4:
                    System.out.println("L'alumne ha assistit a recuperació? Si no és el cas introdueix 1, sinó introdueix 2.");
                    rec = tec.nextInt();
                    if (rec == 2) {
                        recu = true;
                    } else {
                        recu = false;
                    }

                    if (recu) {
                        System.out.println("Introdueix la nota de l'examen de recuperació.");
                        tec.nextInt();
                        if (notaRecu >= 4) {
                            System.out.println("Aprovat per recuperació.");
                        }
                    }

            }
        }
    }

}
