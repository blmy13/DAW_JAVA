package Taules_i_Matrius;

public class ExempleMatriu {

    public static void main(String[] args) {

        int notes[][] = new int[30][8]; //DECLARA NOMBRE DE COMUMNES X FILA 
        notes[0] = new int[5];
        notes[1] = new int[8];

        // notes[0].length; PER SABER EL NOMBRE DE COLUMNES X FILA
        //ESQUEMA DE RECORREGUT
        for (int i = 0; i < notes.length; i++) {
            for (int j = 0; j < notes[i].length; j++) {
                System.out.print(notes[i][j] + " ");
            }
            System.out.println(" ");
        }

        //ESQUEMA DE CERCA
        int i = 0;
        boolean trobat = false;
        while (i < notes.length && !trobat) {
            int j = 0;
            while (j < notes[i].length && !trobat) {
                if (notes[i][j] == 0) {
                    trobat = true;
                }
                j++;
            }
            i++;
        }
        String result = trobat ? "Hi ha un zero." : "No hi ha cap zero";
        System.out.println(result);
    }
}
