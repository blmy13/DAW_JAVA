package Random;

import java.util.Scanner;

public class P1 {

    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);
        System.out.println("Introdueix la mida del diamant:");
        int mida = tec.nextInt();
        System.out.println("Introdueix el número de nivells (files de la piràmide):");
        int nivell = tec.nextInt();

        int filesTotal = 2 * mida - 1;

        for (int l = 1; l <= nivell; l++) {

            int diamantsPerFila = (int) Math.pow(2, l - 1);

            for (int filesDiamant = 1; filesDiamant <= filesTotal; filesDiamant++) {

                boolean isTopHalf = filesDiamant <= mida;
                int i;
                if (isTopHalf) {
                    i = filesDiamant;
                } else {
                    i = filesTotal - filesDiamant + 1;
                }

                for (int h = 1; h <= diamantsPerFila; h++) {

                    for (int j = 1; j <= mida - i; j++) {
                        System.out.print(" ");
                    }

                    int ampladaFila = 2 * i - 1;
                    for (int k = 1; k <= ampladaFila; k++) {
                        if (k == 1 || k == ampladaFila) {
                            System.out.print("*");
                        } else {
                            System.out.print(" ");
                        }
                    }

                    int espaiRestant = mida - i;
                    for (int s = 1; s <= espaiRestant; s++) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
}
