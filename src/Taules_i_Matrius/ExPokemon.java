package Taules_i_Matrius;

import java.util.Random;

public class ExPokemon {

    private static final int MAX_POKEMON = 10;

    public static void main(String[] args) {

        Random r = new Random();
        int[] taula1 = new int[MAX_POKEMON];
        int[] taula2 = new int[MAX_POKEMON];
        int contJ1 = 0;
        int contJ2 = 0;

        for (int i = 0; i < taula1.length; i++) {
            taula1[i] = r.nextInt(100) + 1;
            taula2[i] = r.nextInt(100) + 1;
        }

        int combats = MAX_POKEMON;

        System.out.println("Resultat de cada combat");
        while (combats != 0) {
            int max1 = Integer.MIN_VALUE;
            int max2 = Integer.MIN_VALUE;
            int posicio1 = 0;
            int posicio2 = 0;

            for (int i = 0; i < taula2.length; i++) {
                if (taula1[i] > max1) {
                    max1 = taula1[i];
                    posicio1 = i;
                }
                if (taula2[i] > max2) {
                    max2 = taula2[i];
                    posicio2 = i;
                }
            }
            taula1[posicio1] = 0;
            taula2[posicio2] = 0;

            if (max1 > max2) {
                contJ1++;
            } else if (max1 < max2) {
                contJ2++;
            } else {
                contJ1++;
                contJ2++;
            }

            System.out.println("Màxim jugador 1 --> " + max1 + "  Màxim jugador 2 --> " + max2);

            combats--;
        }
        System.out.println("Resultat final \n ***************************** \nJugador 1: " + contJ1 + "\n" + "Jugador 2: " + contJ2);

    }

}
