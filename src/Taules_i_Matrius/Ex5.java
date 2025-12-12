package Taules_i_Matrius;

/*
Donades dues taules d’enters inicialitzades per codi, fes un programa que
ens mostri els valors que estan repetits a les dues taules.
*/

public class Ex5 {

    public static void main(String[] args) {

        int[] taula1 = {-3, 5, 1, -4, 8, 20, -9, 2, 11, -1};
        int[] taula2 = {6, 7, 1, 57, 55, 11, 3, 9, 1, 18, -84};

        for (int j : taula1) {
            for (int k : taula2) {
                if (j == k) {
                    System.out.println(j + " " + k + " son valors repetits");
                }
            }
        }
    }
}
