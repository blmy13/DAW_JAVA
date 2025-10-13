package Estructura_Alternativa;

import java.util.Scanner;

public class Extra1 {

    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);

        System.out.println("Introdueix la nota de l'alumne");
        double nota = tec.nextDouble();

        System.out.println("L'alumne ha tingut una conducta negativa? (true/false)");
        boolean cnegativa = tec.nextBoolean();

        System.out.println("L'alumne ha assistit a recuperació? (true/false)");
        boolean recu = tec.nextBoolean();

        if (nota < 0 || nota > 10) {
            System.out.println("❌ Nota no vàlida.");
        } else {
            String resultat;

            if (nota < 5) {
                if (recu && nota >= 4) {
                    System.out.println("Introdueix la nota de la recuperació:");
                    double notaR = tec.nextDouble();
                    if (notaR >= 5) {
                        resultat = "Aprovat per recuperació.";
                    } else {
                        resultat = "Recuperació suspesa.";
                    }
                } else {
                    resultat = "Suspès.";
                }
            } else if (nota < 7) {
                resultat = "Aprovat.";
            } else if (nota < 9) {
                resultat = "Notable.";
            } else {
                resultat = "Excel·lent.";
            }

            if (cnegativa) {
                switch (resultat) {
                    case "Excel·lent." -> resultat = "Notable.";
                    case "Notable." -> resultat = "Aprovat.";
                    case "Aprovat.", "Aprovat per recuperació." -> resultat = "Suspès per conducta negativa.";
                }
            }

            System.out.println("El resultat final és: " + resultat);
        }

    }
}
