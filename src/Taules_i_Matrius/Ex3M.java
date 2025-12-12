package Taules_i_Matrius;

/**
 * Fes un programa que donada una matriu d’enters de 2 files i 3 columnes (amb
 * els valors introduïts per codi), calculi la mitjana de tots els valors i
 * indiqui quants valors estan per sobra de la mitjana i quants per sota.
 */
import java.util.Scanner;

public class Ex3M {

    public static void main(String[] args) {

        int[][] matriu = new int[2][3];
        Scanner tec = new Scanner(System.in);
        int suma = 0;
        int avg = 0;
        int cont = 0;

        for (int i = 0; i < matriu.length; i++) {
            for (int j = 0; j < matriu[i].length; j++) {
                System.out.println("Introdueix números fins omplir la matriu.");
                matriu[i][j] = tec.nextInt();
                suma += matriu[i][j];
                cont++;
            }
        }
        avg = suma / cont;
        int contMaj = 0;
        int contMen = 0;
        for (int i = 0; i < matriu.length; i++) {
            for (int j = 0; j < matriu.length; j++) {
                if (matriu[i][j] > avg) {
                    contMaj++;
                } else if (matriu[i][j] > avg) {
                    contMen++;
                }
            }
        }
        System.out.println("Nombres per sobre la mitja: " + contMaj + "\n Nombres per sota la mitja: " + contMen);
    }

}
