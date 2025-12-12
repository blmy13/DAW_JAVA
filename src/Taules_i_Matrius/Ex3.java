package Taules_i_Matrius;

/*
Escriure un programa que, donat una taula de 10 enters (introduïts per codi),
li doni la volta. Per exemple, si el vector original és : 0-1-2-3-4-5-6-7-8-9
acabi sent : 9-8-7-6-5-4-3-2-1-0. No s'ha de fer servir cap taula auxiliar.
*/

public class Ex3 {

    public static void main(String[] args) {

        int[] taula = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        int longitud = taula.length;
        int temp;

        for (int i = 0; i < longitud / 2; i++) {
            int index = longitud - 1 - i;

            temp = taula[i];

            taula[i] = taula[index];

            taula[index] = temp;
        }

        System.out.print("Taula Invertida: ");
        for (int i = 0; i < taula.length; i++) {
            System.out.print(taula[i] + (i < taula.length - 1 ? "-" : ""));
        }
        System.out.println();
    }

}

