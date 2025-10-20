package While;

//Determina si un número enter es primer o no

import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);
        System.out.println("Introdueix un número");
        int num = tec.nextInt();
        int div = 2;
        boolean primer = true;

        if (num <= 1) {

            primer = false;
        }

        while (div < num && primer) {

            if (num % div == 0) {
                primer = false;
            }

            div++;
        }

        String resultat = primer ? "El número que has introduït és primer." : "El número que has introduït no és primer.";
    }
}
