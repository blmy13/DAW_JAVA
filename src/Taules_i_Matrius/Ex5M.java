package Taules_i_Matrius;

/*
Donada una matriu de 3 files i 4 columnes (amb els valors introduïts per
codi), crea la matriu transposada, és a dir intercanviant files per columnes
(la fila 1 es convertirà en la columna 1, la fila 2 en la columna 2, .....)
 */

public class Ex5M {

    public static void main(String[] args) {

        int[][] matriu = {{7,8,9,0},{4,5,6,0},{1,2,3,0}};

        int filesOriginals = matriu.length;
        int columnesOriginals = matriu[0].length;
        int[][] matriuTransposada = new int[columnesOriginals][filesOriginals];

        for (int i = 0; i < filesOriginals; i++) {
            for (int j = 0; j < columnesOriginals; j++) {
                matriuTransposada[j][i] = matriu[i][j];
            }

        }

    }
}
