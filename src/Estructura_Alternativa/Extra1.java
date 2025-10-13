package Estructura_Alternativa;

import java.util.Scanner;

public class Extra1 {

    public static void main(String[] args) {
        int nota, notaRecu = 0, cond, rec;
        boolean conducta, recu;
        Scanner tec = new Scanner(System.in);

        System.out.println("Introdueix la nota de l'alumne");
        nota = tec.nextInt();

        System.out.println("Introdueix un 1 si l'alumne ha tingut una conducta positiva o un 2 si ha tingut conducta negativa.");
        cond = tec.nextInt();

        System.out.println("Introdueix un 1 si l'alumne no ha assistit a recuperació i un 1 si ha assistit a recuperació.");
        rec = tec.nextInt();

        if ((cond != 1 && cond != 2) || (rec != 1 && rec != 2)) {
            System.out.println("Has introduït un número incorrecte.");
            return;
        }
        if (cond == 2) {
            conducta = true;
        } else {
            conducta = false;
        }
        if (rec == 2){
            recu = true;
        } else {
            recu = false;
        }
        
        if (recu){
            System.out.println("Introdueix la nota de la recuperació:");
            notaRecu = tec.nextInt();
        }
        if (nota < 0 || nota > 10){
            System.out.println("La nota no és vàlida");
        } else {
            switch (nota){
                case 5, 6:
                    System.out.println("Aprovat.");
                    if (conducta){
                        System.out.println("Suspès per conducta.");
                    } else {
                        System.out.println("Aprovat.");
                    }
                case 7, 8:
                    if (conducta){
                        System.out.println("Aprovat.");
                    } else {
                        System.out.println("Notable.");
                    }
                case 9, 10:
                    if (conducta){
                        System.out.println("Notable");
                    } else {
                        System.out.println("Excel·lent.");
                    }
                case 0, 1, 2, 3:
                    System.out.println("Suspès.");
                case 4:
                    if (recu){
                        if (notaRecu >= 4){
                            System.out.println("Aprovat per recuperació.");
                        }
                    }
            }
        }
    }

}
